package com.tamuvii.dao;

import java.util.List;

import com.tamuvii.pojo.MessageUserItem;
import com.tamuvii.pojo.queryfilter.MessageUserFilter;

public interface CustomMessageDAO {
	
	public List<MessageUserItem> getGroupedMessagesByUser(String username);

	public List<MessageUserItem> getInMessagesByUser(String username);

	public List<MessageUserItem> getConversationWithUser(MessageUserFilter messageUserFilter);

}