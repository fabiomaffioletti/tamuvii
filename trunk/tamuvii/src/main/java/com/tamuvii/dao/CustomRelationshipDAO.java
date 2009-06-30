package com.tamuvii.dao;

import java.util.List;

import com.tamuvii.pojo.UserNeighbor;

public interface CustomRelationshipDAO {
	
	public List<UserNeighbor> getUserFriends(String username);
	
	public List<UserNeighbor> getUserNeighborhoods(String username);
	
	public UserNeighbor getUserPublicInfo(String username);
	
	public List<UserNeighbor> getLastUserVisitors(String username);
	
}