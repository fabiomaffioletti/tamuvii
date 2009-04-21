package com.tamuvii.service.impl;

import java.util.List;

import com.tamuvii.dao.CustomMovieDAO;
import com.tamuvii.dao.UserToUserDAO;
import com.tamuvii.model.UserToUserExample;
import com.tamuvii.model.UserToUserExample.Criteria;
import com.tamuvii.pojo.UserNeighbor;
import com.tamuvii.service.UserToUserManager;

public class UserToUserManagerImpl implements UserToUserManager {
	private CustomMovieDAO customMovieDao = null;
	private UserToUserDAO userToUserDao = null;
	
	public void setUserToUserDao(UserToUserDAO userToUserDao) {
		this.userToUserDao = userToUserDao;
	}
	public void setCustomMovieDao(CustomMovieDAO customMovieDao) {
		this.customMovieDao = customMovieDao;
	}

	
	
	public List<UserNeighbor> getUserFriends(String username) {
		return customMovieDao.getUserFriends(username);
	}

	public List<UserNeighbor> getUserNeighborhoods(String username) {
		return customMovieDao.getUserNeighborhoods(username);
	}
	
	public boolean areFriends(String first, String second) {
		UserToUserExample userToUserExample = new UserToUserExample();
		Criteria userToUserCriteria = userToUserExample.createCriteria();
		userToUserCriteria.andFirstEqualTo(first);
		userToUserCriteria.andSecondEqualTo(second);
		userToUserCriteria.andFriendEqualTo(1);
		return userToUserDao.selectByExample(userToUserExample).size() > 0;
	}
	
	public boolean areNeighborhoods(String first, String second) {
		UserToUserExample userToUserExample = new UserToUserExample();
		Criteria userToUserCriteria = userToUserExample.createCriteria();
		userToUserCriteria.andFirstEqualTo(first);
		userToUserCriteria.andSecondEqualTo(second);
		userToUserCriteria.andFriendEqualTo(0);
		return userToUserDao.selectByExample(userToUserExample).size() > 0;
	}
}