package com.uncc.mhealth.dao;

import java.util.List;

import com.uncc.mhealth.model.TriviaScore;
import com.uncc.mhealth.model.User;

public interface TriviaScoreDAO {
	public List<TriviaScore> list();

	public TriviaScore get(int id);

	public void saveOrUpdate(TriviaScore score);

	public void delete(int id);
	
	public TriviaScore getHighScore();
	
}
