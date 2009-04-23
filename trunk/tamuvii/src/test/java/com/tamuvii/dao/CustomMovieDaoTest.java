package com.tamuvii.dao;

public class CustomMovieDaoTest extends BaseDaoTestCase {
	private CustomMovieDAO customMovieDao = null;

	public void setCustomMovieDao(CustomMovieDAO customMovieDao) {
		this.customMovieDao = customMovieDao;
	}
	
	public void testGroupedMessagesByUser() {
		assertNotNull(customMovieDao.getGroupedMessagesByUser("user"));
	}
	
}