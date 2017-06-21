package com.uncc.mhealth.dao;

import java.util.List;

import com.uncc.mhealth.model.MI;


public interface MIDAO {
	public List<MI> list();

	public MI get(int id);

	public void saveOrUpdate(MI mi);

	public void delete(int id);
	
}
