package com.uncc.mhealth.model;

import java.util.Set;

public class MI {
	public static final int TYPE_TEXT = 0;
	public static final int TYPE_IMAGE = 1;
	public static final int TYPE_TEXT_IMAGE = 2;
	public static final int TYPE_QUESTION_TEXT = 3;
	public static final int TYPE_QUESTION_IMAGE = 4;
	public static final int TYPE_QUESTION_TEXT_IMAGE = 5;

	public static final int OPTION_TYPE_NA = 0;
	public static final int OPTION_TYPE_DYNAMIC_LINK = 1;
	public static final int OPTION_TYPE_WEB_URL = 2;
	public static final int OPTION_TYPE_APP_URL = 3;
	public static final int OPTION_TYPE_CHECK_BOX = 4;

	private int id;
	private int type;
	private int option_type;
	private String title;
	private String text;
	private String answer;
	private String dateTime;
	private Integer next;
	private Set<MIOption> mioptions;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getOption_type() {
		return option_type;
	}

	public void setOption_type(int option_type) {
		this.option_type = option_type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	

	public Set<MIOption> getMioptions() {
		return mioptions;
	}

	public void setMioptions(Set<MIOption> options) {
		this.mioptions = options;
	}

	public Integer getNext() {
		return next;
	}

	public void setNext(Integer next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "MI [id=" + id + ", type=" + type + ", option_type=" + option_type + ", title=" + title + ", text="
				+ text + ", answer=" + answer + ", dateTime=" + dateTime + ", next=" + next + ", mioptions=" + mioptions
				+ "]";
	}

	

	

}
