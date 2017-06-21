package com.uncc.health.binge.hibernate;

import java.sql.Date;

public class WeeklyData {
	int w_id, p_id,binge,vld,physical_activity,good_days,weight,fruit_vegetables;
	Date i_date,a_date;  
	String event_data;
	public int getW_id() {
		return w_id;
	}
	public void setW_id(int w_id) {
		this.w_id = w_id;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public int getBinge() {
		return binge;
	}
	public void setBinge(int binge) {
		this.binge = binge;
	}
	public int getVld() {
		return vld;
	}
	public void setVld(int vld) {
		this.vld = vld;
	}
	public int getPhysical_activity() {
		return physical_activity;
	}
	public void setPhysical_activity(int physical_activity) {
		this.physical_activity = physical_activity;
	}
	public int getGood_days() {
		return good_days;
	}
	public void setGood_days(int good_days) {
		this.good_days = good_days;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getFruit_vegetables() {
		return fruit_vegetables;
	}
	public void setFruit_vegetables(int fruit_vegetables) {
		this.fruit_vegetables = fruit_vegetables;
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
	public String getEvent_data() {
		return event_data;
	}
	public void setEvent_data(String event_data) {
		this.event_data = event_data;
	}
	
	

}
