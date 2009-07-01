package com.tamuvii.service;

import java.util.List;

import com.tamuvii.pojo.UserNeighbor;

public interface ExplorePeopleManager {
	
	public List<UserNeighbor> getLastSubscribedUsers(String username);

}