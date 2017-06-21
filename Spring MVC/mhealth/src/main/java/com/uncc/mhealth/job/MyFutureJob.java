package com.uncc.mhealth.job;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.uncc.mhealth.config.Constants.Message;
import com.uncc.mhealth.dao.BacLogDAO;
import com.uncc.mhealth.dao.FeedbackDAO;
import com.uncc.mhealth.dao.TriviaScoreDAO;
import com.uncc.mhealth.dao.UserDAO;
import com.uncc.mhealth.dao.UserMIMappingDAO;
import com.uncc.mhealth.dao.UserTokenDAO;
import com.uncc.mhealth.model.BacLog;
import com.uncc.mhealth.model.Feedback;
import com.uncc.mhealth.model.MI;
import com.uncc.mhealth.model.PF;
import com.uncc.mhealth.model.UserMIMapping;
import com.uncc.mhealth.model.UserMIMappingFuture;
import com.uncc.mhealth.model.UserToken;
import com.uncc.mhealth.service.BacService;
import com.uncc.mhealth.service.MiService;
import com.uncc.mhealth.service.PushService;

public class MyFutureJob extends QuartzJobBean {
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
		System.out.println("@@ Future Job scheduled" + new Date(System.currentTimeMillis()).toString());
		List<UserMIMappingFuture> futureList = userMIMappingDao.futurelist();
		for (UserMIMappingFuture userMIFuture : futureList) {
			if (userMIFuture.getMi_id() == 71) {
				UserMIMapping userMiMap = null;
				MI mi = userMIMappingDao.getMIObj(userMIFuture.getMi_id());
				Feedback feedback = feedbackDao.get(userMIFuture.getUser_id());
				ObjectMapper mapper = new ObjectMapper();
				PF pf;
				try {
					pf = mapper.readValue(feedback.getFeedback(), PF.class);
					userMiMap = miService.createMIPlan(userMIFuture.getUser_id(), mi.getNext(), pf);
					if (userMiMap != null && userMiMap.getMi_id() > 0) {
						miService.updateUserMI(userMIFuture.getUser_id(), "" + userMiMap.getId(), UserMIMapping.SENT,
								UserMIMapping.NOT_AVAILABLE, null, pf);
						List<UserToken> tokenList = userTokenDao.get(userMIFuture.getUser_id());
						pushService.pushMessage(tokenList, Message.NEW_MESSAGE);
						userMIFuture.setPendingStatus("N");
						userMIMappingDao.saveOrUpdate(userMIFuture);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (userMIFuture.getMi_id() == 400) {
				miService.fetchNextStaticContent(userMIFuture.getUser_id());
				userMIFuture.setPendingStatus("N");
				userMIMappingDao.saveOrUpdate(userMIFuture);
			} else if (userMIFuture.getMi_id() == 65) {
				UserMIMapping userMiMap = null;
				MI mi = userMIMappingDao.getMIObj(userMIFuture.getMi_id());
				BacLog bacLog = BacService.getBacForYesterday(userMIFuture.getUser_id(), bacLogDAO);
				Feedback feedback = feedbackDao.get(userMIFuture.getUser_id());
				ObjectMapper mapper = new ObjectMapper();
				PF pf;
				try {
					pf = mapper.readValue(feedback.getFeedback(), PF.class);
					if (bacLog == null) {
						userMiMap = miService.createMIPlan(userMIFuture.getUser_id(), 71, pf);
					} else {
						// user did enter new BAc for yesterday, go ahead and
						// send BAC related information
						userMiMap = miService.createMIPlan(userMIFuture.getUser_id(), mi.getNext(), pf);
					}
					if (userMiMap != null && userMiMap.getMi_id() > 0) {
						miService.updateUserMI(userMIFuture.getUser_id(), "" + userMiMap.getId(), UserMIMapping.SENT,
								UserMIMapping.NOT_AVAILABLE, null, pf);
						List<UserToken> tokenList = userTokenDao.get(userMIFuture.getUser_id());
						pushService.pushMessage(tokenList, Message.NEW_MESSAGE);
						userMIFuture.setPendingStatus("N");
						userMIMappingDao.saveOrUpdate(userMIFuture);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

			}else if (userMIFuture.getMi_id() == -1) {
				//sends summary message for day 1 and 14
				Feedback feedback = feedbackDao.get(userMIFuture.getUser_id());
				ObjectMapper mapper = new ObjectMapper();
				PF pf;
				try {
					pf = mapper.readValue(feedback.getFeedback(), PF.class);
					miService.sendProsConsMessage(userMIFuture.getUser_id(), pf);
					userMIFuture.setPendingStatus("N");
					userMIMappingDao.saveOrUpdate(userMIFuture);
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void setName(String name) {
		this.name = name;
	}
}
