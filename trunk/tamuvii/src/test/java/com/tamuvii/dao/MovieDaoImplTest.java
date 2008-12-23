package com.tamuvii.dao;

import java.util.List;
import java.util.Locale;

import com.tamuvii.model.Movie;

public class MovieDaoImplTest extends BaseDaoTestCase {
	
	private MovieDao movieDao = null;

	public void setMovieDao(MovieDao movieDao) {
		this.movieDao = movieDao;
	}

	
	public void testGetAllMoviesByLocale() {
		List<Movie> movies = movieDao.getAllMoviesByLocale(Locale.ITALY);
		assertNotNull(movies);
	}
	
}
