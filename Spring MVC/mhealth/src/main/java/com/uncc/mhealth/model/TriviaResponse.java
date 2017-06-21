package com.uncc.mhealth.model;

public class TriviaResponse {
	private String token;
	private TriviaQuestion question;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public TriviaQuestion getQuestion() {
		return question;
	}
	public void setQuestion(TriviaQuestion question) {
		this.question = question;
	}
	@Override
	public String toString() {
		return "TriviaResponse [token=" + token + ", question=" + question + "]";
	}
	
	
}
