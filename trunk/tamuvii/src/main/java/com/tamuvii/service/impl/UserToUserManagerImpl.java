package com.tamuvii.service.impl;

import java.util.List;

import com.tamuvii.dao.CustomMovieDAO;
import com.tamuvii.pojo.UserNeighbor;
import com.tamuvii.service.UserToUserManager;

public class UserToUserManagerImpl implements UserToUserManager {
	private CustomMovieDAO customMovieDao = null;
	
	public void setCustomMovieDao(CustomMovieDAO customMovieDao) {
		this.customMovieDao = customMovieDao;
	}

	public List<UserNeighbor> getUserFriends(String username) {
		return customMovieDao.getUserFriends(username);
	}

	public List<UserNeighbor> getUserNeighborhoods(String username) {
		return customMovieDao.getUserNeighborhoods(username);
	}

}