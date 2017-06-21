package com.uncc.mhealth.dao;

import java.util.List;

import com.uncc.mhealth.model.Question;
import com.uncc.mhealth.model.TriviaQuestion;


public interface TriviaQuestionDAO {
	

	public TriviaQuestion get(int id);

	public void saveOrUpdate(TriviaQuestion question);

	public void delete(int id);

	List<TriviaQuestion> list(int category);
}
