package com.uncc.mhealth.model;

import java.util.ArrayList;
import java.util.Set;


public class ResponseQuestion {
	private int id;
	private int index;
	private String text;
	private int type;
	private String answer;
	private ArrayList<Option> options;
	private ArrayList<SubQuestion> subquestions;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public ArrayList<Option> getOptions() {
		return options;
	}
	public void setOptions(ArrayList<Option> options) {
		this.options = options;
	}
	public ArrayList<SubQuestion> getSubquestions() {
		return subquestions;
	}
	public void setSubquestions(ArrayList<SubQuestion> subquestions) {
		this.subquestions = subquestions;
	}
	@Override
	public String toString() {
		return "ResponseQuestion [id=" + id + ", index=" + index + ", text=" + text + ", type=" + type + ", answer="
				+ answer + ", options=" + options + ", subquestions=" + subquestions + "]";
	}
	
}
