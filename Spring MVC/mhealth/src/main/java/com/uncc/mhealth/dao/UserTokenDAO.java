package com.uncc.mhealth.dao;

import java.util.List;

import com.uncc.mhealth.model.User;
import com.uncc.mhealth.model.UserToken;

public interface UserTokenDAO {
	public List<UserToken> list();

	public List<UserToken> get(int id);

	public void saveOrUpdate(UserToken user);
	
	public void update(UserToken user);

	public void delete(int id, String token);
	
	public UserToken getUserTokenFromToken(String session_token);
	
	public UserToken getUserToken(int user_id, String device_token);
}
