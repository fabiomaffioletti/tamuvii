package com.tamuvii.service.impl;

import java.util.List;

import org.json.JSONException;

import com.tamuvii.dao.CustomShelfDAO;
import com.tamuvii.pojo.ShelfDirectorReport;
import com.tamuvii.pojo.queryfilter.ShelfDirectorReportFilter;
import com.tamuvii.service.ShelfManager;

public class ShelfManagerImpl implements ShelfManager {
	private CustomShelfDAO customShelfDao = null;
	
	public void setCustomShelfDao(CustomShelfDAO customShelfDao) {
		this.customShelfDao = customShelfDao;
	}


	public List<ShelfDirectorReport> getShelfDirectorReport(String username) {
		ShelfDirectorReportFilter sdrf = new ShelfDirectorReportFilter();
		sdrf.setUsername(username);
		
		return customShelfDao.getShelfDirectorReport(sdrf);
	}


	public String getJSONShelfDirectorReport(String username, Integer x, Integer y) throws JSONException {
		return customShelfDao.JSONShelfDirectorReport(username, x, y);
	}

}