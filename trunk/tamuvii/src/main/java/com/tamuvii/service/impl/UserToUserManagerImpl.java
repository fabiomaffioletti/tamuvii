package com.tamuvii.service.impl;

import java.util.List;

import com.tamuvii.dao.CustomMovieDAO;
import com.tamuvii.dao.UserToUserDAO;
import com.tamuvii.model.UserToUser;
import com.tamuvii.model.UserToUserExample;
import com.tamuvii.model.UserToUserKey;
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
	
	public boolean areRelated(String first, String second) {
		UserToUserKey userToUserKey = new UserToUserKey();
		userToUserKey.setFirst(first);
		userToUserKey.setSecond(second);
		return userToUserDao.selectByPrimaryKey(userToUserKey) != null;
	}
	
	
	public void addFriend(String username, String remoteUser) {
		UserToUser userToUser = new UserToUser();
		userToUser.setFirst(remoteUser);
		userToUser.setSecond(username);
		userToUser.setFriend(1);
		userToUserDao.insertSelective(userToUser);
	}
	
	public void addNeighborhood(String username, String remoteUser) {
		UserToUser userToUser = new UserToUser();
		userToUser.setFirst(remoteUser);
		userToUser.setSecond(username);
		userToUser.setFriend(0);
		userToUserDao.insertSelective(userToUser);
	}
	
	public void deleteRelation(String username, String remoteUser) {
		UserToUserKey userToUserKey = new UserToUserKey();
		userToUserKey.setFirst(remoteUser);
		userToUserKey.setSecond(username);
		userToUserDao.deleteByPrimaryKey(userToUserKey);
	}
	
	public void moveRelation(String username, String remoteUser, int value) {
		UserToUser userToUser = new UserToUser();
		userToUser.setFirst(remoteUser);
		userToUser.setSecond(username);
		userToUser.setFriend(value);
		userToUserDao.updateByPrimaryKeySelective(userToUser);
	}

}