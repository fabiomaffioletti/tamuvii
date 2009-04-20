package com.tamuvii.service;

import java.util.List;

import com.tamuvii.pojo.PersonalMovie;
import com.tamuvii.model.Movie;
import com.tamuvii.pojo.ShelfItem;
import com.tamuvii.pojo.SocialMovie;

public interface MovieManager {
	
	public List<ShelfItem> getMoviesByUsername(String username);
	
	public List<ShelfItem> getWishedMoviesByUsername(String username);
	
	public SocialMovie getSocialMovieDetails(Integer movie);
	
	public PersonalMovie getPersonalMovieDetails(Integer movie, String username);
	
	public void updatePersonalMovieDetails(PersonalMovie personalMovie, String username) throws Exception;
	
	public List<Movie> getAllMovies();
	
	public List<SocialMovie> searchSocialMovie(String filter);
	
	public boolean doesMovieBelongToUserShelf(Integer movie, String username);
	
	public boolean doesMovieBelongToUserWishlist(Integer movie, String username);
	
	public void addMovieToShelf(Integer movie, String username);
	
	public void addMovieToWishlist(Integer movie, String username);
	
	public List<Integer> getPersonalMoviesIds(String username); 
	
	public List<Integer> getWishedMoviesIds(String username);

}