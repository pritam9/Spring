package com.uncc.mhealth.model;

import java.io.Serializable;

public class UserSurveyResponse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	int questionId;
	String survey;
	String answer;
	int subQuestionId;
	String subAnswer;
	
	public UserSurveyResponse(){
		id=-1;
		questionId=-1;
		survey=null;
		answer=null;
		subQuestionId=-1;
		subAnswer=null;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSurvey() {
		return survey;
	}
	public void setSurvey(String survey) {
		this.survey = survey;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getSubQuestionId() {
		return subQuestionId;
	}
	public void setSubQuestionId(int subQuestionId) {
		this.subQuestionId = subQuestionId;
	}
	public String getSubAnswer() {
		return subAnswer;
	}
	public void setSubAnswer(String subAnswer) {
		this.subAnswer = subAnswer;
	}
	@Override
	public String toString() {
		return "UserSurveyResponse [id=" + id + ", questionId=" + questionId + ", answer=" + answer + ", survey=" + survey + ", subQuestionId=" + subQuestionId + ", subAnswer=" + subAnswer +"]";
	}
	
	
}
