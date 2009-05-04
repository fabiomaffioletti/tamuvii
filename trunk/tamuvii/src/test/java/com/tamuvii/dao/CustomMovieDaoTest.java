package com.tamuvii.dao;

public class CustomMovieDaoTest extends BaseDaoTestCase {
	private CustomMessageDAO customMessageDao = null;

	public void setCustomMessageDao(CustomMessageDAO customMessageDao) {
		this.customMessageDao = customMessageDao;
	}



	public void testGroupedMessagesByUser() {
		assertNotNull(customMessageDao.getGroupedMessagesByUser("user"));
	}
	
}