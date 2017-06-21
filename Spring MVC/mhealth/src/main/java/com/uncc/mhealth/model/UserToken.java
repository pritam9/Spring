package com.uncc.mhealth.model;

import java.io.Serializable;

public class UserToken implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user_id;
	private String token;
	private String session_token;
	private String isWithNewCert;


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public String getSession_token() {
		return session_token;
	}


	public void setSession_token(String session_token) {
		this.session_token = session_token;
	}
	
	public String getIsWithNewCert() {
		return isWithNewCert;
	}


	public void setIsWithNewCert(String isWithNewCert) {
		this.isWithNewCert = isWithNewCert;
	}


	@Override
	public String toString() {
		return "UserToken [user_id=" + user_id + ", token=" + token + ", session_token=" + session_token + " isWithNewCert="+isWithNewCert+" ]";
	}

		
	
}
