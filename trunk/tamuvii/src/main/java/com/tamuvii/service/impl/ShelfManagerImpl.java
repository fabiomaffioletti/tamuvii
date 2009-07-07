package com.tamuvii.service.impl;

import java.util.List;

import com.tamuvii.dao.CustomShelfDAO;
import com.tamuvii.pojo.ShelfDirectorReport;
import com.tamuvii.pojo.ShelfItem;
import com.tamuvii.pojo.queryfilter.ShelfDirectorReportFilter;
import com.tamuvii.pojo.queryfilter.ShelfItemFilter;
import com.tamuvii.service.ShelfManager;

public class ShelfManagerImpl implements ShelfManager {
	private CustomShelfDAO customShelfDao = null;
	
	public void setCustomShelfDao(CustomShelfDAO customShelfDao) {
		this.customShelfDao = customShelfDao;
	}


	public List<ShelfDirectorReport> getShelfDirectorReport(String username, Integer from, Integer to, String orderAttribute) {
		ShelfDirectorReportFilter sdrf = new ShelfDirectorReportFilter();
		sdrf.setUsername(username);
		sdrf.setFrom(from);
		sdrf.setTo(to);
		sdrf.setOrderAttribute(orderAttribute);
		
		return customShelfDao.getShelfDirectorReport(sdrf);
	}


	public List<ShelfItem> getShelfByFilter(String username, Integer director, String orderAttribute, String orderCriteria) {
		ShelfItemFilter sif = new ShelfItemFilter();
		sif.setUsername(username);
		sif.setDirector(director);
		sif.setOrderAttribute(orderAttribute);
		sif.setOrderCriteria(orderCriteria);
		return customShelfDao.getShelfByFilter(sif);
	}

}