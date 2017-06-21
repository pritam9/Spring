package com.uncc.mhealth.dao;

import java.util.List;

import com.uncc.mhealth.model.User;

public interface UserDAO {
	public List<User> list();

	public User get(int id);

	public void saveOrUpdate(User user);

	public void delete(int id);
	
	public User get(String username);
	
	public User getUserFromToken(String username);
	
//	public User getUserFromToken_ver2(String username);
}
