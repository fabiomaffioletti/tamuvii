package com.tamuvii.exception;

public class IllegalOperationException extends Exception {
    private static final long serialVersionUID = 4050482305178810162L;

    public IllegalOperationException(final String message) {
        super(message);
    }
    
    public IllegalOperationException(final String message, Throwable cause) {
        super(message, cause);
    }
}
