package com.uncc.mhealth.model;

public class ProsCons {
	int id;
	int user_id;
	String pros_cons;
	String updated_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getPros_cons() {
		return pros_cons;
	}
	public void setPros_cons(String pros_cons) {
		this.pros_cons = pros_cons;
	}
	public String getUpdated_time() {
		return updated_time;
	}
	public void setUpdated_time(String updated_time) {
		this.updated_time = updated_time;
	}
	@Override
	public String toString() {
		return "ProsCons [id=" + id + ", user_id=" + user_id + ", pros_cons=" + pros_cons + ", updated_time="
				+ updated_time + "]";
	}
}
