package com.uncc.mhealth.model;

public class TriviaOption {
	private int id;
	private int trivia_id;
	private String text;
	private int value;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTrivia_id() {
		return trivia_id;
	}
	public void setTrivia_id(int trivia_id) {
		this.trivia_id = trivia_id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "TriviaOption [id=" + id + ", trivia_id=" + trivia_id + ", text=" + text + ", value=" + value + "]";
	}
	
}
