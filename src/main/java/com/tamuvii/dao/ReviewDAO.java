package com.tamuvii.dao;

import java.util.List;
import java.util.Map;

import com.tamuvii.model.Opinion;
import com.tamuvii.model.Review;
import com.tamuvii.pojo.OpinionItem;
import com.tamuvii.pojo.ReviewItem;

public interface ReviewDAO {
	
	public Review getReviewByMovieAndUsername(Map queryMap);
	public List<Review> getReviewsByMovie(Map queryMap);
	public List<Review> getReviewsByUsername(Map queryMap);
	public Integer getReviewsCountByUsername(String username);
	
	public Review isReviewWrittenByUser(Map queryMap);
	public Integer isReviewVotedByUser(Map queryMap);
	public void addReviewVote(Map queryMap);
	
	public void addPositive(Map queryMap);
	public void addNegative(Map queryMap);
	
	public void addReview(Review review);
	public void updateReview(Review review);
	public void deleteReview(Map queryMap);
	
	public ReviewItem getReviewItemByMovieAndUsername(Map queryMap);
	public List<OpinionItem> getReviewOpinions(Map queryMap);
	
	public void addOpinion(Opinion opinion);

}