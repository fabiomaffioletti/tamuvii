package com.tamuvii.service.impl;

import java.util.List;

import com.tamuvii.dao.GenreDAO;
import com.tamuvii.model.Genre;
import com.tamuvii.service.GenreManager;

public class GenreManagerImpl implements GenreManager {
	private GenreDAO genreDao = null;

	public void setGenreDao(GenreDAO genreDao) {
		this.genreDao = genreDao;
	}


	public List<Genre> getAll() {
		return genreDao.getAll();
	}


	public Genre getGenreByName(String name) {
		return genreDao.getGenreByName(name);
	}


	public Genre getGenreById(Long id) {
		return genreDao.getGenreById(id);
	}

}
