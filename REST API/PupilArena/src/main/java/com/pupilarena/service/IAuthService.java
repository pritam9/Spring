package com.pupilarena.service;

import java.util.List;

import javax.management.Notification;

import com.pupilarena.model.Groups;
import com.pupilarena.model.Notifications;
import com.pupilarena.model.Questions;
import com.pupilarena.model.Quizes;
import com.pupilarena.model.ScoreBoard;
import com.pupilarena.model.Users;

public interface IAuthService {

	Users verifyCredentials(String username, String password);

	Users saveUser(Users user);

	Users updateUser(Users user);

	Users getUser(String email_id);

	List<Quizes> getQuizes();

	List<Groups> getTeams();

	boolean joinGroup(String emailId,int groupId);

	List<Groups> getMyTeams(String emailId);

	List<Users> getAllMembers();

	boolean createGroup(String studentId, String groupName, int capacity);

	boolean addMember(int groupId, String studentId);

	boolean removeMember(int groupId, String studentId);

	boolean deleteGroup(int groupId);

	boolean registerForQuiz(int quizId, int groupId);

	List<Questions> getQuizQuestions(int quizId);

	boolean submitAnswer(int quizId, int questionId, String answer, String emailId);

	int getCorrectAnswersCount(String emailId, int quizId);

	int getQuestionsCount(String emailId, int quizId);

	boolean updateLockedStatus(int quizId, boolean isLocked);

	ScoreBoard getFullScorecard(int quizId);

	boolean checkIfEnrolled(int quizId, int groupId);

	boolean sendRequest(int groupId, String sender_email_id, String studentId,String status, boolean b);

	List<Notifications> getMyNotifications(String emailId);

	boolean respondToNotif(int inviteId, String emailId, int groupId, String status);

	boolean joinGroupRequest(int groupId, String senderEmail, String toEmail, String string, boolean b);

	boolean checkIfParticipated(int quizId, String emailId);

	String getGroupRole(String studentEmail, int quizId);

}
