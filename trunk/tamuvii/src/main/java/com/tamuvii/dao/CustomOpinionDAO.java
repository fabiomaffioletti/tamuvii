package com.tamuvii.dao;

import java.util.List;

import com.tamuvii.pojo.DetailedOpinion;

public interface CustomOpinionDAO {
	
	public List<DetailedOpinion> getDetailedOpinionsByReview(Integer review);
	
}