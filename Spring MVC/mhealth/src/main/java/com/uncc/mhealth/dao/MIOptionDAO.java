package com.uncc.mhealth.dao;

import java.util.List;

import com.uncc.mhealth.model.MIOption;;

public interface MIOptionDAO {
	public List<MIOption> list();

	public MIOption get(int id);

	public void saveOrUpdate(MIOption user);

	public void delete(int id);
}
