package com.uncc.health.binge.hibernate;

import java.sql.Date;
import java.sql.Timestamp;

public class PhysicalData {
	int pa_id,no_of_day,duration,p_id;
	Date i_date,a_date;
	String activity;
	//User user;
	public int getPa_id() {
		return pa_id;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public void setPa_id(int pa_id) {
		this.pa_id = pa_id;
	}
	public int getNo_of_day() {
		return no_of_day;
	}
	public void setNo_of_day(int no_od_day) {
		this.no_of_day = no_od_day;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
	public Date getI_date() {
		return i_date;
	}
	public void setI_date(Date i_date) {
		this.i_date = i_date;
	}
	public Date getA_date() {
		return a_date;
	}
	public void setA_date(Date a_date) {
		this.a_date = a_date;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	
	
	

}
