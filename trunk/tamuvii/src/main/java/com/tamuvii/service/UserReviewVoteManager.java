package com.tamuvii.service;

public interface UserReviewVoteManager {
	
	public boolean canVote(String username, Integer review);
	
	public int voteOk(String username, Integer review);
	
	public int voteKo(String username, Integer review);

}