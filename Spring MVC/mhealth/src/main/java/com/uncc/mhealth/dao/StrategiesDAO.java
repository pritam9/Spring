package com.uncc.mhealth.dao;

import java.util.List;

import com.uncc.mhealth.model.Strategies;

public interface StrategiesDAO {
	public List<Strategies> list();

	public Strategies get(int id);

	public void saveOrUpdate(Strategies user);

	public void delete(int id);
	
	public List<Strategies>  list(int user_id);
}
