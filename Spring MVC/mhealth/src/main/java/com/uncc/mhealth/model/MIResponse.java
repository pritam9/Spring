package com.uncc.mhealth.model;

public class MIResponse {
	private String token;
	private MI mi;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public MI getMi() {
		return mi;
	}
	public void setMi(MI mi) {
		this.mi = mi;
	}
	@Override
	public String toString() {
		return "MIResponse [token=" + token + ", mi=" + mi + "]";
	}
	
}
