package com.uncc.health.binge.hibernate;

import java.sql.Date;

public class User {
	int p_id, step; 
	Date s_date;
	String password,f_name,l_name;
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	Supporter supporter;
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public Date getS_date() {
		return s_date;
	}
	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Supporter getSupporter() {
		return supporter;
	}
	public void setSupporter(Supporter supporter) {
		this.supporter = supporter;
	}
	
	
}
