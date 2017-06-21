package com.pupilarena.service.impl;

import java.util.Map;

import com.pupilarena.dao.IAdminDao;
import com.pupilarena.model.Quizes;
import com.pupilarena.service.IAdminService;

public class AdminServiceImpl implements IAdminService {
	private IAdminDao adminDao;

	public IAdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public Map<String, Object> getQuestions(int quizId) {
		return adminDao.getQuestions(quizId);
	}

	@Override
	public boolean addQuestion(int quizId, int questionId) {
		return adminDao.addQuestion(quizId,questionId);
	}

	@Override
	public boolean removeQuestion(int quizId, int questionId) {
		return adminDao.removeQuestion(quizId,questionId);
	}

	@Override
	public boolean saveQuiz(Quizes quiz) {
		return adminDao.saveQuiz(quiz);
	}
	
	

}
