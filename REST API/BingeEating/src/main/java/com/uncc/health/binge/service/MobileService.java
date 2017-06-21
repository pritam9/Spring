package com.uncc.health.binge.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.uncc.health.binge.hibernate.Appointment;
import com.uncc.health.binge.hibernate.DailyData;
import com.uncc.health.binge.hibernate.Notifications;
import com.uncc.health.binge.hibernate.PhysicalData;
import com.uncc.health.binge.hibernate.StepWiseMessage;
import com.uncc.health.binge.hibernate.User;
import com.uncc.health.binge.hibernate.WeeklyData;

public interface MobileService {
	User getUserWithCredentials(String username, String password);

	List<DailyData> getFoodData(String username, String date);

	List<PhysicalData> getPhysicalActivity(String username, String date);

	List<Notifications> getNotifications(String username);

	Date getDate(String parameter, String parameter2);

	boolean saveFoodLog(DailyData foodLog);

	boolean saveActivityLog(PhysicalData activityLog);

	List<WeeklyData> getWeeklyData(int user_id);

	void updateWeeklyData(WeeklyData updatedData);

	WeeklyData getWeeklyDataToUpdate(int week_id);

	List<DailyData> getDaywiseFood(int username);

	List<Appointment> getUpcomingAppointments();

	void saveNotifications();

	List<StepWiseMessage> getMotivation();
}
