package com.tamuvii.service.impl;

import java.util.List;

import com.tamuvii.dao.CustomMovieDAO;
import com.tamuvii.pojo.MessageUserItem;
import com.tamuvii.pojo.queryfilter.MessageUserFilter;
import com.tamuvii.service.MessageManager;

public class MessageManagerImpl implements MessageManager {
	private CustomMovieDAO customMovieDao = null;
	
	public void setCustomMovieDao(CustomMovieDAO customMovieDao) {
		this.customMovieDao = customMovieDao;
	}



	public List<MessageUserItem> getGroupedMessagesByUser(String username) {
		return customMovieDao.getGroupedMessagesByUser(username);
	}

	public List<MessageUserItem> getAllMessagesByUser(String username) {
		return customMovieDao.getAllMessagesByUser(username);
	}

	public List<MessageUserItem> getConversationWithUser(String remoteUser, String username) {
		MessageUserFilter messageUserFilter = new MessageUserFilter();
		messageUserFilter.setRemoteUser(remoteUser);
		messageUserFilter.setUsername(username);
		return customMovieDao.getConversationWithUser(messageUserFilter);
	}

}