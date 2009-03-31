package com.tamuvii.service;

import java.io.Serializable;
import java.util.List;

import com.tamuvii.model.Movie;

public interface MovieManager extends GenericManager<Movie, Serializable> {
	
	public List<Movie> findMovieByFilter(String filter);
	
	public void addMovieToUser(Integer movieid, String username) throws Exception;
	
	public Movie findMovieById(Integer movieId);
	
	public List<Movie> findMoviesByUsername(String username); 

}