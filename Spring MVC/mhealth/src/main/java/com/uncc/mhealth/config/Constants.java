package com.uncc.mhealth.config;

public class Constants {
	public static class DB {
		// JDBC driver name and database URL
		public static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
		public static final String DB_URL="jdbc:mysql://localhost/usersdb";

	      //  Database credentials
		public static final String USER = "root";
		public static final String PASS = "mhealth";
	}
	public static class User {
		public static final String INVALID_CREDENTIALS = "invalid credentials";
		public static final String INVALID_TOKEN = "invalid user token";
	}
	public static class Parameter{
		public static final String USER = "user";
		public static final String USERNAME = "username";
		public static final String PASSWORD = "password";
		public static final String DEVICE_TOKEN = "deviceToken";
		public static final String SESSION_TOKEN = "token";
		public static final String DATE = "date";
		public static final String BAC = "bac";
		public static final String DRINKS = "drinks";
		public static final String BEER = "beer";
		public static final String WINE = "wine";
		public static final String SHOTS = "shots";
		public static final String LIQUOR = "liquor";
		public static final String PROS_CONS = "pros_cons";
		public static final String STRATEGY = "strategy";
		public static final String CATEGORY = "category";
		public static final String IS_CORRECT = "isCorrect";
		public static final String TIME = "time";
		public static final String MESSAGE_ID = "messageId";
		public static final String ANSWER = "answer";
	}
	public static class Message{
		public static final String NEW_MESSAGE = "New Message from SmarTrek";
		public static final String PF_REVIEW_C = "You’ve given some thought to changing your drinking habits.  I look forward to working with you to find specific strategies to be healthier and safer the next time you drink.";
		public static final String PF_REVIEW_A = "You’ve already taken some steps to change your drinking habits.  Great job! I hope to help you continue with the strategies and plan that you’ve already begun.";
		public static final String PF_HIGH_RISK = "We would like to get you into low risk.";
		public static final String PF_PEAK = "At your peak BAC of %s, it will take you %s hours until you are sober. ";
		public static final String PF_TYPICAL = "At your typical BAC of %s, it will take you %s hours until you are sober.";
		public static final String PF_GENETIC_SUGGESTION = "This does not mean that you necessarily have or will develop alcohol problems.  This is simply an additional risk factor.";
		public static final String PF_RULER_IMPROVEMENT = "That is totally your choice—If you choose to drink I will help you learn to do so safely.";
		public static final String PF_RULER_IMP_IMPROVEMENT = "Great I can help you learn new strategies to change your drinking!";
		public static final String PF_RULER_IMPROVEMENT1 = "If you would like—I can help you learn new strategies which will put you at less risk of harm if you choose to drink.";
		public static final String PF_RULER_IMP_IMPROVEMENT1 = "Great I can help you learn new strategies to change your drinking!";
	}
}
