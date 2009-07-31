package com.tamuvii.service;

import com.tamuvii.exception.UserReviewAlreadyVotedException;
import com.tamuvii.exception.UserReviewOwnVoteException;

public interface UserReviewVoteManager {
	
	public boolean canVote(String username, Integer review);
	
	public int voteOk(String username, Integer review);
	
	public int voteKo(String username, Integer review);
	
	public int voteOkDWR(String username, Integer review) throws UserReviewOwnVoteException, UserReviewAlreadyVotedException;
	
	public int voteKoDWR(String username, Integer review) throws UserReviewOwnVoteException, UserReviewAlreadyVotedException;

}