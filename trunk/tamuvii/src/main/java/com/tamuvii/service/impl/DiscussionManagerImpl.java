package com.tamuvii.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.tamuvii.model.Opinion;
import com.tamuvii.model.Review;
import com.tamuvii.pojo.Discussion;
import com.tamuvii.service.DiscussionManager;
import com.tamuvii.service.OpinionManager;
import com.tamuvii.service.ReviewManager;

public class DiscussionManagerImpl implements DiscussionManager {
	private ReviewManager reviewManager = null;
	private OpinionManager opinionManager = null;
	
	public void setReviewManager(ReviewManager reviewManager) {
		this.reviewManager = reviewManager;
	}

	public void setOpinionManager(OpinionManager opinionManager) {
		this.opinionManager = opinionManager;
	}



	public Discussion getReviewDiscussion(Integer review) {
		Discussion discussion = new Discussion();
		Review discussionReview = reviewManager.getReviewById(review);
		discussion.setReview(discussionReview);
		List<Opinion> opinions = new ArrayList<Opinion>();
		opinions = opinionManager.getOpinionsByReview(discussionReview.getReview());
		discussion.setOpinions(opinions);
		return discussion;
	}

}