package com.tamuvii.service;

import com.tamuvii.model.Opinion;
import com.tamuvii.pojo.Discussion;

public interface DiscussionManager {
	
	public Discussion getReviewDiscussion(Integer review);

	public void insertOpinion(Opinion opinion, String username);
}