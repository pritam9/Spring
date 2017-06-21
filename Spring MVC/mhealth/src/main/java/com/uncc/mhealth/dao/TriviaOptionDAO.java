package com.uncc.mhealth.dao;

import java.util.List;

import com.uncc.mhealth.model.Option;
import com.uncc.mhealth.model.TriviaOption;;

public interface TriviaOptionDAO {
	public List<TriviaOption> list();

	public TriviaOption get(int id);

	public void saveOrUpdate(TriviaOption user);

	public void delete(int id);
}
