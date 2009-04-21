package com.tamuvii.service;

import java.util.List;

import com.tamuvii.pojo.UserNeighbor;

public interface RelationshipManager {
	
	public List<UserNeighbor> getUserFriends(String username);
	
	public List<UserNeighbor> getUserNeighborhoods(String username);

}
