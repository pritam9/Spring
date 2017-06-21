package com.uncc.mhealth.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.uncc.mhealth.model.Question;

public class SurveyService {
	private static Integer[] sixWeekIds = new Integer[] {36,22,23,35,16,66,67,68,69,24,18,19,27,28,20,79,80,81,82,83,84,85,86,87,88,89,37,38,96,97,98};
	public static List<Question> filterSixWeekSurvey(List<Question> baseline){
		List<Question> sixWeekSurvey = new ArrayList<Question>();
		List<Integer> sixWeekList = Arrays.asList(sixWeekIds);
		for(Question question: baseline){
			if(sixWeekList.contains(question.getId())){
				sixWeekSurvey.add(question);
			}
		}
		return sixWeekSurvey;
	}
}
