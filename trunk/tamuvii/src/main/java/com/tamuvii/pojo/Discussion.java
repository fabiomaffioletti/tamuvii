package com.tamuvii.pojo;

import java.util.List;

import com.tamuvii.model.Opinion;
import com.tamuvii.model.Review;

public class Discussion {
	
	private DetailedReview detailedReview;
	private Review review;
	private List<Opinion> opinions;
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
	public Review getReview() {
		return review;
	}
	public void setReview(Review review) {
		this.review = review;
	}
	public List<Opinion> getOpinions() {
		return opinions;
	}
	public void setOpinions(List<Opinion> opinions) {
		this.opinions = opinions;
	}

}