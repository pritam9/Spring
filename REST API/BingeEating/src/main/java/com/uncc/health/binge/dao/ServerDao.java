package com.uncc.health.binge.dao;

import java.util.List;

import com.uncc.health.binge.hibernate.Appointment;
import com.uncc.health.binge.hibernate.DailyData;
import com.uncc.health.binge.hibernate.Notifications;
import com.uncc.health.binge.hibernate.PhysicalData;
import com.uncc.health.binge.hibernate.StepWiseMessage;
import com.uncc.health.binge.hibernate.Supporter;
import com.uncc.health.binge.hibernate.User;
import com.uncc.health.binge.hibernate.WeeklyData;

public interface ServerDao {

	

	List<User> getAllUsers(int supporter_id);

	Supporter getLoginSupporter(String username);

	void saveUser(User patientBean);

	List<DailyData> getDailyData(String p_id);

	List<PhysicalData> getActivityData(int p_id);

	boolean saveNotification(Notifications notif);

	boolean saveAppointment(Appointment appoint);

	void saveSupporter(Supporter supporter);

	List<WeeklyData> getWeeklyData(int parseInt);

	User getUserDetails(String p_id);

	void sendNotif(StepWiseMessage stepWiseMessage);

}
