package com.tamuvii.service.impl;

import java.util.Calendar;

import com.tamuvii.dao.UserReviewVoteDAO;
import com.tamuvii.model.Review;
import com.tamuvii.model.UserReviewVote;
import com.tamuvii.model.UserReviewVoteKey;
import com.tamuvii.service.ReviewManager;
import com.tamuvii.service.UserReviewVoteManager;
import com.tamuvii.util.TamuviiConstants;

public class UserReviewVoteManagerImpl implements UserReviewVoteManager {
	private UserReviewVoteDAO userReviewVoteDao = null;
	private ReviewManager reviewManager = null;
	
	public void setReviewManager(ReviewManager reviewManager) {
		this.reviewManager = reviewManager;
	}
	public void setUserReviewVoteDao(UserReviewVoteDAO userReviewVoteDao) {
		this.userReviewVoteDao = userReviewVoteDao;
	}


	public boolean canVote(String username, Integer review) {
		UserReviewVoteKey userReviewVoteKey = new UserReviewVoteKey();
		userReviewVoteKey.setUsername(username);
		userReviewVoteKey.setReview(review);
		return userReviewVoteDao.selectByPrimaryKey(userReviewVoteKey) == null;
	}
	
	
	public int voteOk(String username, Integer review) {
		if(canVote(username, review)) {
			if(!reviewManager.isReviewOwner(username, review)) {
				UserReviewVote userReviewVote = new UserReviewVote();
				userReviewVote.setUsername(username);
				userReviewVote.setReview(review);
				userReviewVote.setDatevoted(Calendar.getInstance().getTime());
				userReviewVoteDao.insert(userReviewVote);

				Review r = reviewManager.getReviewById(review);
				int ok = r.getOk();
				r.setOk(ok+1);
				reviewManager.updateReviewById(r);
				
				return ok+1;

			} else {
				return TamuviiConstants.ERROR_REVIEW_OWN_VOTE;
			}
		} else {
			return TamuviiConstants.ERROR_REVIEW_ALREADY_VOTED;
		}
	}
	

	public int voteKo(String username, Integer review) {
		if(canVote(username, review)) {
			if(!reviewManager.isReviewOwner(username, review)) {
				UserReviewVote userReviewVote = new UserReviewVote();
				userReviewVote.setUsername(username);
				userReviewVote.setReview(review);
				userReviewVote.setDatevoted(Calendar.getInstance().getTime());
				userReviewVoteDao.insert(userReviewVote);
				
				Review r = reviewManager.getReviewById(review);
				int ko = r.getKo();
				r.setKo(ko+1);
				reviewManager.updateReviewById(r);
				
				return ko+1;
				
			} else {
				return TamuviiConstants.ERROR_REVIEW_OWN_VOTE;
			}
			
		} else {
			return TamuviiConstants.ERROR_REVIEW_ALREADY_VOTED;
		}
	}
}