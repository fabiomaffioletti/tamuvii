package com.tamuvii.dao;

import java.util.List;
import java.util.Map;

import com.tamuvii.model.Genre;

public interface GenreDAO {
	
	public List<Genre> getAll();
	
	public List<Genre> getMovieGenres(Long id);
	
	public Genre getGenreByName(String name);

	public Genre getGenreById(Long id);
	
	public void deleteMovieGenres(Long movie);
	
	public void addMovieGenre(Map queryMap);
}