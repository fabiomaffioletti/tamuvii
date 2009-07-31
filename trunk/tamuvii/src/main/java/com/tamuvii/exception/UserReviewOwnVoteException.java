package com.tamuvii.exception;

public class UserReviewOwnVoteException extends Exception {
	private static final long serialVersionUID = 1L;

	public UserReviewOwnVoteException() {
		super();
	}

	public UserReviewOwnVoteException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserReviewOwnVoteException(String message) {
		super(message);
	}

	public UserReviewOwnVoteException(Throwable cause) {
		super(cause);
	}
	
}