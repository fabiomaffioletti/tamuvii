package com.tamuvii.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tamuvii.model.Movie;
import com.tamuvii.pojo.MovieItem;

public class MovieDaoTest extends ApplicationTest {
	private MovieDAO movieDao = null;

	public void setMovieDao(MovieDAO movieDao) {
		this.movieDao = movieDao;
	}
	

	@SuppressWarnings("unchecked")
	public void testGetAll() {
		Map queryMap = new HashMap();
		queryMap.put("filter", null);
		queryMap.put("filter", new String[]{"giorgio", "uomo"});
		queryMap.put("from", 0);
		queryMap.put("to", 10);
		List<MovieItem> movies = movieDao.getAll(queryMap);
		assertNotNull(movies);
		assertTrue(movies.size() == 1);
		
		queryMap = new HashMap();
		queryMap.put("filter", new String[]{"giorgio"});
		queryMap.put("from", 0);
		queryMap.put("to", 10);
		movies = movieDao.getAll(queryMap);
		assertNotNull(movies);
		assertTrue(movies.size() == 2);
		
		queryMap = new HashMap();
		queryMap.put("filter", new String[]{"uomo"});
		queryMap.put("from", 0);
		queryMap.put("to", 10);
		movies = movieDao.getAll(queryMap);
		assertNotNull(movies);
		assertTrue(movies.size() == 1);
		
		queryMap = new HashMap();
		queryMap.put("filter", new String[]{"anna"});
		queryMap.put("from", 0);
		queryMap.put("to", 10);
		movies = movieDao.getAll(queryMap);
		assertTrue(movies.size() == 0);
		
		queryMap = new HashMap();
		queryMap.put("from", 0);
		queryMap.put("to", 10);
		movies = movieDao.getAll(queryMap);
		assertTrue(movies.size() > 3);
	}
	
	public void testGetMovieById() {
		Movie m = movieDao.getMovieById(2L);
		assertNotNull(m);
		assertTrue(m.getTitle().equals("Il vento fa il suo giro"));
	}
	
	public void testAddMovie() {
		Movie movie = new Movie();
		movie.setTitle("title");
		movie.setPlot("plot");
		movie.setDuration(110);
		movie.setDirector(3L);
		movie.setImage(null);
		movie.setYear(2009);
		movie.setDateAdded(new Date());
		Long ret = movieDao.addMovie(movie);
		assertNotNull(ret);
		assertTrue(movieDao.getAll(null).size() > 4);
	}
	
	public void testUpdateMovie() {
		Movie movie = movieDao.getMovieById(2L);
		movie.setDirector(1L);
		movieDao.updateMovie(movie);
		movie = movieDao.getMovieById(2L);
		assertTrue(movie.getDirector() == 1L);
	}
	
	public void testDeleteMovieById() {
		movieDao.deleteMovieById(2L);
		assertTrue(movieDao.getMovieById(2L) == null);
	}
	
	public void testGetMovieItemMarks() {
		assertNotNull(movieDao.getMovieItemMarks(3L));
	}
	
	@SuppressWarnings("unchecked")
	public void testGetMoviesByDirector() {
		Map queryMap = new HashMap();
		queryMap.put("id", 3);
		queryMap.put("from", 0);
		queryMap.put("to", 10);
		List mi = (List) movieDao.getMoviesByDirector(queryMap);
		assertNotNull(mi);
		assertTrue(mi.size() == 2);
	}
	
	@SuppressWarnings("unchecked")
	public void testGetReviewsByMovie() {
		Map queryMap = new HashMap();
		queryMap.put("movie", 1);
		queryMap.put("from", 0);
		queryMap.put("to", 10);
		List reviews = movieDao.getReviewItemsByMovie(queryMap);
		assertNotNull(reviews);
		assertTrue(reviews.size() == 2);
	}
	
}