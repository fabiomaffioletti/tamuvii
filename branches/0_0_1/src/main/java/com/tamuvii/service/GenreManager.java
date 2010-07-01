package com.tamuvii.service;

import java.util.List;

import com.tamuvii.model.Genre;

public interface GenreManager {

	public List<Genre> getAll();
	
	public Genre getGenreByName(String name);
	
	public Genre getGenreById(Long id);
	
}
