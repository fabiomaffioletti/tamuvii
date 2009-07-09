package com.tamuvii.service;

import java.util.List;

import com.tamuvii.model.Review;
import com.tamuvii.pojo.DetailedReview;
import com.tamuvii.pojo.PersonalMovie;
import com.tamuvii.pojo.queryfilter.PersonalMovieFilterMap;
import com.tamuvii.pojo.queryfilter.SocialMovieFilter;

public interface ReviewManager {
	
	public Review getReviewById(Integer review);
	
	public Review getReviewByMovie(Integer movie);
	
	public void deleteReview(Integer movie, String username);
	
	public List<DetailedReview> getDetailedReviewsByMovie(SocialMovieFilter smf);
	
	public List<Review> getReviewsByMovie(Integer movie);
	
	public Review getPersonalMovieReview(PersonalMovieFilterMap personalMovieFilterMap);
	
	public void updatePersonalMovieReviewData(PersonalMovie personalMovie, String username) throws Exception;

	public void updateReviewById(Review r);
	
	public boolean isReviewOwner(String username, Integer review);
	
}