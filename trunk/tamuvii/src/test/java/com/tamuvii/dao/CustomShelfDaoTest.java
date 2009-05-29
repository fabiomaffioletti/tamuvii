package com.tamuvii.dao;

import com.tamuvii.pojo.queryfilter.ShelfDirectorReportFilter;

public class CustomShelfDaoTest extends BaseDaoTestCase {
	private CustomShelfDAO customShelfDao = null;
	
	public void setCustomShelfDao(CustomShelfDAO customShelfDao) {
		this.customShelfDao = customShelfDao;
	}


	public void testGetShelfDirectorReport() {
		ShelfDirectorReportFilter sdrf = new ShelfDirectorReportFilter();
		sdrf.setUsername("user");
		sdrf.setFrom(null);
		sdrf.setTo(null);
		sdrf.setOrderAttribute("surname");
		
		assertNotNull(customShelfDao.getShelfDirectorReport(sdrf));
	}



}