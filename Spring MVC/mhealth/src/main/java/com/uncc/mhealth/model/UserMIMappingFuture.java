package com.uncc.mhealth.model;

public class UserMIMappingFuture {
	int mi_id;
	int user_id;
	int id;
	String future_time;
	String pendingStatus;

	public UserMIMappingFuture(){
		
	}
	
	public UserMIMappingFuture(int user_id, int mi_id, String future_time,String pendingStatus) {
		// TODO Auto-generated constructor stub
		this.mi_id = mi_id;
		this.user_id = user_id;
		this.future_time=future_time;
		this.pendingStatus=pendingStatus;
	}
	public int getMi_id() {
		return mi_id;
	}
	public void setMi_id(int mi_id) {
		this.mi_id = mi_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getFuture_time() {
		return future_time;
	}

	public void setFuture_time(String future_time) {
		this.future_time = future_time;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getPendingStatus() {
		return pendingStatus;
	}

	public void setPendingStatus(String pendingStatus) {
		this.pendingStatus = pendingStatus;
	}

	@Override
	public String toString() {
		return "UserMIMapping [mi_id=" + mi_id + ", user_id=" + user_id
				+ ", id=" + id + ", future_time=" + future_time +", pendingStatus="+ pendingStatus+"]";
	}
	
	
	
}
