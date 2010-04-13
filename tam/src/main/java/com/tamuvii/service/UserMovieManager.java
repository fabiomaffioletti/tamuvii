package com.tamuvii.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.lowagie.text.pdf.codec.postscript.ParseException;
import com.tamuvii.exception.IllegalOperationException;
import com.tamuvii.model.UserMovie;
import com.tamuvii.pojo.MovieItem;
import com.tamuvii.pojo.ShelfItem;

public interface UserMovieManager {
	
	public List<ShelfItem> getAll(String username, Integer from, Integer to);
	public List<ShelfItem> getAllShelf(String filter, String username, Integer from, Integer to);
	
	public Integer getAllShelfCount(String filter, String username);
	public List<ShelfItem> getAllWishlist(String filter, String username, Integer from, Integer to);
	
	public Integer getAllWishlistCount(String filter, String username);
	public ShelfItem getUserMovieByMovieId(String username, Long movie);
	
	public void saveUserMovie(UserMovie userMovie);
	public void addUserMovie(Long movie, Integer mark, Integer wishlist) throws IllegalOperationException;
	public void updateUserMovie(Long movie, Integer mark, String dateViewed, String reviewTitle, String reviewText) throws IllegalOperationException, java.text.ParseException;
	public void deleteUserMovieById(Long movie) throws IllegalOperationException;
	
	public void moveToShelf(Long movie) throws IllegalOperationException;
	
	public Map getShelfItemBelonging(String first, String second, List<ShelfItem> items);
	public Map getMovieItemBelonging(String username, List<MovieItem> items);
	public Integer getSingleMovieItemBelonging(String username, Long movie);
}