package com.tamuvii.dao;

import java.util.List;

import com.tamuvii.model.Genre;

public interface GenreDAO {
	
	public List<Genre> getAll();
	
	public List<Genre> getMovieGenres(Long id);
	
	public Genre getGenreByName(String name);
}