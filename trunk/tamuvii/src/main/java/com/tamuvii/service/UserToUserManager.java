package com.tamuvii.service;

import java.util.List;

import com.tamuvii.pojo.UserNeighbor;

public interface UserToUserManager {
	
	public List<UserNeighbor> getUserNeighborhoods(String username);
	
	public List<UserNeighbor> getUserFriends(String username);
	
	public boolean areFriends(String first, String second);
	
	public boolean areNeighborhoods(String first, String second);

}