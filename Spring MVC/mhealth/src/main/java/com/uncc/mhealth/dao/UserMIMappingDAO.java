package com.uncc.mhealth.dao;

import java.util.List;

import com.uncc.mhealth.model.MI;
import com.uncc.mhealth.model.UserMIMapping;
import com.uncc.mhealth.model.UserMIMappingFuture;

public interface UserMIMappingDAO {
	public List<UserMIMapping> list();

	public UserMIMapping get(int id);

	public void saveOrUpdate(UserMIMapping user);

	public void delete(int id);
	
	public List<UserMIMapping>  list(int user_id, int sent);

	List<UserMIMapping> fetchFromMIAndUser(int mi_id, int userId);
	
	public List<UserMIMapping> getAllMapping(int sent);
	
	public void saveOrUpdate(UserMIMappingFuture userMIFuture);
	
	public List<UserMIMappingFuture> futurelist();
	
	public MI getMIObj(int mi_id);
	
	public boolean isLastSentMsg(int userId,int miMappingId);
}
