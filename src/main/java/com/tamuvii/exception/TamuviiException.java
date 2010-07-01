package com.tamuvii.exception;

public class TamuviiException extends Exception {
    private static final long serialVersionUID = 4050482305178810162L;

    public TamuviiException(final String message) {
        super(message);
    }
    
    public TamuviiException(String message, Throwable cause) {
        super(message, cause);
    }
}
