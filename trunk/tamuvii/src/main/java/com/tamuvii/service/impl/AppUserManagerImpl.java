package com.tamuvii.service.impl;

import java.io.File;
import java.util.List;

import com.tamuvii.dao.AppUserDAO;
import com.tamuvii.model.AppUser;
import com.tamuvii.model.AppUserExample;
import com.tamuvii.service.AppUserManager;

public class AppUserManagerImpl implements AppUserManager {

	private AppUserDAO appUserDao = null;
	
	public void setAppUserDao(AppUserDAO appUserDAO) {
		this.appUserDao = appUserDAO;
	}
	
	public void updateProfileImagePath(String username, String image) {
		AppUser appUser = new AppUser();
		appUser.setImage(image);
		AppUserExample appUserExample = new AppUserExample();
		appUserExample.createCriteria().andUsernameEqualTo(username);
		appUserDao.updateByExampleSelective(appUser, appUserExample);
	}

	@SuppressWarnings("unchecked")
	public void deleteOldPersonaleImageFromServer(String username) {
		AppUserExample appUserExample = new AppUserExample();
		appUserExample.createCriteria().andUsernameEqualTo(username);
		List<AppUser> appUsers = appUserDao.selectByExample(appUserExample);
		AppUser appUser = appUsers.get(0);
		
		String fileName = appUser.getImage();
		
		if (!(fileName.startsWith("http"))){
			//fileName = servletContext + fileName;
			
		    // A File object to represent the filename
		    File f = new File(fileName);
	
		    // Make sure the file or directory exists and isn't write protected
		    if (!f.exists())
		      throw new IllegalArgumentException(
		          "Delete: no such file or directory: " + fileName);
	
		    if (!f.canWrite())
		      throw new IllegalArgumentException("Delete: write protected: "
		          + fileName);
	
		    // If it is a directory, make sure it is empty
		    if (f.isDirectory()) {
		      String[] files = f.list();
		      if (files.length > 0)
		        throw new IllegalArgumentException(
		            "Delete: directory not empty: " + fileName);
		    }
	
		    // Attempt to delete it
		    boolean success = f.delete();
	
		    if (!success)
		      throw new IllegalArgumentException("Delete: deletion failed");
		  }
	}

}
