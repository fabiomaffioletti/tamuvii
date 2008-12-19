package com.tamuvii.service.impl;

import com.tamuvii.dao.MovieDao;
import com.tamuvii.model.Movie;
import com.tamuvii.service.MovieManager;

public class MovieManagerImpl extends GenericManagerImpl<Movie, Integer> implements MovieManager {
	MovieDao movieDao;
	
	public MovieManagerImpl(MovieDao movieDao) {
		super(movieDao);
		this.movieDao = movieDao;
	}

}