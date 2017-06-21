package com.uncc.health.binge.dao.impl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.uncc.health.binge.dao.ServerDao;
import com.uncc.health.binge.hibernate.Appointment;
import com.uncc.health.binge.hibernate.DailyData;
import com.uncc.health.binge.hibernate.Notifications;
import com.uncc.health.binge.hibernate.PhysicalData;
import com.uncc.health.binge.hibernate.StepWiseMessage;
import com.uncc.health.binge.hibernate.Supporter;
import com.uncc.health.binge.hibernate.User;
import com.uncc.health.binge.hibernate.WeeklyData;




public class ServerDaoImpl implements ServerDao {
	private SessionFactory sessionFactory;

	public ServerDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public Supporter getLoginSupporter(String username) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(username);
		Supporter loginBean = 
                (Supporter)sessionFactory.getCurrentSession().get(Supporter.class, id);
		return loginBean;
	}

	@Override
	@Transactional
	public List<User> getAllUsers(int supporter_id) {
		// TODO Auto-generated method stub
		if(supporter_id>-1){
		String sql = "SELECT * FROM patient WHERE h_id = :h_id"; // order by survey_id DESC
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.addEntity(User.class);
		query.setParameter("h_id", supporter_id);
		//query.setMaxResults(33);
		return query.list();
		}
		else{
			String sql = "SELECT * FROM patient"; // order by survey_id DESC
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
			query.addEntity(User.class);
			//query.setParameter("h_id", supporter_id);
			//query.setMaxResults(33);
			return query.list();
		}
	}

	@Override
	@Transactional
	public void saveUser(User patientBean) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(patientBean);
	}

	@Override
	@Transactional
	public List<DailyData> getDailyData(String p_id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM daily_data WHERE p_id = :p_id order by a_date asc"; // order by survey_id DESC
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.addEntity(DailyData.class);
		query.setParameter("p_id", p_id);
		//query.setMaxResults(33);
		return query.list();
	}

	@Override
	@Transactional
	public List<PhysicalData> getActivityData(int p_id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM pysical_activity WHERE p_id = :p_id order by a_date asc"; // order by survey_id DESC
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.addEntity(PhysicalData.class);
		query.setParameter("p_id", p_id);
		//query.setMaxResults(33);
		return query.list();
	}

	@Override
	@Transactional
	public boolean saveNotification(Notifications notif) {
		// TODO Auto-generated method stub
		
			sessionFactory.getCurrentSession().save(notif);
			if(notif.getNotification_id()>0)
				return true;
			return false;
		
	}

	@Override
	@Transactional
	public boolean saveAppointment(Appointment appoint) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(appoint);
		if(appoint.getAppointment_id()>0)
			return true;
		return false;
	}

	@Override
	@Transactional
	public void saveSupporter(Supporter supporter) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(supporter);
	}

	@Override
	@Transactional
	public List<WeeklyData> getWeeklyData(int parseInt) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM weekly_data WHERE p_id = :p_id order by a_date asc"; // order by survey_id DESC
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.addEntity(WeeklyData.class);
		query.setParameter("p_id", parseInt);
		//query.setMaxResults(33);
		return query.list();
	}

	@Override
	@Transactional
	public User getUserDetails(String p_id) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(p_id);
		User loginBean = 
                (User)sessionFactory.getCurrentSession().get(User.class, id);
		return loginBean;
	}

	@Override
	@Transactional
	public void sendNotif(StepWiseMessage stepWiseMessage) {
		String sql = "SELECT * FROM patient WHERE step = :p_id"; // order by survey_id DESC
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.addEntity(User.class);
		query.setParameter("p_id", stepWiseMessage.getStep_id());
		//query.setMaxResults(33);
		List<User>users = query.list();
		for(User user:users){
			Notifications notif = new Notifications();
			notif.setNotification_text(stepWiseMessage.getMessage_text());
        	notif.setP_id(user.getP_id());
        	notif.setCreated_date_time(new Timestamp(Calendar.getInstance().getTimeInMillis()));
			sessionFactory.getCurrentSession().save(notif);
		}
	}
}
