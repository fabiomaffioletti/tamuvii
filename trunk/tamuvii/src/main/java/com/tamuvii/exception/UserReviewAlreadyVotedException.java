package com.tamuvii.exception;

public class UserReviewAlreadyVotedException extends Exception {
	private static final long serialVersionUID = 1L;

	public UserReviewAlreadyVotedException() {
		super();
	}

	public UserReviewAlreadyVotedException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserReviewAlreadyVotedException(String message) {
		super(message);
	}

	public UserReviewAlreadyVotedException(Throwable cause) {
		super(cause);
	}
	
}