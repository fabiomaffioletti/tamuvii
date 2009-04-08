package com.tamuvii.service.impl;

import java.util.List;

import com.tamuvii.dao.CustomMovieDAO;
import com.tamuvii.dao.MovieDAO;
import com.tamuvii.model.Movie;
import com.tamuvii.model.MovieExample;
import com.tamuvii.pojo.ShelfItem;
import com.tamuvii.pojo.SocialMovie;
import com.tamuvii.service.MovieManager;

public class MovieManagerImpl implements MovieManager {
	private CustomMovieDAO customMovieDao = null;
	private MovieDAO movieDao = null;

	public void setCustomMovieDao(CustomMovieDAO customMovieDao) {
		this.customMovieDao = customMovieDao;
	}
	public void setMovieDao(MovieDAO movieDao) {
		this.movieDao = movieDao;
	}


	public List<ShelfItem> getMoviesByUsername(String username) {
		return customMovieDao.getMoviesByUsername(username);
	}


	public SocialMovie getSocialMovieDetails(Integer movieId) {
		return customMovieDao.getSocialMovieDetails(movieId);
	}


	public List<Movie> getAllMovies() {
		return movieDao.selectByExample(null);
	}

}