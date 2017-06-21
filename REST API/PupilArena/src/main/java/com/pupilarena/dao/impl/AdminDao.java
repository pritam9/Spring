package com.pupilarena.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.pupilarena.dao.IAdminDao;
import com.pupilarena.model.Questions;
import com.pupilarena.model.Quizes;
import com.pupilarena.model.Users;

public class AdminDao implements IAdminDao {
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public Map<String, Object> getQuestions(int quizId) {
		List<Questions> quizQuestions = getQuizQuestions(quizId);
		List<Questions> remainingQuestions = getRemainingQuestions(quizId);
		Map<String, Object> questionsMap = new HashMap<String, Object>();
		questionsMap.put("quizQuestions", quizQuestions);
		questionsMap.put("remainingQuestions", remainingQuestions);
		return questionsMap;
	}

	private List<Questions> getRemainingQuestions(int quizId) {
		String query = "select * from questions where questionId not in (select questionId from quiz_question_mapping where quizId=?)";
		List<Questions> questions= new ArrayList<Questions>();
		try{
			PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
			pstmt.setInt(1, quizId);
			//pstmt.setString(2, password);
			ResultSet resultSet = pstmt.executeQuery();
			
			while (resultSet.next())
			{	
				Questions question=new Questions();
				question.setQuestionId(resultSet.getInt(1));
				question.setQuestionText(resultSet.getString(2));
				question.setOptionA(resultSet.getString(3));
				question.setOptionB(resultSet.getString(4));
				question.setOptionC(resultSet.getString(5));
				question.setOptionD(resultSet.getString(6));
				question.setOptionE(resultSet.getString(7));
				question.setImgUrl(resultSet.getString(9));
				questions.add(question);
			}
			return questions;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

	private List<Questions> getQuizQuestions(int quizId) {
		String query = "select A.QuestionId, B.questionText,B.optionA,B.optionB,B.optionC,B.optionD,B.optionE,B.imgUrl from quiz_question_mapping A JOIN questions B ON A.questionId = B.questionId AND A.quizId = ?;";
		List<Questions> questions= new ArrayList<Questions>();
		try{
			PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
			pstmt.setInt(1, quizId);
			//pstmt.setString(2, password);
			ResultSet resultSet = pstmt.executeQuery();
			
			while (resultSet.next())
			{	
				Questions question=new Questions();
				question.setQuestionId(resultSet.getInt(1));
				question.setQuestionText(resultSet.getString(2));
				question.setOptionA(resultSet.getString(3));
				question.setOptionB(resultSet.getString(4));
				question.setOptionC(resultSet.getString(5));
				question.setOptionD(resultSet.getString(6));
				question.setOptionE(resultSet.getString(7));
				question.setImgUrl(resultSet.getString(8));
				questions.add(question);
			}
			return questions;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}	
		
	}

	@Override
	public boolean addQuestion(int quizId, int questionId) {
		String query = "insert into quiz_question_mapping(quizId,questionId) values(?,?)";
		try{
			PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
			pstmt.setInt(2, questionId);
			pstmt.setInt(1, quizId);
			pstmt.executeUpdate();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean removeQuestion(int quizId, int questionId) {
		String query = "delete from quiz_question_mapping where quizId=? and questionId=?";
		try{
			PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
			pstmt.setInt(2, questionId);
			pstmt.setInt(1, quizId);
			pstmt.executeUpdate();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean saveQuiz(Quizes quiz) {
		String query = "insert into quiztable(QuizName,QuizInfo,QuizRules,QuizDuration,isLocked) values(?,?,?,?,?)";
		try{
			PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
			pstmt.setString(1, quiz.getQuizName());;
			pstmt.setString(2, quiz.getQuizInfo());
			pstmt.setString(3, quiz.getQuizRules());;
			pstmt.setInt(4, quiz.getDuration());
			pstmt.setBoolean(5, true);
			pstmt.executeUpdate();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
}
