package com.tamuvii.service.impl;

import java.util.Calendar;

import com.tamuvii.dao.CustomReviewDAO;
import com.tamuvii.model.Opinion;
import com.tamuvii.pojo.Discussion;
import com.tamuvii.service.DiscussionManager;
import com.tamuvii.service.OpinionManager;
import com.tamuvii.service.ReviewManager;

public class DiscussionManagerImpl implements DiscussionManager {
	private ReviewManager reviewManager = null;
	private OpinionManager opinionManager = null;
	private CustomReviewDAO customReviewDao = null;
	

	public void setCustomReviewDao(CustomReviewDAO customReviewDao) {
		this.customReviewDao = customReviewDao;
	}
	public void setReviewManager(ReviewManager reviewManager) {
		this.reviewManager = reviewManager;
	}
	public void setOpinionManager(OpinionManager opinionManager) {
		this.opinionManager = opinionManager;
	}



	public Discussion getReviewDiscussion(Integer review) {
		Discussion discussion = new Discussion();
		discussion.setDetailedReview(customReviewDao.getDetailedReviewById(review));
		discussion.setDetailedOpinions(opinionManager.getDetailedOpinionsByReview(review));		
		return discussion;
	}

	public void insertOpinion(Opinion opinion, String username) {
		opinion.setDateinserted(Calendar.getInstance().getTime());
		opinion.setUsername(username);
		opinionManager.insertOpinion(opinion);
	}

}