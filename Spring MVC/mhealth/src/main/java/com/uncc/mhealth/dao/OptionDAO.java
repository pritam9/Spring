package com.uncc.mhealth.dao;

import java.util.List;

import com.uncc.mhealth.model.Option;;

public interface OptionDAO {
	public List<Option> list();

	public Option get(int id);

	public void saveOrUpdate(Option user);

	public void delete(int id);
}
