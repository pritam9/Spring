package com.uncc.health.binge.dao;

import java.util.List;

import com.uncc.health.binge.hibernate.Appointment;
import com.uncc.health.binge.hibernate.DailyData;
import com.uncc.health.binge.hibernate.Notifications;
import com.uncc.health.binge.hibernate.PhysicalData;
import com.uncc.health.binge.hibernate.StepWiseMessage;
import com.uncc.health.binge.hibernate.User;
import com.uncc.health.binge.hibernate.WeeklyData;

public interface MobileDao {

	User getLoginUser(String username);

	List<DailyData> getFoodData(String username, String date);

	List<PhysicalData> getPhysicalActivity(String username, String date);

	List<Notifications> getNotifications(String username);

	boolean saveFoodLog(DailyData foodLog);

	boolean saveActivityLog(PhysicalData activityLog);

	List<WeeklyData> getWeeklyData(int user_id);

	void updateWeeklyData(WeeklyData weeklyData);

	WeeklyData getWeeklyDataToUpdate(int week_id);

	List<DailyData> getFoodData(int username);

	List<Appointment> getUpcomingAppointments();

	List<StepWiseMessage> getMotivation();

}
