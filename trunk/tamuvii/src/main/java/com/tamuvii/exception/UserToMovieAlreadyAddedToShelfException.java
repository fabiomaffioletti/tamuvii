package com.tamuvii.exception;

public class UserToMovieAlreadyAddedToShelfException extends Exception {
	private static final long serialVersionUID = 1L;

	public UserToMovieAlreadyAddedToShelfException() {
		super();
	}

	public UserToMovieAlreadyAddedToShelfException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserToMovieAlreadyAddedToShelfException(String message) {
		super(message);
	}

	public UserToMovieAlreadyAddedToShelfException(Throwable cause) {
		super(cause);
	}
	
}