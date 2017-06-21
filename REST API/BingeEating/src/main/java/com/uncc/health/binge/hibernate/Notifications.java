package com.uncc.health.binge.hibernate;


import java.sql.Timestamp;
import java.util.Date;

public class Notifications {
	int notification_id,p_id;
	String notification_text,type="Suggestion";
	Timestamp created_date_time;
	String created_date;
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public int getNotification_id() {
		return notification_id;
	}
	public void setNotification_id(int notification_id) {
		this.notification_id = notification_id;
	}
	public String getNotification_text() {
		return notification_text;
	}
	public void setNotification_text(String notification_text) {
		this.notification_text = notification_text;
	}
	public Timestamp getCreated_date_time() {
		return created_date_time;
	}
	public void setCreated_date_time(Timestamp created_date) {
		this.created_date_time = created_date;
		setCreated_date();
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date() {
		this.created_date = (new Date(created_date_time.getTime())+"").substring(0, 19);
	}
	
}
