package com.tamuvii.service.impl;

import java.util.List;

import com.tamuvii.dao.CustomMovieDAO;
import com.tamuvii.pojo.ShelfItem;
import com.tamuvii.service.MovieManager;

public class MovieManagerImpl implements MovieManager {
	private CustomMovieDAO customMovieDao = null;

	public void setCustomMovieDao(CustomMovieDAO customMovieDao) {
		this.customMovieDao = customMovieDao;
	}


	public List<ShelfItem> getMoviesByUsername(String username) {
		return customMovieDao.getMoviesByUsername(username);
	}

}