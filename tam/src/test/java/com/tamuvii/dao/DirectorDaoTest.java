package com.tamuvii.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tamuvii.model.Director;

public class DirectorDaoTest extends ApplicationTest {
	private DirectorDAO directorDao = null;

	public void setDirectorDao(DirectorDAO directorDao) {
		this.directorDao = directorDao;
	}

	
	@SuppressWarnings("unchecked")
	public void testGetAll() {
		Map queryMap = new HashMap();
		queryMap.put("filter", new String[]{"giorgio"});
		queryMap.put("from", 0);
		queryMap.put("to", 10);
		List<Director> directors = directorDao.getAll(queryMap);
		assertNotNull(directors);
		assertTrue(directors.size() == 1);
		
		queryMap = new HashMap();
		queryMap.put("from", 0);
		queryMap.put("to", 10);
		directors = directorDao.getAll(queryMap);
		assertTrue(directors.size() > 3);
	}
	
	public void testGetDirectorById() {
		Director d = directorDao.getDirectorById(2L);
		assertNotNull(d);
		assertTrue(d.getName().equals("Gabriele"));
	}
	
	public void testAddDirector() {
		Director director = new Director();
		director.setName("name");
		director.setSurname("surname");
		director.setNickname(null);
		Long ret = directorDao.addDirector(director);
		assertNotNull(ret);
		assertTrue(directorDao.getAll(null).size() > 4);
	}
	
	public void testUpdateDirector() {
		Director director = directorDao.getDirectorById(2L);
		director.setSurname("New surname");
		directorDao.updateDirector(director);
		director = directorDao.getDirectorById(2L);
		assertTrue(director.getSurname().equals("New surname"));
	}
	
	public void testDeleteDirectorById() {
		directorDao.deleteDirectorById(2L);
		assertTrue(directorDao.getDirectorById(2L) == null);
	}
	
}