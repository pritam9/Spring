package com.uncc.health.binge.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.uncc.health.binge.dao.MobileDao;
import com.uncc.health.binge.hibernate.Appointment;
import com.uncc.health.binge.hibernate.DailyData;
import com.uncc.health.binge.hibernate.Notifications;
import com.uncc.health.binge.hibernate.PhysicalData;
import com.uncc.health.binge.hibernate.StepWiseMessage;
import com.uncc.health.binge.hibernate.Supporter;
import com.uncc.health.binge.hibernate.User;
import com.uncc.health.binge.hibernate.WeeklyData;

public class MobileDaoImpl implements MobileDao {
	private SessionFactory sessionFactory;

	public MobileDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public User getLoginUser(String username) {
		int id = Integer.parseInt(username);
		User loginBean = 
                (User)sessionFactory.getCurrentSession().get(User.class, id);
		return loginBean;
	}

	@Override
	@Transactional
	public List<DailyData> getFoodData(String username, String date) {
		int p_id=Integer.parseInt(username);
		String sql = "SELECT * FROM daily_data WHERE p_id = :p_id and cast(a_date as date) = :date"; // order by survey_id DESC
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.addEntity(DailyData.class);
		query.setParameter("p_id", p_id);
		query.setParameter("date", date);
		//query.setMaxResults(33);
		return query.list();
	}

	@Override
	@Transactional
	public List<PhysicalData> getPhysicalActivity(String username, String date) {
		// TODO Auto-generated method stub
		int p_id=Integer.parseInt(username);
		String sql = "SELECT * FROM pysical_activity WHERE p_id = :p_id and cast(a_date as date) = :date"; // order by survey_id DESC
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.addEntity(PhysicalData.class);
		query.setParameter("p_id", p_id);
		query.setParameter("date", date);
		//query.setMaxResults(33);
		return query.list();
	}

	@Override
	@Transactional
	public List<Notifications> getNotifications(String username) {
		// TODO Auto-generated method stub
		int p_id=Integer.parseInt(username);
		String sql = "SELECT * FROM notifications WHERE p_id = :p_id"; // order by survey_id DESC
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.addEntity(Notifications.class);
		query.setParameter("p_id", p_id);
		//query.setParameter("date", date);
		//query.setMaxResults(33);
		return query.list();
	}

	@Override
	@Transactional
	public boolean saveFoodLog(DailyData foodLog) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(foodLog);
		if(foodLog.getD_id()>0)
			return true;
		return false;
	}

	@Override
	@Transactional
	public boolean saveActivityLog(PhysicalData activityLog) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(activityLog);
		if(activityLog.getPa_id()>0)
			return true;
		return false;
	}

	@Override
	@Transactional
	public List<WeeklyData> getWeeklyData(int user_id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM weekly_data WHERE p_id = :p_id order by a_date asc"; // order by survey_id DESC
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.addEntity(WeeklyData.class);
		query.setParameter("p_id", user_id);
		//query.setMaxResults(33);
		return query.list();
	}

	@Override
	@Transactional
	public void updateWeeklyData(WeeklyData weeklyData) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(weeklyData);
		//return null;
	}

	@Override
	@Transactional
	public WeeklyData getWeeklyDataToUpdate(int week_id) {
		// TODO Auto-generated method stub
		return (WeeklyData)sessionFactory.getCurrentSession().get(WeeklyData.class, week_id);
	}

	@Override
	@Transactional
	public List<DailyData> getFoodData(int username) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM daily_data WHERE p_id = :p_id"; // order by survey_id DESC
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.addEntity(DailyData.class);
		query.setParameter("p_id", username);
		
		//query.setMaxResults(33);
		return query.list();
	}

	@Override
	@Transactional
	public List<Appointment> getUpcomingAppointments() {
		// TODO Auto-generated method stub
		String sql = "select * from appointment where DATEDIFF(appointment_date,CURDATE())=1"; // order by survey_id DESC
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.addEntity(Appointment.class);
		
		
		//query.setMaxResults(33);
		return query.list();
	}

	@Override
	@Transactional
	public List<StepWiseMessage> getMotivation() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM message"; // order by survey_id DESC
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.addEntity(StepWiseMessage.class);
		//query.setParameter("p_id", username);
		
		//query.setMaxResults(33);
		return query.list();
	}
}
