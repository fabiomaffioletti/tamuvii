package com.tamuvii.service;

import java.util.List;

import com.tamuvii.model.Review;
import com.tamuvii.pojo.PersonalMovie;
import com.tamuvii.pojo.queryfilter.PersonalMovieFilterMap;

public interface ReviewManager {
	
	public Review getReviewById(Integer review);
	
	public Review getReviewByMovie(Integer movie);
	
	public List<Review> getReviewsByMovie(Integer movie);
	
	public Review getPersonalMovieReview(PersonalMovieFilterMap personalMovieFilterMap);
	
	public void updatePersonalMovieReviewData(PersonalMovie personalMovie, String username) throws Exception;

}