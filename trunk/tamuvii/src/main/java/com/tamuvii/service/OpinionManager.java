package com.tamuvii.service;

import java.util.List;

import com.tamuvii.model.Opinion;
import com.tamuvii.pojo.DetailedOpinion;

public interface OpinionManager {
	
	public List<Opinion> getOpinionsByReview(Integer review);
	
	public List<DetailedOpinion> getDetailedOpinionsByReview(Integer review);
	
	public void insertOpinion(Opinion opinion);
	
	public Opinion doesOpinionBelongToUser(Integer opinionId, String username);
	
	public void deleteOpinion(Opinion opinion);
}