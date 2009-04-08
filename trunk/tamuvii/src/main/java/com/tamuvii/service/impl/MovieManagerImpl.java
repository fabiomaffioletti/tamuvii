package com.tamuvii.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.tamuvii.dao.CustomMovieDAO;
import com.tamuvii.dao.ReviewDAO;
import com.tamuvii.model.Review;
import com.tamuvii.model.ReviewExample;
import com.tamuvii.model.UserToMovie;
import com.tamuvii.model.ReviewExample.Criteria;
import com.tamuvii.pojo.PersonalMovie;
import com.tamuvii.dao.MovieDAO;
import com.tamuvii.model.Movie;
import com.tamuvii.model.MovieExample;
import com.tamuvii.pojo.ShelfItem;
import com.tamuvii.pojo.SocialMovie;
import com.tamuvii.pojo.queryfilter.PersonalMovieFilterMap;
import com.tamuvii.service.MovieManager;

public class MovieManagerImpl implements MovieManager {
	private CustomMovieDAO customMovieDao = null;
	private ReviewDAO reviewDao = null;
	private MovieDAO movieDao = null;

	public void setReviewDao(ReviewDAO reviewDao) {
		this.reviewDao = reviewDao;
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


	public SocialMovie getSocialMovieDetails(Integer movieId) {
		return customMovieDao.getSocialMovieDetails(movieId);
	}


	@SuppressWarnings("unchecked")
	public PersonalMovie getPersonalMovieDetails(Integer movieId, String username) {
		/*
		 * Fetch personal movie data
		 */
		PersonalMovieFilterMap personalMovieFilterMap = new PersonalMovieFilterMap(movieId, username);
		PersonalMovie personalMovie = new PersonalMovie();
		personalMovie = customMovieDao.getPersonalMovieDetails(personalMovieFilterMap);
		
		/*
		 * Fetch personal review
		 */
		ReviewExample reviewExample = new ReviewExample();
		Criteria reviewCriteria = reviewExample.createCriteria();
		reviewCriteria.andMovieEqualTo(personalMovieFilterMap.getMovieId());
		reviewCriteria.andUsernameEqualTo(personalMovieFilterMap.getUsername());
		List<Review> reviews = reviewDao.selectByExample(reviewExample);
		personalMovie.setReview( (reviews.size() > 0) ? (Review) reviews.get(0) : new Review() );
		
		return personalMovie; 
	}


	@SuppressWarnings("unchecked")
	public List<Movie> getAllMovies() {
		return movieDao.selectByExample(null);
	}

	public void updatePersonalMovieDetails(PersonalMovie personalMovie, String username) throws Exception {
		UserToMovie userToMovie = new UserToMovie();
		BeanUtils.copyProperties(userToMovie, personalMovie);
		
	}

}