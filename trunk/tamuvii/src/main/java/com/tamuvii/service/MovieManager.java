package com.tamuvii.service;

import java.util.List;

import com.tamuvii.pojo.PersonalMovie;
import com.tamuvii.model.Movie;
import com.tamuvii.pojo.ShelfItem;
import com.tamuvii.pojo.SocialMovie;

public interface MovieManager {
	
	public List<ShelfItem> getMoviesByUsername(String username);
	
	public SocialMovie getSocialMovieDetails(Integer movieId);
	
	public PersonalMovie getPersonalMovieDetails(Integer movieId, String username);
	
	public List<Movie> getAllMovies();

}
