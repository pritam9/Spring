package com.uncc.mhealth.job;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.uncc.mhealth.config.Constants;
import com.uncc.mhealth.dao.BacLogDAO;
import com.uncc.mhealth.dao.FeedbackDAO;
import com.uncc.mhealth.dao.TriviaScoreDAO;
import com.uncc.mhealth.dao.UserDAO;
import com.uncc.mhealth.dao.UserMIMappingDAO;
import com.uncc.mhealth.dao.UserTokenDAO;
import com.uncc.mhealth.model.Feedback;
import com.uncc.mhealth.model.PF;
import com.uncc.mhealth.model.User;
import com.uncc.mhealth.model.UserToken;
import com.uncc.mhealth.service.MiService;
import com.uncc.mhealth.service.PushService;
import com.uncc.mhealth.utils.CalendarUtils;

public class MyJob extends QuartzJobBean {
    private UserDAO userDao;
	private String name;
	private UserMIMappingDAO userMIMappingDao;
	private FeedbackDAO feedbackDao;
	private UserTokenDAO userTokenDao;
    private BacLogDAO bacLogDAO;
    private TriviaScoreDAO triviaScoreDao;
	private MiService miService;
	private PushService pushService;
	
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	

	public void setUserMIMappingDao(UserMIMappingDAO userMIMappingDao) {
		this.userMIMappingDao = userMIMappingDao;
	}


	public void setFeedbackDao(FeedbackDAO feedbackDao) {
		this.feedbackDao = feedbackDao;
	}


	public void setUserTokenDao(UserTokenDAO userTokenDao) {
		this.userTokenDao = userTokenDao;
	}
	
	public void setBacLogDAO(BacLogDAO bacLogDAO) {
		this.bacLogDAO = bacLogDAO;
	}
	
	public void setMiService(MiService miService){
		this.miService = miService;
	}
	
	public void setPushService(PushService pushService){
		this.pushService = pushService;
	}


	protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
		System.out.println("@@ Job scheduled"+new Date(System.currentTimeMillis()).toString());
		int currentTime = calculateTimeZone();
		int dow = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
		if(currentTime == -1){
			//TODO: should not be here 
			return;
		}
		
		List<Feedback> feedbackList = feedbackDao.list();
		for(Feedback fb : feedbackList){
			ObjectMapper mapper = new ObjectMapper();
			PF pf = null;
			try {
				pf = mapper.readValue(fb.getFeedback(), PF.class);
				System.out.println("Current Time ::"+currentTime);
				System.out.println("User ID ::"+fb.getUser_id());
				if(matchesPreferredTime(pf, currentTime, dow)){
					System.out.println("Matches for "+fb.getUser_id());
					User user = userDao.get(fb.getUser_id());
					List<UserToken> tokenList = userTokenDao.get(user.getId());
					if(user.isPf()){
						//PF is already sent
//						if(user.isGoal()) {
							//goal is already sent TODO: goal has been removed from this flow
							if(user.isStrategy()) {
								//strategy is already sent
								long day = CalendarUtils.calculateCurrentDays(user.getRegistrationDate());
								if(day > 1 && day < 15){
									miService.startBacFlow(user.getId(), pf);
									if(day == 7 || day == 14){
										//wait for some time before sending weekly summary message
										//Thread.sleep(1 * 60 * 1000);
										//miService.sendProsConsMessage(user.getId(), pf);
										miService.createFutureMI(user.getId(), -1, 1 * 60 * 1000);
									}
								} else {
									System.out.println("This is a first day and everything is complete or 2 week period is over");
								}
							} else {
								//send strategy message
								miService.sentSelectedMessages(38, user.getId(), pf);
								pushService.pushMessage(tokenList, Constants.Message.NEW_MESSAGE);
							}
//						} else {
//							//send Goal message
//							MiService.sentSelectedMessages(34, user.getId(), userMIMappingDao, pf, bacLogDAO, userDao, triviaScoreDao);
//							PushService.pushMessage(tokenList, "New Message from SmarTrek");
//						}
					} else {
						//send PF message
						miService.sentSelectedMessages(6, user.getId(), pf);
						pushService.pushMessage(tokenList, Constants.Message.NEW_MESSAGE);
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
		
		
	}
	
	private boolean matchesPreferredTime(PF pf, int currentTime, int dow) {
		boolean matches = false;
		switch(dow){
		case Calendar.MONDAY:
			if(currentTime == pf.preferredTimeMon){
				matches = true;
				System.out.println("Monday it is!!");
			}
			break;
		case Calendar.TUESDAY:
			if(currentTime == pf.preferredTimeTue){
				matches = true;
				System.out.println("Tuesday it is!!");
			}
			break;
		case Calendar.WEDNESDAY:
			if(currentTime == pf.preferredTimeTue){
				matches = true;
				System.out.println("Wednesday it is!!");
			}
			break;
		case Calendar.THURSDAY:
			if(currentTime == pf.preferredTimeTue){
				matches = true;
				System.out.println("Thursday it is!!");
			}
			break;
		case Calendar.FRIDAY:
			if(currentTime == pf.preferredTimeTue){
				matches = true;
				System.out.println("Friday it is!!");
			}
			break;
		case Calendar.SATURDAY:
			if(currentTime == pf.preferredTimeTue){
				matches = true;
				System.out.println("Saturday it is!!");
			}
			break;
		case Calendar.SUNDAY:
			if(currentTime == pf.preferredTimeTue){
				matches = true;
				System.out.println("Sunday it is!!");
			}
			break;
			
		}
		return matches;
	}


	private int calculateTimeZone() {
		int time = -1;

		Calendar date = Calendar.getInstance();
//		date.set(Calendar.HOUR_OF_DAY, 9);//TODO: remove this as this is just for testing purpose
		int hours = date.get(Calendar.HOUR_OF_DAY);
		
		switch (hours) {
		case 8:
			time = PF.AM8to9_15;
			break;
		case 9:
			time = PF.AM9_30to10_45;
			break;
		case 11:
			time = PF.AM11to12_15;
			break;
		case 12:
			time = PF.PM12_30to1_45;
			break;
		case 14:
			time = PF.PM2to3_15;
			break;
		case 15:
			time = PF.PM3_30to4_45;
			break;
		case 17:
			time = PF.PM5to6_15;
			break;
		case 18:
			time = PF.PM6_30to7_45;
			break;
		case 20:
			time = PF.PM8to9_15;
			break;
		}
		return time;

	}


	public void setName(String name) {
		this.name = name;
	}
}
