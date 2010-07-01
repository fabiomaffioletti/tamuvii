package com.tamuvii.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tamuvii.model.UserMovie;
import com.tamuvii.pojo.MovieItem;
import com.tamuvii.pojo.ShelfItem;

public class UserMovieDaoTest extends ApplicationTest {
	private UserMovieDAO userMovieDao = null;
	private MovieDAO movieDao = null;

	public void setUserMovieDao(UserMovieDAO userMovieDao) {
		this.userMovieDao = userMovieDao;
	}
	public void setMovieDao(MovieDAO movieDao) {
		this.movieDao = movieDao;
	}



	@SuppressWarnings("unchecked")
	public void testGetAll() {
		Map queryMap = new HashMap();
		queryMap.put("username", "fubbyo");
		queryMap.put("from", 0);
		queryMap.put("to", 10);
		List<ShelfItem> um = userMovieDao.getAll(queryMap);
		assertNotNull(um);
		assertTrue(um.size() == 3);
		
		um = userMovieDao.getAllShelf(queryMap);
		assertNotNull(um);
		assertTrue(um.size() == 2);
		
		um = userMovieDao.getAllWishlist(queryMap);
		assertNotNull(um);
		assertTrue(um.size() == 1);
		
		queryMap = new HashMap();
		queryMap.put("username", "andrea");
		um = userMovieDao.getAll(queryMap);
		assertTrue(um.size() == 0);
		
	}
	
	@SuppressWarnings("unchecked")
	public void testGetUserMovieByMovieId() {
		Map queryMap = new HashMap();
		queryMap.put("username", "fubbyo");
		queryMap.put("movie", 1L);
		ShelfItem um = userMovieDao.getUserMovieByMovieId(queryMap);
		assertNotNull(um);
		assertTrue(um.getUserMovie().getMark() == 1);
	}
	
	@SuppressWarnings("unchecked")
	public void testAddUserMovie() {
		UserMovie um = new UserMovie();
		um.setUser(6L);
		um.setMovie(3L);
		um.setDateAdded(new Date());
		um.setMark(5);
		um.setWishlist(0);
		userMovieDao.addUserMovie(um);
		
		Map queryMap = new HashMap();
		queryMap.put("username", "andrea");
		queryMap.put("movie", 3L);
		assertNotNull(userMovieDao.getUserMovieByMovieId(queryMap));
	}
	
	@SuppressWarnings("unchecked")
	public void testUpdateUserMovie() {
		Map queryMap = new HashMap();
		queryMap.put("username", "fubbyo");
		queryMap.put("movie", 1L);
		ShelfItem um = userMovieDao.getUserMovieByMovieId(queryMap);
		um.getUserMovie().setMark(2);
		userMovieDao.updateUserMovie(um.getUserMovie());
		um = userMovieDao.getUserMovieByMovieId(queryMap);
		assertTrue(um.getUserMovie().getMark() == 2);
	}
	
	@SuppressWarnings("unchecked")
	public void testDeleteUserMovie() {
		Map queryMap = new HashMap();
		queryMap.put("username", "fubbyo");
		queryMap.put("movie", 1L);
		userMovieDao.deleteUserMovieById(queryMap);
		assertTrue(userMovieDao.getAll(queryMap).size() == 2);
	}
	
	@SuppressWarnings("unchecked")
	public void testGetShelfItemBelonging() {
		Map queryMap = new HashMap();
		queryMap.put("username", "elisa");
		queryMap.put("from", 0);
		queryMap.put("to", 10);
		List<ShelfItem> items = userMovieDao.getAllShelf(queryMap);
		
		queryMap = new HashMap();
		queryMap.put("first", "fubbyo");
		queryMap.put("second", "elisa");
		queryMap.put("items", items);
		Map belongings = userMovieDao.getMovieItemBelonging(queryMap);
		assertNotNull(belongings);
	}
	
	@SuppressWarnings("unchecked")
	public void testGetMovieItemBelonging() {
		Map queryMap = new HashMap();
		queryMap.put("id", 3);
		queryMap.put("from", 0);
		queryMap.put("to", 10);
		List<MovieItem> items = movieDao.getMoviesByDirector(queryMap);
		
		queryMap = new HashMap();
		queryMap.put("first", "fubbyo");
		queryMap.put("items", items);
		Map belongings = userMovieDao.getMovieItemBelonging(queryMap);
		assertNotNull(belongings);
	}
	
}