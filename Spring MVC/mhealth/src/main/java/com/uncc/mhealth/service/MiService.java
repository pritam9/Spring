package com.uncc.mhealth.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uncc.mhealth.config.Constants;
import com.uncc.mhealth.config.Constants.Message;
import com.uncc.mhealth.dao.BacLogDAO;
import com.uncc.mhealth.dao.TriviaScoreDAO;
import com.uncc.mhealth.dao.UserDAO;
import com.uncc.mhealth.dao.UserMIMappingDAO;
import com.uncc.mhealth.dao.UserTokenDAO;
import com.uncc.mhealth.model.BacLog;
import com.uncc.mhealth.model.MI;
import com.uncc.mhealth.model.PF;
import com.uncc.mhealth.model.TriviaScore;
import com.uncc.mhealth.model.User;
import com.uncc.mhealth.model.UserMIMapping;
import com.uncc.mhealth.model.UserMIMappingFuture;
import com.uncc.mhealth.model.UserToken;
import com.uncc.mhealth.utils.CalendarUtils;

@Service
public class MiService {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private UserDAO userDao;
	@Autowired
	private UserMIMappingDAO userMiMappingDao;
	@Autowired
	private UserTokenDAO userTokenDao;
	@Autowired
	private BacLogDAO bacLogDao;
	@Autowired
	private TriviaScoreDAO triviaScoreDao;
	@Autowired
	private PushService pushService;

