package com.tamuvii.pojo;

import java.util.List;

public class Discussion {
	
	private DetailedReview detailedReview;
	private List<DetailedOpinion> detailedOpinions;

	
	public List<DetailedOpinion> getDetailedOpinions() {
		return detailedOpinions;
	}
	public void setDetailedOpinions(List<DetailedOpinion> detailedOpinions) {
		this.detailedOpinions = detailedOpinions;
	}
	public DetailedReview getDetailedReview() {
		return detailedReview;
	}
	public void setDetailedReview(DetailedReview detailedReview) {
		this.detailedReview = detailedReview;
	}

}