package com.tamuvii.pojo;

import java.util.List;

import com.tamuvii.model.Review;


public class ReviewItem {
	private Review review;
	private UserInfo userInfo;
	private Integer opinionCount;
	private List<OpinionItem> opinions;
	
	
	public List<OpinionItem> getOpinions() {
		return opinions;
	}
	public void setOpinions(List<OpinionItem> opinions) {
		this.opinions = opinions;
	}
	public Review getReview() {
		return review;
	}
	public void setReview(Review review) {
		this.review = review;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public Integer getOpinionCount() {
		return opinionCount;
	}
	public void setOpinionCount(Integer opinionCount) {
		this.opinionCount = opinionCount;
	}
	
}