package com.uncc.mhealth.model;

import java.util.ArrayList;
import java.util.List;

public class Survey {
	/**
	 * list of 8 UserSurveys
	 */
	List<UserSurvey> userSurveyList = new ArrayList<UserSurvey>();

	public List<UserSurvey> getUserSurveyList() {
		return userSurveyList;
	}
	public void setUserSurveyList(List<UserSurvey> list) {
		userSurveyList = list;
	}
}
