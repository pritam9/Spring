package com.uncc.mhealth.dao;

import java.util.List;

import com.uncc.mhealth.model.Question;


public interface QuestionDAO {
	public List<Question> list();

	public Question get(int id);
	
	public Question getQuestion(int id);

	public void saveOrUpdate(Question user);

	public void delete(int id);

	List<Question> getSurvey(String survey);
	
	List<Question> getSurvey(String survey,int pageNo);
	
	List<Question> getSixWeekSurvey(String survey,int pageNo);
	
}
