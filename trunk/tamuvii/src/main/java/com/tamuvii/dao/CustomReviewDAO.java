package com.tamuvii.dao;

import java.util.List;

import com.tamuvii.pojo.DetailedReview;
import com.tamuvii.pojo.queryfilter.SocialMovieFilter;

public interface CustomReviewDAO {
	
	public List<DetailedReview> getDetailedReviewsByMovie(SocialMovieFilter smf);
	
	public DetailedReview getDetailedReviewById(Integer review);
	
}