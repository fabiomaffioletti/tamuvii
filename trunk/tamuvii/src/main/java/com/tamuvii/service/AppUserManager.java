package com.tamuvii.service;

import com.tamuvii.pojo.UserNeighbor;


public interface AppUserManager {
	
	public void updateProfileImagePath(String username, String path);
	
	public void deleteOldPersonaleImageFromServer(String username);
	
	public UserNeighbor getUserPublicInfo(String username);
	
}