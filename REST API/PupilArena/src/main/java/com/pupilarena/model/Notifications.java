package com.pupilarena.model;

public class Notifications {
	private String sender_email,receiver_email,stauts,groupName,senderName;
	private int notifId,groupId;
	private boolean isSenderLeader;
	public String getSender_email() {
		return sender_email;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public void setSender_email(String sender_email) {
		this.sender_email = sender_email;
	}
	public String getReceiver_email() {
		return receiver_email;
	}
	public void setReceiver_email(String receiver_email) {
		this.receiver_email = receiver_email;
	}
	public String getStauts() {
		return stauts;
	}
	public void setStauts(String stauts) {
		this.stauts = stauts;
	}
	public int getNotifId() {
		return notifId;
	}
	public void setNotifId(int notifId) {
		this.notifId = notifId;
	}
	public boolean isSenderLeader() {
		return isSenderLeader;
	}
	public void setSenderLeader(boolean isSenderLeader) {
		this.isSenderLeader = isSenderLeader;
	}
	public Notifications() {

	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	
}
