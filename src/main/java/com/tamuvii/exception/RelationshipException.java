package com.tamuvii.exception;

public class RelationshipException extends Exception {
    private static final long serialVersionUID = 4050482305178810162L;

    public RelationshipException(final String message) {
        super(message);
    }
    
    public RelationshipException(String message, Throwable cause) {
        super(message, cause);
    }
}
