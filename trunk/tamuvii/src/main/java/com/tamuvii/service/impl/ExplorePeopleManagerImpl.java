package com.tamuvii.service.impl;

import java.util.List;

import com.tamuvii.dao.CustomRelationshipDAO;
import com.tamuvii.pojo.UserNeighbor;
import com.tamuvii.service.AppUserManager;
import com.tamuvii.service.ExplorePeopleManager;

public class ExplorePeopleManagerImpl implements ExplorePeopleManager {
	private AppUserManager appUserManager = null;
	private CustomRelationshipDAO customRelationshipDao = null;
	
	public void setCustomRelationshipDao(CustomRelationshipDAO customRelationshipDao) {
		this.customRelationshipDao = customRelationshipDao;
	}
	public void setAppUserManager(AppUserManager appUserManager) {
		this.appUserManager = appUserManager;
	}


	public List<UserNeighbor> getLastSubscribedUsers(String username) {
		return customRelationshipDao.getLastSubscribedUsers(appUserManager.getUserByUsername(username));
	}

}