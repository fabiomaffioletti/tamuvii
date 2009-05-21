package com.tamuvii.dao;

import java.util.List;

import com.tamuvii.pojo.DetailedReview;

public interface CustomReviewDAO {
	
	public List<DetailedReview> getDetailedReviewsByMovie(Integer movie);
	
}