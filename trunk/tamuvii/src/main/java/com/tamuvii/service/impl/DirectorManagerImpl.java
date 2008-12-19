package com.tamuvii.service.impl;

import com.tamuvii.dao.DirectorDao;
import com.tamuvii.model.Director;
import com.tamuvii.service.DirectorManager;

public class DirectorManagerImpl extends GenericManagerImpl<Director, Integer> implements DirectorManager {
	DirectorDao directorDao;
	
	public DirectorManagerImpl(DirectorDao directorDao) {
		super(directorDao);
		this.directorDao = directorDao;
	}

}