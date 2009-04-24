package com.tamuvii.service;


public interface AppUserManager {
	
	public void updateProfileImagePath(String username, String path);
	
	public void deleteOldPersonaleImageFromServer(String username);
	
}