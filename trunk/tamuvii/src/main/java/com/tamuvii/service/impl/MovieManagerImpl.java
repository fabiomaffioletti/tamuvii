package com.tamuvii.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.tamuvii.dao.CustomMovieDAO;
import com.tamuvii.dao.MovieDAO;
import com.tamuvii.dao.UserToMovieDAO;
import com.tamuvii.model.Movie;
import com.tamuvii.model.MovieExample;
import com.tamuvii.model.Review;
import com.tamuvii.model.UserToMovie;
import com.tamuvii.pojo.DetailedReview;
import com.tamuvii.pojo.PersonalMovie;
import com.tamuvii.pojo.ShelfItem;
import com.tamuvii.pojo.SocialMovie;
import com.tamuvii.pojo.queryfilter.PersonalMovieFilterMap;
import com.tamuvii.service.MovieManager;
import com.tamuvii.service.ReviewManager;

public class MovieManagerImpl implements MovieManager {
	private CustomMovieDAO customMovieDao = null;
	private ReviewManager reviewManager = null;
	private MovieDAO movieDao = null;
	private UserToMovieDAO userToMovieDao = null;
	
	public void setUserToMovieDao(UserToMovieDAO userToMovieDao) {
		this.userToMovieDao = userToMovieDao;
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


	public List<ShelfItem> getMoviesByUsername(String username) {
		return customMovieDao.getMoviesByUsername(username);
	}


	public SocialMovie getSocialMovieDetails(Integer movie) {
		SocialMovie socialMovie = customMovieDao.getSocialMovieDetails(movie);
		List<DetailedReview> movieDetailedReviews = new ArrayList<DetailedReview>();
		movieDetailedReviews = reviewManager.getDetailedReviewsByMovie(socialMovie.getMovie());
		socialMovie.setDetailedReviews(movieDetailedReviews);
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

	@SuppressWarnings("unchecked")
	public void updatePersonalMovieDetails(PersonalMovie personalMovie, String username) throws Exception {
		UserToMovie userToMovie = new UserToMovie();
		userToMovie.setUsername(username);
		BeanUtils.copyProperties(userToMovie, personalMovie);
		userToMovieDao.updateByPrimaryKeySelective(userToMovie);
		reviewManager.updatePersonalMovieReviewData(personalMovie, username);
	}

}