package com.uncc.mhealth.dao;

import java.util.List;

import com.uncc.mhealth.model.Question;
import com.uncc.mhealth.model.UserSurvey;
import com.uncc.mhealth.model.UserSurveyResponse;

public interface UserSurveyDAO {
	

	public void saveOrUpdate(UserSurvey userSurvey);
	
	public void saveOrUpdate(UserSurveyResponse userResponse);

	public void delete(int id);
	
	public UserSurvey get(int id, String survey);

	public List<UserSurvey> get(int id);
	
	public List<UserSurveyResponse> getUserSurveyResponse(int id,String survey);
	
    public List<UserSurveyResponse> getAllUserSurveyResponse(int id);
    
    public List<Question> getMentorFeedback(int userid);
	
}
