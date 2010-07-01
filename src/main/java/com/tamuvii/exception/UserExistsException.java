package com.tamuvii.exception;

public class UserExistsException extends Exception {
    private static final long serialVersionUID = 4050482305178810162L;

    public UserExistsException(final String message) {
        super(message);
    }
}
