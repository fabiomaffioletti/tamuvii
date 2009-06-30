package com.tamuvii.service;

import java.util.List;

import com.tamuvii.pojo.UserNeighbor;

public interface VisitManager {
	
	public void addUserVisit(String visited, String visitor);
	
	public List<UserNeighbor> getLastUserVisitors(String username);

}