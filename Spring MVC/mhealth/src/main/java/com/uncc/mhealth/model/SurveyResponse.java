package com.uncc.mhealth.model;

import java.util.ArrayList;

public class SurveyResponse {
	private String token;
	private String survey;
	private ArrayList<Question> questions;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public ArrayList<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}
	public String getSurvey() {
		return survey;
	}
	public void setSurvey(String survey) {
		this.survey = survey;
	}
	@Override
	public String toString() {
		return "SurveyResponse [token=" + token + ", survey=" + survey + ", questions=" + questions + "]";
	}
	
	
}
