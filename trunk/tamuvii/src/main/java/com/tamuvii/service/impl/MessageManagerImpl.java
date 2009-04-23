package com.tamuvii.service.impl;

import java.util.List;

import com.tamuvii.dao.CustomMovieDAO;
import com.tamuvii.pojo.MessageUserItem;
import com.tamuvii.service.MessageManager;

public class MessageManagerImpl implements MessageManager {
	private CustomMovieDAO customMovieDao = null;
	
	public void setCustomMovieDao(CustomMovieDAO customMovieDao) {
		this.customMovieDao = customMovieDao;
	}



	public List<MessageUserItem> getGroupedMessagesByUser(String username) {
		return customMovieDao.getGroupedMessagesByUser(username);
	}

}