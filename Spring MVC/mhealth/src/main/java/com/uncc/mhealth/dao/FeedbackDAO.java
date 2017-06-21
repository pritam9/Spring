package com.uncc.mhealth.dao;

import java.util.List;

import com.uncc.mhealth.model.Feedback;

public interface FeedbackDAO {
	public List<Feedback> list();

	public Feedback get(int id);

	public void saveOrUpdate(Feedback feedback);

	public void delete(int id);
	
}
