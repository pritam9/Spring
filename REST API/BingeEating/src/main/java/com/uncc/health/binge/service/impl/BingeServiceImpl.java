package com.uncc.health.binge.service.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.auth0.jwt.internal.org.bouncycastle.util.Times;
import com.uncc.health.binge.dao.MobileDao;
import com.uncc.health.binge.dao.ServerDao;
import com.uncc.health.binge.hibernate.Appointment;
import com.uncc.health.binge.hibernate.DailyData;
import com.uncc.health.binge.hibernate.Notifications;
import com.uncc.health.binge.hibernate.PhysicalData;
import com.uncc.health.binge.hibernate.StepWiseMessage;
import com.uncc.health.binge.hibernate.Supporter;
import com.uncc.health.binge.hibernate.User;
import com.uncc.health.binge.hibernate.WeeklyData;
import com.uncc.health.binge.service.BingeService;


public class BingeServiceImpl implements BingeService {
		private MobileDao mobileDao;
		private ServerDao serverDao;
		public MobileDao getMobileDao() {
			return mobileDao;
		}
		public void setMobileDao(MobileDao mobileDao) {
			this.mobileDao = mobileDao;
		}
		public ServerDao getServerDao() {
			return serverDao;
		}
		public void setServerDao(ServerDao serverDao) {
			this.serverDao = serverDao;
		}
		@Override
		public Supporter isValidAdmin(String username, String password) {
			// TODO Auto-generated method stub
			Supporter loginBean=serverDao.getLoginSupporter(username);
			//System.out.println("password is -"+loginBean.getPassword());
			if(loginBean==null)
				return null;
			else if(password.equals(loginBean.getPassword()))
				return loginBean;
			return null;
		}
		@Override
		public List<User> getAllUsers(int supporter_id) {
			// TODO Auto-generated method stub
			return serverDao.getAllUsers(supporter_id);
		}
		@Override
		public void saveUser(User patientBean) {
			// TODO Auto-generated method stub
			serverDao.saveUser(patientBean);
		}
		@Override
		public Supporter getSupporter(int suporter_id) {
			// TODO Auto-generated method stub
			return serverDao.getLoginSupporter(suporter_id+"");
		}
		@Override
		public List<DailyData> getDailyData(String p_id) {
			// TODO Auto-generated method stub
			return serverDao.getDailyData(p_id);
		}
		@Override
		public List<PhysicalData> getActivityData(int p_id) {
			// TODO Auto-generated method stub
			return serverDao.getActivityData(p_id);
		}
		@Override
		public boolean saveNotification(Notifications notif) {
			// TODO Auto-generated method stub
			return serverDao.saveNotification(notif);
		}
		@Override
		public Timestamp getSqlDate(String a_date, String a_time) {
			// TODO Auto-generated method stub
			String startDate=a_date+" "+a_time;
			   SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			   java.util.Date date;
			try {
				date = sdf1.parse(startDate);
				Timestamp sqlStartDate = new Timestamp(date.getTime());
				return sqlStartDate;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		@Override
		public boolean saveAppointment(Appointment appoint) {
			// TODO Auto-generated method stub
			return serverDao.saveAppointment(appoint);
		}
		@Override
		public void saveSupporter(Supporter supporter) {
			// TODO Auto-generated method stub
			serverDao.saveSupporter(supporter);
		}
		@Override
		public List<WeeklyData> getWeeklyData(int parseInt) {
			// TODO Auto-generated method stub
			return serverDao.getWeeklyData(parseInt);
		}
		@Override
		public User getUserDetails(String p_id) {
			// TODO Auto-generated method stub
			return serverDao.getUserDetails(p_id);
		}
		@Override
		public void sendNotif(StepWiseMessage stepWiseMessage) {
			// TODO Auto-generated method stub
			serverDao.sendNotif(stepWiseMessage);
		}
		
		
		
}
