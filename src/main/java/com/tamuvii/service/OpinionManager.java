package com.tamuvii.service;

import java.util.List;

import com.tamuvii.exception.IllegalOperationException;
import com.tamuvii.model.Opinion;

public interface OpinionManager {
	
	public List<Opinion> getOpinionsByReview(String reviewer, Long movie);
	public Opinion isOpinionWrittenByUser(Long reviewer, Long movie);
	
	public void addOpinion(Opinion opinion);
	public void addOpinion(Long reviewer, Long movie, String text);
	public void updateOpinion(Opinion opinion);
	public void deleteOpinion(Long id) throws IllegalOperationException;	
	
}