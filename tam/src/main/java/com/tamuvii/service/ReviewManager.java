package com.tamuvii.service;

import java.util.Date;
import java.util.List;

import com.tamuvii.exception.IllegalOperationException;
import com.tamuvii.model.Review;
import com.tamuvii.pojo.OpinionItem;
import com.tamuvii.pojo.ReviewItem;

public interface ReviewManager {
	
	public Review getReviewByMovieAndUsername(Long movie, String username);
	public List<Review> getReviewsByMovie(Long movie, Integer from, Integer to);
	public List<Review> getReviewsByUsername(String username, Integer from, Integer to);
	
	public Integer getReviewsCountByUsername(String username);
	
	public Review isReviewWrittenByUser(Long movie);
	public Integer isReviewVotedByUser(String voter, Long movie, String reviewer);
	public void addPositive(Long movie, String username) throws IllegalOperationException;
	public void addNegative(Long movie, String username) throws IllegalOperationException;
	
	public void addReview(Review review);
	public void addReview(Long movie, String title, String text, Date dateAdded);
	public void updateReview(Review review);
	public void deleteReview(Long movie);
	
	public ReviewItem getReviewItemByMovieAndUsername(Long movie, String username);
	public List<OpinionItem> getReviewOpinions(Long movie, String username);
	public void addOpinion(Long movie, Long user, String text);
	
}