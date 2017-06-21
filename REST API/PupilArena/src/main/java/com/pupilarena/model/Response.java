package com.pupilarena.model;

public class Response {
	public static final int SUCCESS=1;
	public static final int FAILURE=0;
	public static final int AUTH_FAILURE=-1;
	
	private int status;
	private String message;
	private Object data;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
