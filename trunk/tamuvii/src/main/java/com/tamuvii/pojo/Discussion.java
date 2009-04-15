package com.tamuvii.pojo;

import java.util.List;

import com.tamuvii.model.Opinion;
import com.tamuvii.model.Review;

public class Discussion {
	
	private Review review;
	private List<Opinion> opinions;

	
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