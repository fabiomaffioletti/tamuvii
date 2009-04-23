package com.tamuvii.service;

import java.util.List;

import com.tamuvii.pojo.MessageUserItem;

public interface MessageManager {
	
	public List<MessageUserItem> getGroupedMessagesByUser(String username);
	
	public List<MessageUserItem> getAllMessagesByUser(String username);
	
}