	/**
	 * sends first three messages
	 * 
	 * @param user_id
	 */
	@Transactional
	public void sentWelcomeMessages(int user_id) {
		try {
			Criteria cr = sessionFactory.getCurrentSession().createCriteria(MI.class);
			Criterion  first=Restrictions.eq("id",1);
			Criterion  third=Restrictions.eq("id",3);
			LogicalExpression orExp = Restrictions.or(first, third);
			cr.add( orExp );
			@SuppressWarnings("unchecked")
			List<MI> listMI = (List<MI>) cr.list();
			for (MI mi : listMI) {
				String sentTime = new Date(System.currentTimeMillis()).toString();
				UserMIMapping map = new UserMIMapping(user_id, mi.getId(), UserMIMapping.SENT, UserMIMapping.NOT_OPENED,
						mi.getText(), sentTime);
				userMiMappingDao.saveOrUpdate(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * sends first three messages
	 * 
	 * @param user_id
	 */
	@Transactional
	public void sentSelectedMessages(int message_id, int user_id, PF pf) {
		try {
			Criteria cr = sessionFactory.getCurrentSession().createCriteria(MI.class);
			Criterion  ct=Restrictions.eq("id",message_id);
			cr.add( ct );
			@SuppressWarnings("unchecked")
			List<MI> listMI = (List<MI>) cr.list();

			for (MI mi : listMI) {

				String sentTime = new Date(System.currentTimeMillis()).toString();

				String updated_string = mi.getText();
				try {
					updated_string = createDynamicContent(pf, mi, user_id);
				} catch (Exception e) {
					e.printStackTrace();
				}

				UserMIMapping map = new UserMIMapping(user_id, mi.getId(), UserMIMapping.SENT, UserMIMapping.NOT_OPENED,
						updated_string, sentTime);
				userMiMappingDao.saveOrUpdate(map);
			}
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}

	}

	@Transactional
	public List<UserMIMapping> getUserMIList(int id) {

		List<UserMIMapping> userMiList = new ArrayList<UserMIMapping>();
		try {

			userMiList = userMiMappingDao.list(id, UserMIMapping.RECEIVED);

			for (UserMIMapping map : userMiList) {

				Criteria cr = sessionFactory.getCurrentSession().createCriteria(MI.class);
				Criterion  ct=Restrictions.eq("id",map.getMi_id());
				cr.add( ct );
				@SuppressWarnings("unchecked")
				List<MI> listMI = (List<MI>) cr.list();

				for (MI mi : listMI) {

					map.setType(mi.getType());

					map.setTitle(mi.getTitle());

					map.setOption_type(mi.getOption_type());

					map.setDateTime(mi.getDateTime());

					map.setMioptions(mi.getMioptions());

					map.setText(map.getUpdated_text());
				}
			}

		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		return userMiList;
	}
	@Transactional
	public List<UserMIMapping> getUserMINew(int id) {

		List<UserMIMapping> userMiList = new ArrayList<UserMIMapping>();
		try {

			userMiList = userMiMappingDao.list(id, UserMIMapping.SENT);

			for (UserMIMapping map : userMiList) {

				Criteria cr = sessionFactory.getCurrentSession().createCriteria(MI.class);
				Criterion  ct=Restrictions.eq("id",map.getMi_id());
				cr.add( ct );
				@SuppressWarnings("unchecked")
				List<MI> listMI = (List<MI>) cr.list();

				for (MI mi : listMI) {

					map.setType(mi.getType());

					map.setTitle(mi.getTitle());

					map.setOption_type(mi.getOption_type());

					map.setDateTime(mi.getDateTime());

					map.setMioptions(mi.getMioptions());

					map.setText(map.getUpdated_text());
				}

				map.setSent(UserMIMapping.RECEIVED);
				userMiMappingDao.saveOrUpdate(map);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userMiList;
	}

	/**
	 * updates the user_mi_mapping: 1. updates sent, opened and answer 2. if
	 * dynamic link then creates user_mi_mapping for linked mi based on answer
	 * and inserts into user_mi_mapping 3. if opened then then creates
	 * user_mi_mapping for next mi and inserts into user_mi_mapping
	 * 
	 * @param id
	 * @param messageId
	 * @param sent
	 * @param opened
	 * @param answer
	 * @return
	 */
	@Transactional
	public UserMIMapping updateUserMI(int user_id, String user_mi_map_id, int sent, int opened, String answer, PF pf) {
		UserMIMapping userMiMap = null;
		try {
			UserMIMapping map = updateUserMIMapping(Integer.parseInt(user_mi_map_id), sent, opened, answer);
			if (userMiMappingDao.isLastSentMsg(user_id, Integer.parseInt(user_mi_map_id))) {
			Criteria cr = sessionFactory.getCurrentSession().createCriteria(MI.class);
			Criterion  ct=Restrictions.eq("id",map.getMi_id());
			cr.add( ct );
			@SuppressWarnings("unchecked")
			List<MI> listMI = (List<MI>) cr.list();
			MI mi = null;
			if (listMI.size() > 0)
				mi = listMI.get(0);
			// this is dynamic link, where next message will sent based on user
			// response
			if (answer != null && mi != null && mi.getOption_type() == MI.OPTION_TYPE_DYNAMIC_LINK) {
				if( (mi.getId() == 38 || mi.getId()==34) && answer.equals("61")){
					//To eliminate duplicate 61 message
				}else{
					userMiMap = createMIPlan(user_id, Integer.parseInt(answer), pf);
				}// set PF, strategy & goal fields of user depending on mi_id and
				// response
				switch (mi.getId()) {
				case 6:// PF
					if (answer.equals("7")) {
						User user = userDao.get(user_id);
						user.setPf(true);
						userDao.saveOrUpdate(user);
					}
					break;
				case 34:// Goal
					if (answer.equals("35")) {
						User user = userDao.get(user_id);
						user.setGoal(true);
						userDao.saveOrUpdate(user);
					} else if (answer.equals("61")) {
						// here BAC flow might start, check day before starting
						userMiMap = null;
						long day = CalendarUtils.calculateCurrentDays(userDao.get(user_id).getRegistrationDate());
						if (day > 1) {//
							startBacFlow(user_id, pf);
						}
					}
					break;
				case 38:// Strategy
					if (answer.equals("39")) {
						User user = userDao.get(user_id);
						user.setStrategy(true);
						userDao.saveOrUpdate(user);
					} else if (answer.equals("61")) {
						// here BAC flow might start, check day before starting
						userMiMap = null;
						long day = CalendarUtils.calculateCurrentDays(userDao.get(user_id).getRegistrationDate());
						if (day > 1) {//
							startBacFlow(user_id, pf);
						}
					}
					break;
				}

			} else if (opened == UserMIMapping.OPENED && mi != null && mi.getNext() !=null && mi.getNext() != -1) {
				if (mi.getId() == 52 || mi.getId() == 8) {
					//To eliminate duplicate 61 message
				}else if(mi.getId()==65){
					//To eliminate duplicate 67 message
				}else if(mi.getId() == 71){
					//To eliminate duplicate 71 message
				}else if(mi.getId() == 400){
					//mi.getNext() of 400 has mi_id of 200 which will not be present as it is the last message for the day
				}else{
					userMiMap = createMIPlan(user_id, mi.getNext(), pf);
				}
				if (mi.getId() == 71) {
					/*try {// TODO: This the time for user to enter strategies
						Thread.sleep(15000);
					} catch (Exception e) {
						e.printStackTrace();
					}*/
					createFutureMI(user_id,mi.getId(),15000);
				}

				if (mi.getId() == 400) {
					// this is static content
					// TODO: as per Dr. Kazemi, there should be 3 min delay
					//Thread.sleep(3 * 60 * 1000);
					//fetchNextStaticContent(user_id);
					createFutureMI(user_id,mi.getId(),3 * 60 * 1000);
				}

				if (mi.getId() == 52 || mi.getId() == 8) {// from this point BAC
															// flow may start
					userMiMap = null;
					long day = CalendarUtils.calculateCurrentDays(userDao.get(user_id).getRegistrationDate());
					if(day==1){
						userMiMap = createMIPlan(user_id, mi.getNext(), pf);
					}
					else if (day > 1) {//
						startBacFlow(user_id, pf);
					}else{
						
					}
				}

				if (mi.getId() == 65) {
					// here we are waiting for user to enter BAC details for
					// yesterday;
					/*int waitingTime = 10;// minutes
					BacLog bacLog = BacService.getBacForYesterday(user_id, bacLogDao);
					while (waitingTime > 0) {
						if (bacLog != null)
							break;
						try {
							System.out.println("wait for BAC remaining : " + waitingTime + " mins");
							Thread.sleep(1000 * 60);
						} catch (Exception e) {
							e.printStackTrace();
						}
						bacLog = BacService.getBacForYesterday(user_id, bacLogDao);
						waitingTime--;
					}

					if (bacLog == null) {// user did not enter BAc for
											// yesterday, so send strategy
											// message
						userMiMap = createMIPlan(user_id, 71, pf);
					} else {
						// user did enter new BAc for yesterday, go ahead and
						// send BAC related information
						userMiMap = createMIPlan(user_id, mi.getNext(), pf);
					}*/
					createFutureMI(user_id,mi.getId(),10 * 60 * 1000);
					
				}

				if (mi.getId() == 102 || mi.getId() == 103) {
					long day = CalendarUtils.calculateCurrentDays(userDao.get(user_id).getRegistrationDate());
					if (day == 7) {
						// send this weekly message
						System.out.println("##Sending 7th day message");
					} else if (day == 14) {// send this message only on 7th &
											// 14th day.
						// send this weekly message
						System.out.println("##Sending 14th day message");
					} else {
						//userMiMap = null;
					}
				}

			}
		  }
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		return userMiMap;
	}

	/**
	 * Myths & facts related static content gets created for the user
	 * 
	 * @param user_id
	 */
	@Transactional
	public void fetchNextStaticContent(int user_id) {
		try {
			String sql;
			int firstStatic = -1;
			boolean firstFound = false;
			while (firstFound != true) {
				firstStatic = ThreadLocalRandom.current().nextInt(201, 273 + 1);
				List<UserMIMapping> list = userMiMappingDao.fetchFromMIAndUser(firstStatic, user_id);
				if (list.size() < 1) {
					firstFound = true;
					break;// no need for break, but still using it
				}
			}
			// not applying logic for selecting unique mi, because there are
			// less mi and we might not get all unique for 14 days
			int secondStatic = ThreadLocalRandom.current().nextInt(301, 313 + 1);
			
			
			Criteria cr = sessionFactory.getCurrentSession().createCriteria(MI.class);
			Criterion  first=Restrictions.eq("id",firstStatic);
			Criterion  third=Restrictions.eq("id",secondStatic);
			LogicalExpression orExp = Restrictions.or(first, third);
			cr.add( orExp );
			@SuppressWarnings("unchecked")
			List<MI> listMI = (List<MI>) cr.list();

			// Extract data from result set
			boolean hasMi = false;
			for (MI mi : listMI) {
				hasMi = true;
				String sentTime = new Date(System.currentTimeMillis()).toString();

				UserMIMapping map = new UserMIMapping(user_id, mi.getId(), UserMIMapping.SENT, UserMIMapping.NOT_OPENED,
						mi.getText(), sentTime);
				userMiMappingDao.saveOrUpdate(map);
			}
			if (hasMi) {
				List<UserToken> tokenList = userTokenDao.get(user_id);
				pushService.pushMessage(tokenList, Constants.Message.NEW_MESSAGE);
			}

		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}

	}

	/**
	 * updates the open, answer & sent values with their respective timestamp
	 * 
	 * @param user_mi_map_id
	 * @param sent
	 * @param opened
	 * @param answer
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public UserMIMapping updateUserMIMapping(int user_mi_map_id, int sent, int opened, String answer) throws Exception {
		UserMIMapping map = userMiMappingDao.get(user_mi_map_id);
		if (sent != -1) {
			map.setSent(sent);
		} else if (opened != -1) {
			map.setOpen(opened);
			map.setOpen_time(new Date(System.currentTimeMillis()).toString());
		} else if (answer != null) {
			map.setAnswer(answer);
			map.setRespond_time(new Date(System.currentTimeMillis()).toString());
		} else {
			return map;
		}
		userMiMappingDao.saveOrUpdate(map);
		return map;
	}

	// /**
	// * creates an user_mi_entry for the user
	// * @param user_id
	// * @param mi_id
	// * @param pf
	// */
	@Transactional
	public UserMIMapping createMIPlan(int user_id, int mi_id, PF pf) {
		UserMIMapping map = null;
		try {
			Criteria cr = sessionFactory.getCurrentSession().createCriteria(MI.class);
			Criterion  ct=Restrictions.eq("id",mi_id);
			cr.add( ct );
			@SuppressWarnings("unchecked")
			List<MI> listMI = (List<MI>) cr.list();

			// Extract data from result set
			for (MI mi : listMI) {
				String updated_text = createDynamicContent(pf, mi, user_id);
				map = new UserMIMapping(user_id, mi.getId(), 0, 0, updated_text,
						new Date(System.currentTimeMillis()).toString());
				userMiMappingDao.saveOrUpdate(map);

				map.setType(mi.getType());

				map.setTitle(mi.getTitle());

				map.setOption_type(mi.getOption_type());

				map.setDateTime(mi.getDateTime());

				map.setMioptions(mi.getMioptions());
			}

			return map;
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		return null;
	}
	
	@Transactional
	public void createFutureMI(int user_id, int mi_id,int seconds) {
		UserMIMappingFuture userMIFuture=null; 
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String futureTime = sdf.format(new Date(System.currentTimeMillis()+seconds));
		userMIFuture = new UserMIMappingFuture(user_id,mi_id,futureTime,"Y");
				userMiMappingDao.saveOrUpdate(userMIFuture);
	}

	/**
	 * this function uses feedback values of the user to create a personalized
	 * mi messages
	 * 
	 * @param pf
	 * @param mi
	 * @param user_id
	 * @return
	 */
	@Transactional
	private String createDynamicContent(PF pf, MI mi, int user_id) {
		String updated_text = mi.getText();
		switch (mi.getId()) {
		case 9:
			if (pf.pcaCategory.equals("C")) {
				updated_text = Constants.Message.PF_REVIEW_C;
			} else if (pf.pcaCategory.equals("A")) {
				updated_text = Constants.Message.PF_REVIEW_A;
			}
			break;
		case 13:
			updated_text = String.format(mi.getText(), pf.alcoholUsage, (int) pf.alcoholPercentile,
					(int) pf.alcoholPercentile + "%");
			break;
		case 14:
			updated_text = String.format(mi.getText(), pf.averageDrink, (int) pf.drinkPercentile + "%");
			break;
		case 15:
			updated_text = String.format(mi.getText(), pf.averageDrink * 4, pf.total, pf.maxTotal);
			break;
		case 21:
			updated_text = String.format(mi.getText(), pf.firstDrink, pf.firstDrinkHours, pf.typicalBAC, pf.maxTotal,
					pf.maxHours, pf.peakBAC);
			break;
		case 24:
			// "At your peak BAC of %s, it will take you %s hours until you are
			// sober. At your typical BAC of %s, it will take you %s hours until
			// you are sober."
			String peakMsg = "";
			String typicalMsg = "";
			try {
				if (pf.peakSober > 0) {
					peakMsg = String.format(Constants.Message.PF_PEAK, pf.peakBAC, ((int) pf.peakSober));
				}
				if (pf.typicalSober > 0) {
					typicalMsg = String.format(Constants.Message.PF_TYPICAL, pf.typicalBAC, ((int) pf.typicalSober));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			// updated_text = String.format(mi.getText(), pf.peakBAC, peakMsg,
			// pf.typicalBAC,
			// typicalMsg);
			updated_text = peakMsg + typicalMsg;
			break;
		case 25:
			updated_text = String.format(mi.getText(), pf.typicalBAC, pf.typicalSober);
			break;
		case 26:
			updated_text = String.format(mi.getText(), (int) Math.ceil(pf.maxAlcoholCal),
					(int) pf.maxAlcoholPercent + "%");
			break;
		case 28:
			updated_text = String.format(mi.getText(), pf.byaacqScore, pf.byaacqScore, pf.byaacqRange);
			break;
		case 29:
			String highRiskMessage = Constants.Message.PF_HIGH_RISK;
			if ("LOW RISK".equals(pf.auditRisc)) {
				highRiskMessage = "";
			}
			updated_text = String.format(mi.getText(), pf.auditScore, pf.auditRisc, highRiskMessage);
			break;
		case 30:
			String suggestion = "";
			if (pf.geneticRisk != null && (pf.geneticRisk.equals("High") || pf.geneticRisk.equals("Medium"))) {
				suggestion = Constants.Message.PF_GENETIC_SUGGESTION;
			}
			updated_text = String.format(mi.getText(), pf.geneticRisk, suggestion);
			break;
		case 31:
			String improvement1 = Constants.Message.PF_RULER_IMPROVEMENT;
			if (pf.ruler1Text != null && pf.ruler1Text.equals("it is very important")) {
				improvement1 = Constants.Message.PF_RULER_IMP_IMPROVEMENT;
			}
			updated_text = String.format(mi.getText(), pf.ruler1Text, improvement1);
			break;
		case 32:
			String improvement2 = Constants.Message.PF_RULER_IMPROVEMENT1;
			if (pf.ruler2Text != null && pf.ruler2Text.equals("very confident in")) {
				improvement2 = Constants.Message.PF_RULER_IMP_IMPROVEMENT1;
			}
			updated_text = String.format(mi.getText(), pf.ruler2Text, improvement2);
			break;
		case 67:
			BacLog bacLog = BacService.getBacForYesterday(user_id, bacLogDao);
			updated_text = "";
			if (bacLog == null) {
				break;
			}

			if (bacLog.getBac() <= 0.05) {
				if (pf.pcaCategory.equals("P")) {
					updated_text = "Your BAC yesterday is estimated to be " + bacLog.getBac()
							+ ". This means that you experienced a mild level of impairment.  At this level, you may have experienced being more relaxed and social. You may also have experienced mild speech, memory, coordination impairment and some sleepiness. ";
				} else if (pf.pcaCategory.equals("C")) {
					updated_text = "Your BAC yesterday is estimated to be " + bacLog.getBac()
							+ ". This means that you experienced a mild level of impairment.  At this level, you may have experienced being more relaxed and social. You may also have experienced mild speech, memory, coordination impairment and some sleepiness. ";
				} else {
					updated_text = "Your BAC yesterday is estimated to be " + bacLog.getBac()
							+ ". This means that you experienced a mild level of impairment.  At this level, you may have experienced being more relaxed and social. You may also have experienced mild speech, memory, coordination impairment and some sleepiness. ";
				}
			} else if (bacLog.getBac() <= 0.15) {
				if (pf.pcaCategory.equals("P")) {
					updated_text = "Your BAC yesterday is estimated to be " + bacLog.getBac()
							+ ". This means that you likely experienced an increased level of impairment.  Though you may have felt relaxed and more social, you likely experienced some moderate to severe speech, memory, attention, and coordination problems.";
				} else if (pf.pcaCategory.equals("C")) {
					updated_text = "Your BAC yesterday is estimated to be " + bacLog.getBac()
							+ ". This means that you likely experienced an increased level of impairment.  Though you may have felt relaxed and more social, you likely experienced some moderate to severe speech, memory, attention, and coordination problems.";
				} else {
					updated_text = "Your BAC yesterday is estimated to be " + bacLog.getBac()
							+ ". This means that you likely experienced an increased level of impairment.  Though you may have felt relaxed and more social, you likely experienced some moderate to severe speech, memory, attention, and coordination problems.";
				}
			} else if (bacLog.getBac() <= 0.30) {
				if (pf.pcaCategory.equals("P")) {
					updated_text = "Your BAC yesterday is estimated to be " + bacLog.getBac()
							+ ". This means that you were likely severely impaired.  Even if you didn’t realize it, your memory, speech, coordination, attention and balance were all highly impaired, along with your judgment and decision-making skills.  At this BAC level, you were at risk for blacking out, loss of consciousness, and other signs of alcohol poisoning.";
				} else if (pf.pcaCategory.equals("C")) {
					updated_text = "Your BAC yesterday is estimated to be " + bacLog.getBac()
							+ ". This means that you were likely severely impaired.  Even if you didn’t realize it, your memory, speech, coordination, attention and balance were all highly impaired, along with your judgment and decision-making skills.  At this BAC level, you were at risk for blacking out, loss of consciousness, and other signs of alcohol poisoning.";
				} else {
					updated_text = "Your BAC yesterday is estimated to be " + bacLog.getBac()
							+ ". This means that you were likely severely impaired.  Even if you didn’t realize it, your memory, speech, coordination, attention and balance were all highly impaired, along with your judgment and decision-making skills.  At this BAC level, you were at risk for blacking out, loss of consciousness, and other signs of alcohol poisoning.";
				}
			} else {
				if (pf.pcaCategory.equals("P")) {
					updated_text = "Your BAC yesterday is estimated to be " + bacLog.getBac()
							+ ". The BAC you reported is potentially life threatening.  At this BAC level, you were in danger of life-threatening alcohol poisoning and loss of life due to injury or your body shutting down vital life functions.";
				} else if (pf.pcaCategory.equals("C")) {
					updated_text = "Your BAC yesterday is estimated to be " + bacLog.getBac()
							+ ". This is a potentially life-threatening BAC.  At this level, you were in danger of life-threatening alcohol poisoning and loss of life due to injury or your body shutting down vital life functions.";
				} else {
					updated_text = "Your BAC yesterday is estimated to be " + bacLog.getBac()
							+ ". This is a potentially life-threatening BAC.  At this level, you were in danger of life-threatening alcohol poisoning and loss of life due to injury or your body shutting down vital life functions.";
				}
			}

			break;
		case 102:
			if (pf.pcaCategory.equals("P")) {
				updated_text = "Thanks for sharing that information.  In order to make smarter and safer choices about alcohol use if you choose to drink, planning ahead can be very important.  If you do choose to drink tomorrow, you can consider thinking about using at least one of your strategies that you’ve already selected and make plans to make them happen.  Good luck! You will have the opportunity tomorrow to provide information and reflect on how well strategies worked.";
			} else if (pf.pcaCategory.equals("C")) {
				updated_text = "Thanks for sharing that information.  As you continue thinking about making safer choices about your drinking,a good option is for you to make plans to use 2 or more of your strategies that you’ve already selected.  Good luck! You will have the opportunity tomorrow to provide information and reflect on how well strategies worked.";
			} else {
				updated_text = "Thanks for sharing that information.  As you continue to take actions to help make safer choices around drinking, you may want to consider making definite plans to use all of your strategies that you’ve already selected.  Good luck! You will have the opportunity tomorrow to provide information and reflect on how well strategies worked.";
			}
			break;
		case 400:
			updated_text = "Do you want to play Trivia Game ?";
			List<TriviaScore> triviaList = triviaScoreDao.list();
			int max = 0;
			TriviaScore highScore = null;
			for (TriviaScore score : triviaList) {
				if (score.getScore() > max) {
					max = score.getScore();
					highScore = score;
				}
			}
			if (highScore != null) {
				updated_text = "The high scorer for Trivia game today is "
						+ userDao.get(highScore.getUser_id()).getNickname() + " with a score of " + highScore.getScore()
						+ ". Do you want to play?";
			}
			break;
		}

		return updated_text;

	}

	// 65, 67, 71
	/**
	 * bac flow includes, very first message "did you drink yesterday?" If we
	 * already have his drinking log for yesterday then his BAC related message
	 * gets sent
	 * 
	 * @param user_id
	 * @param pf
	 */
	@Transactional
	public void startBacFlow(int user_id, PF pf) {
		// get BAC data for yesterday
		BacLog bacLog = BacService.getBacForYesterday(user_id, bacLogDao);
		if (bacLog == null) {
			// send "did you drink yesterday message"
			sentSelectedMessages(61, user_id, pf);
			pushService.pushMessage(userTokenDao.get(user_id), Message.NEW_MESSAGE);
		} else {
			// tell about BAC
			sentSelectedMessages(67, user_id, pf);
			pushService.pushMessage(userTokenDao.get(user_id), Message.NEW_MESSAGE);
		}
	}
	@Transactional
	public void sendProsConsMessage(int user_id, PF pf) {
		sentSelectedMessages(104, user_id, pf);
		pushService.pushMessage(userTokenDao.get(user_id), Message.NEW_MESSAGE);
	}

}