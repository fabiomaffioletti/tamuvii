package com.tamuvii.pojo.queryfilter;

public class MessageUserFilter {
	
	private String remoteUser;
	private String username;
	private boolean conversation;
	
	public String getRemoteUser() {
		return remoteUser;
	}
	public void setRemoteUser(String remoteUser) {
		this.remoteUser = remoteUser;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isConversation() {
		return conversation;
	}
	public void setConversation(boolean conversation) {
		this.conversation = conversation;
	}

}