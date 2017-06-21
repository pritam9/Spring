package com.uncc.health.binge.hibernate;


import java.sql.Timestamp;

public class Appointment {
	int appointment_id,p_id;
	Timestamp appointment_date,created_date;
	public int getAppointment_id() {
		return appointment_id;
	}
	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public Timestamp getAppointment_date() {
		return appointment_date;
	}
	public void setAppointment_date(Timestamp appointment_date) {
		this.appointment_date = appointment_date;
	}
	public Timestamp getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Timestamp created_date) {
		this.created_date = created_date;
	}
	
	
	
}
