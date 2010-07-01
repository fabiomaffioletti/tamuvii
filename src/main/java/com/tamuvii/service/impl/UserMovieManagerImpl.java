package com.tamuvii.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.tamuvii.dao.ReviewDAO;
import com.tamuvii.dao.UserDAO;
import com.tamuvii.dao.UserMovieDAO;
import com.tamuvii.exception.IllegalOperationException;
import com.tamuvii.model.Review;
import com.tamuvii.model.UserMovie;
import com.tamuvii.pojo.MovieItem;
import com.tamuvii.pojo.ShelfItem;
import com.tamuvii.service.UserMovieManager;
import com.tamuvii.util.RequestUtils;

public class UserMovieManagerImpl extends ApplicationManager implements UserMovieManager {
	private UserMovieDAO userMovieDao = null;
	private UserDAO userDao = null;
	private ReviewDAO reviewDao = null;

	public void setReviewDao(ReviewDAO reviewDao) {
		this.reviewDao = reviewDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	public void setUserMovieDao(UserMovieDAO userMovieDao) {
		this.userMovieDao = userMovieDao;
	}
	
	
	/*
	 * DWR METHODS
	 */
	public void addUserMovie(Long movie, Integer mark, Integer wishlist) throws IllegalOperationException {
		String username = RequestUtils.getRequestUsername(null);
		if(getUserMovieByMovieId(username, movie)==null) {
			UserMovie userMovie = new UserMovie();
			userMovie.setUser(userDao.getUserByUsername(username).getId());
			userMovie.setMovie(movie);
			userMovie.setMark(mark);
			userMovie.setDateAdded(new Date());
			userMovie.setWishlist(wishlist);
			saveUserMovie(userMovie);
		} else {
			log.warn("User "+username+" is trying to add movie with id: "+movie+" again");
			throw new IllegalOperationException("User "+username+" is trying to add movie with id: "+movie+" again");
		}
	}
	
	@SuppressWarnings("unchecked")
	public void deleteUserMovieById(Long movie) throws IllegalOperationException {
		String username = RequestUtils.getRequestUsername(null);
		if(getUserMovieByMovieId(username, movie) != null) {
			Map queryMap = new HashMap();
			queryMap.put("username", username);
			queryMap.put("movie", movie);
			userMovieDao.deleteUserMovieById(queryMap);
		} else {
			log.warn("User " + username + " trying to delete an unowned movie with id: "+movie);
			throw new IllegalOperationException("User " + username + " trying to delete an unowned movie with id: "+movie);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void moveToShelf(Long movie) throws IllegalOperationException {
		String username = RequestUtils.getRequestUsername(null);
		if(getUserMovieByMovieId(username, movie) != null) {
			Map queryMap = new HashMap();
			queryMap.put("username", username);
			queryMap.put("movie", movie);
			userMovieDao.moveToShelf(queryMap);
		} else {
			log.warn("User " + username + " is trying to move to shelf another's one movie with id: "+movie);
			throw new IllegalOperationException("User " + username + " is trying to move to shelf another's one movie with id: "+movie);
		}
	}

	
	
	/*
	 * APPLICATION METHODS: SAVE/UPDATE/REMOVE (updateUserMovie is a DWR Method)
	 * 
	 */
	public void saveUserMovie(UserMovie userMovie) {
		userMovieDao.addUserMovie(userMovie);
	}
	@SuppressWarnings("unchecked")
	public void updateUserMovie(Long movie, Integer mark, String dateViewed, String reviewTitle, String reviewText) throws IllegalOperationException, java.text.ParseException {
		String username = RequestUtils.getRequestUsername(null);
		ShelfItem shelfItem = getUserMovieByMovieId(username, movie);
		
		
		// Save review if title or text are different from the previous
		if(shelfItem.getReview() != null) {
			if(!(shelfItem.getReview().getTitle().equals(reviewTitle) && shelfItem.getReview().getText().equals(reviewText))) {
				Map queryMap = new HashMap();
				queryMap.put("username", username);
				queryMap.put("movie", movie);
				Review review = reviewDao.getReviewByMovieAndUsername(queryMap);
				review.setText(reviewText);
				review.setTitle(reviewTitle);
				reviewDao.updateReview(review);
			}
		} else {
			Review review = new Review();
			review.setDateAdded(new Date());
			review.setUser(userDao.getUserByUsername(username).getId());
			review.setMovie(movie);
			review.setText(reviewText);
			review.setTitle(reviewTitle);
			reviewDao.addReview(review);
		}
		
		
		// Save mark
		if(shelfItem != null) {
			UserMovie userMovie = shelfItem.getUserMovie();
			userMovie.setMark(mark);
			userMovie.setDateViewed(StringUtils.isNotEmpty(dateViewed)?sdf.parse(dateViewed):null);
			userMovieDao.updateUserMovie(userMovie);
		} else {
			log.warn("User " + username + " is trying to modify another's one movie with id: "+movie);
			throw new IllegalOperationException("User " + username + " is trying to modify another's one movie with id: "+movie);
		}
		
	}
	

	
	/*
	 * APPLICATION METHODS: GETTERS
	 */
	@SuppressWarnings("unchecked")
	public List<ShelfItem> getAll(String username, Integer from, Integer to) {
		Map queryMap = new HashMap();
		queryMap.put("username", username);
		queryMap.put("from", from);
		queryMap.put("to", to);
		return userMovieDao.getAll(queryMap);
	}

	@SuppressWarnings("unchecked")
	public List<ShelfItem> getAllShelf(String filter, String username, Integer from, Integer to) {
		Map queryMap = new HashMap();
		queryMap.put("filter", !StringUtils.isEmpty(filter)?filter.split(" "):null);
		queryMap.put("username", username);
		queryMap.put("from", from);
		queryMap.put("to", to);
		return userMovieDao.getAllShelf(queryMap);
	}
	@SuppressWarnings("unchecked")
	public Integer getAllShelfCount(String filter, String username) {
		Map queryMap = new HashMap();
		queryMap.put("username", username);
		queryMap.put("filter", !StringUtils.isEmpty(filter)?filter.split(" "):null);
		return userMovieDao.getAllShelfCount(queryMap);
	}

	@SuppressWarnings("unchecked")
	public List<ShelfItem> getAllWishlist(String filter, String username, Integer from, Integer to) {
		Map queryMap = new HashMap();
		queryMap.put("filter", !StringUtils.isEmpty(filter)?filter.split(" "):null);
		queryMap.put("username", username);
		queryMap.put("from", from);
		queryMap.put("to", to);
		return userMovieDao.getAllWishlist(queryMap);
	}
	@SuppressWarnings("unchecked")
	public Integer getAllWishlistCount(String filter, String username) {
		Map queryMap = new HashMap();
		queryMap.put("username", username);
		queryMap.put("filter", !StringUtils.isEmpty(filter)?filter.split(" "):null);
		return userMovieDao.getAllWishlistCount(queryMap);
	}

	@SuppressWarnings("unchecked")
	public ShelfItem getUserMovieByMovieId(String username, Long movie) {
		Map queryMap = new HashMap();
		queryMap.put("username", RequestUtils.getRequestUsername(username));
		queryMap.put("movie", movie);
		return userMovieDao.getUserMovieByMovieId(queryMap);
	}

	@SuppressWarnings("unchecked")
	public Map getShelfItemBelonging(String first, String second, List<ShelfItem> items) {
		Map queryMap = new HashMap();
		queryMap.put("first", first);
		queryMap.put("second", second);
		queryMap.put("items", items);
		return userMovieDao.getShelfItemBelonging(queryMap);
	}

	@SuppressWarnings("unchecked")
	public Map getMovieItemBelonging(String username, List<MovieItem> items) {
		Map queryMap = new HashMap();
		queryMap.put("username", username);
		queryMap.put("items", items);
		return userMovieDao.getMovieItemBelonging(queryMap);
	}

	@SuppressWarnings("unchecked")
	public Integer getSingleMovieItemBelonging(String username, Long movie) {
		Map queryMap = new HashMap();
		queryMap.put("username", username);
		queryMap.put("movie", movie);
		return userMovieDao.getSingleMovieItemBelonging(queryMap);
	}

}