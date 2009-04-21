package com.tamuvii.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.tamuvii.dao.CustomMovieDAO;
import com.tamuvii.dao.MovieDAO;
import com.tamuvii.model.Movie;
import com.tamuvii.model.MovieExample;
import com.tamuvii.model.Review;
import com.tamuvii.model.UserToMovie;
import com.tamuvii.pojo.DetailedReview;
import com.tamuvii.pojo.MovieUser;
import com.tamuvii.pojo.PersonalMovie;
import com.tamuvii.pojo.PersonalMovieIdAndWishedFlag;
import com.tamuvii.pojo.SearchMovieFilter;
import com.tamuvii.pojo.ShelfItem;
import com.tamuvii.pojo.SocialMovie;
import com.tamuvii.pojo.queryfilter.PersonalMovieFilterMap;
import com.tamuvii.service.MovieManager;
import com.tamuvii.service.ReviewManager;
import com.tamuvii.service.UserToMovieManager;

public class MovieManagerImpl implements MovieManager {
	private CustomMovieDAO customMovieDao = null;
	private ReviewManager reviewManager = null;
	private MovieDAO movieDao = null;
	private UserToMovieManager userToMovieManager = null;
	
	public void setUserToMovieManager(UserToMovieManager userToMovieManager) {
		this.userToMovieManager = userToMovieManager;
	}
	public void setReviewManager(ReviewManager reviewManager) {
		this.reviewManager = reviewManager;
	}
	public void setCustomMovieDao(CustomMovieDAO customMovieDao) {
		this.customMovieDao = customMovieDao;
	}
	public void setMovieDao(MovieDAO movieDao) {
		this.movieDao = movieDao;
	}


	public List<ShelfItem> getShelfByUsername(String username) {
		return customMovieDao.getShelfByUsername(username);
	}
	
	public List<ShelfItem> getWishedMoviesByUsername(String username) {
		return customMovieDao.getWishedMoviesByUsername(username);
	}


	public SocialMovie getSocialMovieDetails(Integer movie) {
		SocialMovie socialMovie = customMovieDao.getSocialMovieDetails(movie);
		List<DetailedReview> movieDetailedReviews = new ArrayList<DetailedReview>();
		movieDetailedReviews = reviewManager.getDetailedReviewsByMovie(socialMovie.getMovie());
		socialMovie.setDetailedReviews(movieDetailedReviews);
		List<MovieUser> users = customMovieDao.getUsersByMovie(movie);
		socialMovie.setMovieUsers(users);
		return socialMovie;
	}


	public PersonalMovie getPersonalMovieDetails(Integer movie, String username) {
		/*
		 * Fetch personal movie data
		 */
		PersonalMovieFilterMap personalMovieFilterMap = new PersonalMovieFilterMap(movie, username);
		PersonalMovie personalMovie = new PersonalMovie();
		personalMovie = customMovieDao.getPersonalMovieDetails(personalMovieFilterMap);
		
		/*
		 * Fetch personal review
		 */
		Review personalReview = reviewManager.getPersonalMovieReview(personalMovieFilterMap);
		personalMovie.setReview(personalReview);

		return personalMovie; 
	}


	@SuppressWarnings("unchecked")
	public List<Movie> getAllMovies() {
		MovieExample movieExample = new MovieExample();
		movieExample.setOrderByClause("original_title");
		return movieDao.selectByExample(movieExample);
	}

	public void updatePersonalMovieDetails(PersonalMovie personalMovie, String username) throws Exception {
		UserToMovie userToMovie = new UserToMovie();
		userToMovie.setUsername(username);
		BeanUtils.copyProperties(userToMovie, personalMovie);
		userToMovieManager.updatePersonalMovieDetails(userToMovie);
		reviewManager.updatePersonalMovieReviewData(personalMovie, username);
	}
	
	public List<SocialMovie> searchSocialMovie(String filter) {
		String[] splittedFilter = filter.split(" ");
		for (int i=0; i<splittedFilter.length; i++) {
			splittedFilter[i] = "%" + splittedFilter[i] + "%"; 
		}
		
		SearchMovieFilter searchMovieFilter = new SearchMovieFilter();
		searchMovieFilter.setFilter(splittedFilter);
		return customMovieDao.searchSocialMovie(searchMovieFilter);
	}
	
	
	public boolean doesMovieBelongToUserShelf(Integer movie, String username) {
		return userToMovieManager.doesMovieBelongToUserShelf(movie, username);
	}
	
	public boolean doesMovieBelongToUserWishlist(Integer movie, String username) {
		return userToMovieManager.doesMovieBelongToUserWishlist(movie, username);
	}
	
	
	public void addMovieToShelf(Integer movie, String username) {
		userToMovieManager.addMovieToShelf(movie, username);
	}
	
	public void addMovieToWishlist(Integer movie, String username) {
		userToMovieManager.addMovieToWishlist(movie, username);
	}
	
	
	public List<Integer> getPersonalMoviesIds(String username) {
		return customMovieDao.getPersonalMoviesIds(username);
	}
	
	public List<Integer> getWishedMoviesIds(String username) {
		return customMovieDao.getWishedMoviesIds(username);
	}
	
	public List<PersonalMovieIdAndWishedFlag> getPersonalMoviesIdsAndWishedFlags(
			String username) {
		return customMovieDao.getPersonalMoviesIdsAndWishedFlags(username);
	}
	
	
	public void deleteMovieFromShelf(Integer movie, String username) {
		if(doesMovieBelongToUserShelf(movie, username)) {
			userToMovieManager.deleteMovieFromShelf(movie, username);
		}
	}
	
	public void deleteMovieFromWishlist(Integer movie, String username) {
		if(doesMovieBelongToUserWishlist(movie, username)) {
			userToMovieManager.deleteMovieFromWishlist(movie, username);
		}
	}
	public void moveMovieFromWishlistToShelf(Integer movie, String username) {
		if(doesMovieBelongToUserWishlist(movie, username)) {
			userToMovieManager.moveMovieFromWishlistToShelf(movie, username);
		}
	}

}