package com.uncc.mhealth.model;

import java.io.Serializable;

public class UserSurvey implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	String response;
	String survey;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String getSurvey() {
		return survey;
	}
	public void setSurvey(String survey) {
		this.survey = survey;
	}
	@Override
	public String toString() {
		return "UserSurvey [id=" + id + ", response=" + response + ", survey=" + survey + "]";
	}
	
	
}
