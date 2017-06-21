package com.uncc.mhealth.model;

import java.util.Set;

public class UserMIMapping {
	public static final int NOT_SENT = 0;
	public static final int SENT = 1;
	public static final int RECEIVED = 2;
	
	public static final int NOT_OPENED = 0;
	public static final int OPENED = 1;
	
	public static final int NOT_AVAILABLE = -1;
	int mi_id;
	int user_id;
	int sent;
	int open;
	String updated_text;
	int id;
	String sent_time;
	String open_time;
	String respond_time;
	
	
//	MI mi;
//	
//	
//	
//	public MI getMi() {
//		return mi;
//	}
//	public void setMi(MI mi) {
//		this.mi = mi;
//	}
	private int type;
	private int option_type;
	private String title;
	private String text;
	private String answer;
	private String dateTime;
	private Set<MIOption> mioptions;

	public UserMIMapping(){
		
	}
	
	public UserMIMapping(int user_id, int mi_id, int sent, int opened, String text, String sentTime) {
		// TODO Auto-generated constructor stub
		this.mi_id = mi_id;
		this.user_id = user_id;
		this.sent = sent;
		this.open = opened;
		this.updated_text = text;
		this.text = text;
		this.sent_time = sentTime;
	}
	public int getMi_id() {
		return mi_id;
	}
	public void setMi_id(int mi_id) {
		this.mi_id = mi_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getSent() {
		return sent;
	}
	public void setSent(int sent) {
		this.sent = sent;
	}
	public int getOpen() {
		return open;
	}
	public void setOpen(int open) {
		this.open = open;
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
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public Set<MIOption> getMioptions() {
		return mioptions;
	}
	public void setMioptions(Set<MIOption> mioptions) {
		this.mioptions = mioptions;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public String getUpdated_text() {
		return updated_text;
	}
	public void setUpdated_text(String updated_text) {
		this.updated_text = updated_text;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSent_time() {
		return sent_time;
	}
	public void setSent_time(String sent_time) {
		this.sent_time = sent_time;
	}
	
	public String getOpen_time() {
		return open_time;
	}

	public void setOpen_time(String open_time) {
		this.open_time = open_time;
	}

	public String getRespond_time() {
		return respond_time;
	}

	public void setRespond_time(String respond_time) {
		this.respond_time = respond_time;
	}

	@Override
	public String toString() {
		return "UserMIMapping [mi_id=" + mi_id + ", user_id=" + user_id + ", sent=" + sent + ", open=" + open
				+ ", updated_text=" + updated_text + ", id=" + id + ", sent_time=" + sent_time + ", type=" + type
				+ ", option_type=" + option_type + ", title=" + title + ", text=" + text + ", answer=" + answer
				+ ", dateTime=" + dateTime + ", mioptions=" + mioptions + "]";
	}
	
	
	
}
