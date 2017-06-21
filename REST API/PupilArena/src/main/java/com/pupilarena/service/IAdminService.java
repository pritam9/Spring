package com.pupilarena.service;

import java.util.Map;

import com.pupilarena.model.Quizes;

public interface IAdminService {

	Map<String, Object> getQuestions(int quizId);

	boolean addQuestion(int quizId, int questionId);

	boolean removeQuestion(int quizId, int questionId);

	boolean saveQuiz(Quizes quiz);

}
