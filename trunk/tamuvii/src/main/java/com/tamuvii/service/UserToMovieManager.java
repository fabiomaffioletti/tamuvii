package com.tamuvii.service;

import com.tamuvii.model.UserToMovie;

public interface UserToMovieManager {

	public void updatePersonalMovieDetails(UserToMovie userToMovie);
	
	public boolean doesMovieBelongToUserShelf(Integer movie, String username);
	
	public boolean doesMovieBelongToUserWishlist(Integer movie, String username);
	
	public void addMovieToShelf(Integer movie, String username);
	
	public void addMovieToWishlist(Integer movie, String username);
	
}
