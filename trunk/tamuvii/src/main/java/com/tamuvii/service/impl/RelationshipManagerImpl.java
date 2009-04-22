package com.tamuvii.service.impl;

import java.util.List;

import com.tamuvii.model.UserToUserExample;
import com.tamuvii.model.UserToUserExample.Criteria;
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

	public boolean areFriends(String first, String second) {
		return userToUserManager.areFriends(first, second);
	}

	public boolean areNeighborhoods(String first, String second) {
		return userToUserManager.areNeighborhoods(first, second);
	}
	
	public boolean areRelated(String first, String second) {
		return userToUserManager.areRelated(first, second);
	}


	public void addFriend(String username, String remoteUser) {
		if(!areRelated(remoteUser, username)) {
			userToUserManager.addFriend(username, remoteUser);
		}
	}

	public void addNeighborhood(String username, String remoteUser) {
		if(!areRelated(remoteUser, username)) {
			userToUserManager.addNeighborhood(username, remoteUser);
		}
	}

	public void deleteFriend(String username, String remoteUser) {
		if(areFriends(remoteUser, username)) {
			userToUserManager.deleteRelation(username, remoteUser);
		}
	}
	
	public void deleteNeighborhood(String username, String remoteUser) {
		if(areNeighborhoods(remoteUser, username)) {
			userToUserManager.deleteRelation(username, remoteUser);
		}
	}

	public void moveRelation(String username, String remoteUser) {
		if(areFriends(remoteUser, username)) {
			userToUserManager.moveRelation(username, remoteUser, 0);
		} else if(areNeighborhoods(remoteUser, username)) {
			userToUserManager.moveRelation(username, remoteUser, 1);
		}
	}

}