package com.tamuvii.service.impl;

import java.io.File;
import java.util.Calendar;
import java.util.List;

import com.tamuvii.dao.AppUserDAO;
import com.tamuvii.dao.CustomRelationshipDAO;
import com.tamuvii.model.AppUser;
import com.tamuvii.model.AppUserExample;
import com.tamuvii.model.AppUserExample.Criteria;
import com.tamuvii.pojo.UserNeighbor;
import com.tamuvii.service.AppUserManager;

public class AppUserManagerImpl implements AppUserManager {
	private CustomRelationshipDAO customRelationshipDao = null;
	private AppUserDAO appUserDao = null;

	public void setCustomRelationshipDao(CustomRelationshipDAO customRelationshipDao) {
		this.customRelationshipDao = customRelationshipDao;
	}
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

	
	
	
	public UserNeighbor getUserPublicInfo(String username) {
		return customRelationshipDao.getUserPublicInfo(username);
	}
	
	
	
	public void enableUser(String userEmail) {
		AppUserExample appUserExample = new AppUserExample();
		Criteria c = appUserExample.createCriteria();
		c.andEmailEqualTo(userEmail);
		AppUser appUser = (AppUser) appUserDao.selectByExample(appUserExample).get(0);
		appUser.setAccountenabled("1");
		appUser.setDateactivated(Calendar.getInstance().getTime());
		appUserDao.updateByPrimaryKey(appUser);
	}
	
	
	public AppUser getUserByUsername(String username) {
		AppUserExample appUserExample = new AppUserExample();
		Criteria c = appUserExample.createCriteria();
		c.andUsernameEqualTo(username);
		return (AppUser) appUserDao.selectByExample(appUserExample).get(0);
	}
	
	
	public void saveUser(AppUser appUser) {
		if(appUser.getId() != null)
			appUserDao.updateByPrimaryKeySelective(appUser);
		// TODO Lanciare un'eccezione custom
	}
	

}