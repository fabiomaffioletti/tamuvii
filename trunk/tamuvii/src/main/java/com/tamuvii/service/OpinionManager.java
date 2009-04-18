package com.tamuvii.service;

import java.util.List;

import com.tamuvii.model.Opinion;

public interface OpinionManager {
	
	public List<Opinion> getOpinionsByReview(Integer review);
	
	public void insertOpinion(Opinion opinion);
	
	public Opinion doesOpinionBelongToUser(Integer opinionId, String username);
	
	public void deleteOpinion(Opinion opinion);
}