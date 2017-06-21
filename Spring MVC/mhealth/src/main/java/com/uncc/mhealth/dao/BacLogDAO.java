package com.uncc.mhealth.dao;

import java.util.List;

import javafx.util.Pair;

import com.uncc.mhealth.model.BacLog;

public interface BacLogDAO {
	public List<BacLog> list();

	public List<BacLog> get(int id);

	public void saveOrUpdate(BacLog user);

	public void delete(int id);
	
	public List<BacLog>  list(int user_id, String log_date);

}
