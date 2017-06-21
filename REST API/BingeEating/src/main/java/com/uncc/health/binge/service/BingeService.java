package com.uncc.health.binge.service;

import java.sql.Timestamp;
import java.util.List;

import com.uncc.health.binge.hibernate.Appointment;
import com.uncc.health.binge.hibernate.DailyData;
import com.uncc.health.binge.hibernate.Notifications;
import com.uncc.health.binge.hibernate.PhysicalData;
import com.uncc.health.binge.hibernate.StepWiseMessage;
import com.uncc.health.binge.hibernate.Supporter;
import com.uncc.health.binge.hibernate.User;
import com.uncc.health.binge.hibernate.WeeklyData;

public interface BingeService {

	Supporter isValidAdmin(String username, String password);

	List<User> getAllUsers(int supporter_id);

	void saveUser(User patientBean);

	Supporter getSupporter(int suporter_id);

	List<DailyData> getDailyData(String p_id);

	List<PhysicalData> getActivityData(int p_id);

	boolean saveNotification(Notifications notif);

	Timestamp getSqlDate(String a_date, String a_time);

	boolean saveAppointment(Appointment appoint);

	void saveSupporter(Supporter supporter);

	List<WeeklyData> getWeeklyData(int parseInt);

	User getUserDetails(String p_id);

	void sendNotif(StepWiseMessage stepWiseMessage);

	

}
