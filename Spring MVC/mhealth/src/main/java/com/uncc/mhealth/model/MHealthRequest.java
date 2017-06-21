package com.uncc.mhealth.model;

public class MHealthRequest {
	private String token;
	private String survey;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	

	public String getSurvey() {
		return survey;
	}

	public void setSurvey(String survey) {
		this.survey = survey;
	}

	@Override
	public String toString() {
		return "MHealthRequest [token=" + token + ", survey=" + survey + "]";
	}

}
