package com.tamuvii.service.impl;

import java.util.List;

import com.tamuvii.dao.CustomShelfDAO;
import com.tamuvii.pojo.ShelfDirectorReport;
import com.tamuvii.service.ShelfManager;

public class ShelfManagerImpl implements ShelfManager {
	private CustomShelfDAO customShelfDao = null;
	
	public void setCustomShelfDao(CustomShelfDAO customShelfDao) {
		this.customShelfDao = customShelfDao;
	}


	public List<ShelfDirectorReport> getShelfDirectorReport(String username) {
		return customShelfDao.getShelfDirectorReport(username);
	}

}
