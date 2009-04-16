package com.tamuvii.service.impl;

import com.tamuvii.dao.OpinionDAO;
import com.tamuvii.dao.ReviewDAO;
import com.tamuvii.model.ReviewExample;
import com.tamuvii.pojo.Discussion;
import com.tamuvii.service.DiscussionManager;

public class DiscussionManagerImpl implements DiscussionManager {
	private ReviewDAO reviewDao = null;
	private OpinionDAO opinionDao = null;
	
	public void setReviewDao(ReviewDAO reviewDao) {
		this.reviewDao = reviewDao;
	}
	public void setOpinionDao(OpinionDAO opinionDao) {
		this.opinionDao = opinionDao;
	}



	public Discussion getReviewDiscussion(Integer movie) {
		Discussion discussion = new Discussion();
		ReviewExample reviewExample = new ReviewExample();
		//TODO prendere la review con il movie in parametro e le opinions con la review di ritorno
		
		
		return discussion;
	}

}