package com.uncc.mhealth.dao;

import java.util.List;

import com.uncc.mhealth.model.BacLog;
import com.uncc.mhealth.model.ProsCons;

public interface ProsConsDAO {
	public List<ProsCons> list();

	public List<ProsCons> get(int id);

	public void saveOrUpdate(ProsCons user);

	public void delete(int id);
	
}
