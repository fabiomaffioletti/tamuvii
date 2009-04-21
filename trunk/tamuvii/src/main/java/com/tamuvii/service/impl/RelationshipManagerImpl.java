package com.tamuvii.service.impl;

import java.util.List;

import com.tamuvii.pojo.UserNeighbor;
import com.tamuvii.service.RelationshipManager;
import com.tamuvii.service.UserToUserManager;

public class RelationshipManagerImpl implements RelationshipManager {
	private UserToUserManager userToUserManager = null;
	
	public void setUserToUserManager(UserToUserManager userToUserManager) {
		this.userToUserManager = userToUserManager;
	}

	public List<UserNeighbor> getUserFriends(String username) {
		return userToUserManager.getUserFriends(username);
	}

	public List<UserNeighbor> getUserNeighborhoods(String username) {
		return userToUserManager.getUserNeighborhoods(username);
	}

}
