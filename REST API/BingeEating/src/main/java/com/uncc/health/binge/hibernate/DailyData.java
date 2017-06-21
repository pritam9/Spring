package com.uncc.health.binge.hibernate;

import java.sql.Date;


public class DailyData {
	int d_id,servings,no_of_day,p_id;
	Date i_date; Date a_date;
	String food,context,feelings,img_url; 
	boolean binge,vld;
	
	//User user;
	public int getD_id() {
		return d_id;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public void setD_id(int d_id) {
		this.d_id = d_id;
	}
	public int getServings() {
		return servings;
	}
	public void setServings(int servings) {
		this.servings = servings;
	}
	public int getNo_of_day() {
		return no_of_day;
	}
	public void setNo_of_day(int no_of_day) {
		this.no_of_day = no_of_day;
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
	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getFeelings() {
		return feelings;
	}
	public void setFeelings(String feelings) {
		this.feelings = feelings;
	}
	public boolean isBinge() {
		return binge;
	}
	public void setBinge(boolean binge) {
		this.binge = binge;
	}
	public boolean isVld() {
		return vld;
	}
	public void setVld(boolean vld) {
		this.vld = vld;
	}
	
	

}
