package com.tamuvii.service;

import java.util.List;

import com.tamuvii.pojo.MessageUserItem;

public interface MessageManager {
	
	public List<MessageUserItem> getGroupedMessagesByUser(String username);
	
	public List<MessageUserItem> getInMessagesByUser(String username);
	
	public List<MessageUserItem>  getConversationWithUser(String remoteUser, String username);
	
	public void sendPersonalMessage(String remoteUser, String receiver, String messagetext);
	
}