package com.tamuvii.pojo;

import com.tamuvii.model.Message;

public class MessageUserItem {
	
	private Message message;
	private UserNeighbor user;
	private int numMessages;
	
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	public UserNeighbor getUser() {
		return user;
	}
	public void setUser(UserNeighbor user) {
		this.user = user;
	}
	public int getNumMessages() {
		return numMessages;
	}
	public void setNumMessages(int numMessages) {
		this.numMessages = numMessages;
	}
	
	

}