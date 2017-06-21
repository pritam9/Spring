package com.uncc.health.binge.service.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.uncc.health.binge.dao.MobileDao;
import com.uncc.health.binge.hibernate.Appointment;
import com.uncc.health.binge.hibernate.DailyData;
import com.uncc.health.binge.hibernate.Notifications;
import com.uncc.health.binge.hibernate.PhysicalData;
import com.uncc.health.binge.hibernate.StepWiseMessage;
import com.uncc.health.binge.hibernate.Supporter;
import com.uncc.health.binge.hibernate.User;
import com.uncc.health.binge.hibernate.WeeklyData;
import com.uncc.health.binge.service.MobileService;

public class MobileServiceImpl implements MobileService {
	private MobileDao mobileDao;
	
	

	public MobileDao getMobileDao() {
		return mobileDao;
	}



	public void setMobileDao(MobileDao mobileDao) {
		this.mobileDao = mobileDao;
	}



	@Override
	public User getUserWithCredentials(String username, String password) {
		// TODO Auto-generated method stub
		User loginUser=mobileDao.getLoginUser(username);
		//System.out.println("password is -"+loginBean.getPassword());
		if(loginUser!=null)
		{	
			if(password.equals(loginUser.getPassword()))
				return loginUser;
		}
		return null;
	}



	@Override
	public List<DailyData> getFoodData(String username, String date) {
		// TODO Auto-generated method stub
		return mobileDao.getFoodData(username,date);
	}



	@Override
	public List<PhysicalData> getPhysicalActivity(String username, String date) {
		// TODO Auto-generated method stub
		return mobileDao.getPhysicalActivity(username,date);
	}



	@Override
	public List<Notifications> getNotifications(String username) {
		// TODO Auto-generated method stub
		return mobileDao.getNotifications(username);
	}



	@Override
	public Date getDate(String parameter, String parameter2) {
		// TODO Auto-generated method stub
		   String startDate=parameter+" "+parameter2;
		   SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd h:mm a");
		   java.util.Date date;
		try {
			date = sdf1.parse(startDate);
			Date sqlStartDate = new Date(date.getTime());
			return sqlStartDate;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



	@Override
	public boolean saveFoodLog(DailyData foodLog) {
		// TODO Auto-generated method stub
		return mobileDao.saveFoodLog(foodLog);
	}



	@Override
	public boolean saveActivityLog(PhysicalData activityLog) {
		// TODO Auto-generated method stub
		return mobileDao.saveActivityLog(activityLog);
	}



	@Override
	public List<WeeklyData> getWeeklyData(int user_id) {
		// TODO Auto-generated method stub
		return mobileDao.getWeeklyData(user_id);
	}



	@Override
	public void updateWeeklyData(WeeklyData weeklyData) {
		// TODO Auto-generated method stub
		mobileDao.updateWeeklyData(weeklyData);
	}



	@Override
	public WeeklyData getWeeklyDataToUpdate(int week_id) {
		// TODO Auto-generated method stub
		return mobileDao.getWeeklyDataToUpdate(week_id);
	}



	@Override
	public List<DailyData> getDaywiseFood(int username) {
		// TODO Auto-generated method stub
		return mobileDao.getFoodData(username);
	}



	@Override
	public List<Appointment> getUpcomingAppointments() {
		// TODO Auto-generated method stub
		return mobileDao.getUpcomingAppointments();
	}



	@Override
	public void saveNotifications() {
		// TODO Auto-generated method stub
		//mobileDao.getUpcomingAppointments()
	}



	@Override
	public List<StepWiseMessage> getMotivation() {
		// TODO Auto-generated method stub
		return mobileDao.getMotivation();
	}
	
	

}
