package com.uncc.mhealth.model;

import java.util.Set;

public class TriviaQuestion {
	public static final int CATEGORY_ALCOHOL_101 = 1;
	public static final int CATEGORY_ALCOHOL_LAW = 2;
	public static final int CATEGORY_COLLEGE_STUDENT_DRINKING_STATS = 3;
	public static final int CATEGORY_ALCOHOL_BODY = 4;
	public static final int CATEGORY_ALCOHOL_FACTS_MYTHS = 5;
	
//	body = 4, types = 2, law = 3, myth = 1;
	private int trivia_id;
	private int category;
	private String text;
	private int answer;
	private String explanation;
	private String options_json;
	private Set<TriviaOption> options;
	public int getTrivia_id() {
		return trivia_id;
	}
	public void setTrivia_id(int trivia_id) {
		this.trivia_id = trivia_id;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	
	public String getOptions_json() {
		return options_json;
	}
	public void setOptions_json(String options_json) {
		this.options_json = options_json;
	}
	public Set<TriviaOption> getOptions() {
		return options;
	}
	public void setOptions(Set<TriviaOption> options) {
		this.options = options;
	}
	@Override
	public String toString() {
		return "TriviaQuestion [trivia_id=" + trivia_id + ", category=" + category + ", text=" + text + ", answer="
				+ answer + ", explanation=" + explanation + ", options=" + options + "]";
	}
	
	
}
