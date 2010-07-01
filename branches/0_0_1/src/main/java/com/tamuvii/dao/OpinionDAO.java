package com.tamuvii.dao;

import java.util.List;
import java.util.Map;

import com.tamuvii.model.Opinion;

public interface OpinionDAO {
	
	public List<Opinion> getOpinionsByReview(Map queryMap);
	public Opinion isOpinionWrittenByUser(Map queryMap);
	public Opinion getOpinionById(Long id);
	
	public void addOpinion(Opinion opinion);
	public void updateOpinion(Opinion opinion);
	public void deleteOpinion(Opinion opinion);

}