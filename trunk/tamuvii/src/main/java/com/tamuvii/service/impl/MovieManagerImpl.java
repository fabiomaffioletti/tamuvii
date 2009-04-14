package com.tamuvii.service.impl;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.tamuvii.dao.CustomMovieDAO;
import com.tamuvii.dao.MovieDAO;
import com.tamuvii.dao.ReviewDAO;
import com.tamuvii.dao.UserToMovieDAO;
import com.tamuvii.model.Movie;
import com.tamuvii.model.MovieExample;
import com.tamuvii.model.Review;
import com.tamuvii.model.ReviewExample;
import com.tamuvii.model.UserToMovie;
import com.tamuvii.model.ReviewExample.Criteria;
import com.tamuvii.pojo.PersonalMovie;
import com.tamuvii.pojo.ShelfItem;
import com.tamuvii.pojo.SocialMovie;
import com.tamuvii.pojo.queryfilter.PersonalMovieFilterMap;
import com.tamuvii.service.MovieManager;

public class MovieManagerImpl implements MovieManager {
	private CustomMovieDAO customMovieDao = null;
	private ReviewDAO reviewDao = null;
	private MovieDAO movieDao = null;
	private UserToMovieDAO userToMovieDao = null;
	
	public void setUserToMovieDao(UserToMovieDAO userToMovieDao) {
		this.userToMovieDao = userToMovieDao;
	}

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


	public SocialMovie getSocialMovieDetails(Integer movie) {
		return customMovieDao.getSocialMovieDetails(movie);
	}


	@SuppressWarnings("unchecked")
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
		ReviewExample reviewExample = new ReviewExample();
		Criteria reviewCriteria = reviewExample.createCriteria();
		reviewCriteria.andMovieEqualTo(personalMovieFilterMap.getMovie());
		reviewCriteria.andUsernameEqualTo(personalMovieFilterMap.getUsername());
		List<Review> reviews = reviewDao.selectByExample(reviewExample);
		personalMovie.setReview( (reviews.size() > 0) ? (Review) reviews.get(0) : new Review() );
		
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
		Review review = new Review();
		userToMovie.setUsername(username);
		BeanUtils.copyProperties(userToMovie, personalMovie);
		BeanUtils.copyProperties(review, personalMovie.getReview());
		userToMovieDao.updateByPrimaryKeySelective(userToMovie);
		
		ReviewExample reviewExample = new ReviewExample();
		Criteria reviewCriteria = reviewExample.createCriteria();
		reviewCriteria.andUsernameEqualTo(username);
		reviewCriteria.andMovieEqualTo(personalMovie.getMovie());
		Review tempReview = (Review) reviewDao.selectByExample(reviewExample).get(0); 
		if(tempReview != null) {
			review.setReview(tempReview.getReview());
			review.setMovie(personalMovie.getMovie());
			review.setUsername(username);
			reviewDao.updateByExampleSelective(review, reviewExample);
		}
		else {
			review.setMovie(personalMovie.getMovie());
			review.setUsername(username);
			review.setDateinserted(Calendar.getInstance().getTime());
			reviewDao.insertSelective(review);
		}
	}

}