package com.uncc.mhealth.model;

public class Strategies {
	private int user_id;
	private String strategy;
	public Strategies(int id, String strategy) {
		// TODO Auto-generated constructor stub
		this.user_id = id;
		this.strategy = strategy;
	}
	public Strategies() {
		// TODO Auto-generated constructor stub
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getStrategy() {
		return strategy;
	}
	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}
	@Override
	public String toString() {
		return "Strategies [user_id=" + user_id + ", strategy=" + strategy + "]";
	}
	
}
