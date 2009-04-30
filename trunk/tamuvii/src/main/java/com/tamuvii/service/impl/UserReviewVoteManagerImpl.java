package com.tamuvii.service.impl;

import java.util.Calendar;

import com.tamuvii.dao.ReviewDAO;
import com.tamuvii.dao.UserReviewVoteDAO;
import com.tamuvii.model.Review;
import com.tamuvii.model.UserReviewVote;
import com.tamuvii.model.UserReviewVoteKey;
import com.tamuvii.service.UserReviewVoteManager;

public class UserReviewVoteManagerImpl implements UserReviewVoteManager {
	private UserReviewVoteDAO userReviewVoteDao = null;
	private ReviewDAO reviewDao = null;
	
	public void setReviewDao(ReviewDAO reviewDao) {
		this.reviewDao = reviewDao;
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
			UserReviewVote userReviewVote = new UserReviewVote();
			userReviewVote.setUsername(username);
			userReviewVote.setReview(review);
			userReviewVote.setDatevoted(Calendar.getInstance().getTime());
			userReviewVoteDao.insert(userReviewVote);

			Review r = reviewDao.selectByPrimaryKey(review);
			int ok = r.getOk();
			r.setOk(ok+1);
			reviewDao.updateByPrimaryKey(r);
			
			return ok+1;
		} else {
			return -1;
		}
	}
	

	public int voteKo(String username, Integer review) {
		if(canVote(username, review)) {
			UserReviewVote userReviewVote = new UserReviewVote();
			userReviewVote.setUsername(username);
			userReviewVote.setReview(review);
			userReviewVote.setDatevoted(Calendar.getInstance().getTime());
			userReviewVoteDao.insert(userReviewVote);
			
			Review r = reviewDao.selectByPrimaryKey(review);
			int ko = r.getKo();
			r.setKo(ko+1);
			reviewDao.updateByPrimaryKey(r);
			
			return ko+1;
		} else {
			return -1;
		}
	}
}