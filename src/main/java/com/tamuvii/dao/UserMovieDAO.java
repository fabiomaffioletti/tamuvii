package com.tamuvii.dao;

import java.util.List;
import java.util.Map;

import com.tamuvii.model.UserMovie;
import com.tamuvii.pojo.ShelfItem;

public interface UserMovieDAO {
	
	public List<ShelfItem> getAll(Map queryMap);
	public List<ShelfItem> getAllShelf(Map queryMap);
	public Integer getAllShelfCount(Map queryMap);
	public List<ShelfItem> getAllWishlist(Map queryMap);
	public Integer getAllWishlistCount(Map queryMap);
	public ShelfItem getUserMovieByMovieId(Map queryMap);
	
	public void addUserMovie(UserMovie userMovie);
	public void updateUserMovie(UserMovie userMovie);
	public void deleteUserMovieById(Map queryMap);
	
	public void moveToShelf(Map queryMap);
	
	@SuppressWarnings("unchecked")
	public Map getShelfItemBelonging(Map queryMap);
	@SuppressWarnings("unchecked")
	public Map getMovieItemBelonging(Map queryMap);
	@SuppressWarnings("unchecked")
	public Integer getSingleMovieItemBelonging(Map queryMap);

}