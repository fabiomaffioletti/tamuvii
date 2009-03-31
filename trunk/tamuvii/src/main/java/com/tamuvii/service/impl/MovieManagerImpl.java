package com.tamuvii.service.impl;

import java.io.Serializable;
import java.util.List;

import com.tamuvii.dao.MovieDao;
import com.tamuvii.model.Movie;
import com.tamuvii.model.User;
import com.tamuvii.service.MovieManager;
import com.tamuvii.service.UserManager;

public class MovieManagerImpl extends GenericManagerImpl<Movie, Serializable> implements MovieManager {
	private MovieDao movieDao;
	private UserManager userManager = null;
	
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	
	public MovieManagerImpl(MovieDao movieDao) {
		super(movieDao);
		this.movieDao = movieDao;
	}

	public List<Movie> findMovieByFilter(String filter) {
		return movieDao.findMovieByFilter(filter);
	}

	public void addMovieToUser(Integer movieId, String username) throws Exception {
		Movie movie = findMovieById(movieId);
		User user = userManager.getUserByUsername(username);
		user.addMovie(movie);
		userManager.saveUser(user);
	}

	public Movie findMovieById(Integer movieId) {
		return movieDao.get(movieId);
	}


	public List<Movie> findMoviesByUsername(String username) {
		User user = userManager.getUserByUsername(username);
		return user.getMovies();
	}

}