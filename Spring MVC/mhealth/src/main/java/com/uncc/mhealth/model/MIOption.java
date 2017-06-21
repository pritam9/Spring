package com.uncc.mhealth.model;

public class MIOption {
	private int id;
	private String text;
	private String value;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "MIOption [id=" + id + ", text=" + text + ", value=" + value + "]";
	}
	
}
