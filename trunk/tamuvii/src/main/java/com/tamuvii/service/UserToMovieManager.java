package com.tamuvii.service;

import com.tamuvii.exception.UserToMovieAlreadyAddedToShelfException;
import com.tamuvii.model.UserToMovie;

public interface UserToMovieManager {

	public void updatePersonalMovieDetails(UserToMovie userToMovie);
	
	public boolean doesMovieBelongToUserShelf(Integer movie, String username);
	
	public boolean doesMovieBelongToUserWishlist(Integer movie, String username);
	
	public void addMovieToShelf(Integer movie, String username) throws UserToMovieAlreadyAddedToShelfException;
	
	public void deleteMovieFromShelf(Integer movie, String username);
	
	public void addMovieToWishlist(Integer movie, String username);
	
	public void deleteMovieFromWishlist(Integer movie, String username);
	
	public void moveMovieFromWishlistToShelf(Integer movie, String username);
	
}
