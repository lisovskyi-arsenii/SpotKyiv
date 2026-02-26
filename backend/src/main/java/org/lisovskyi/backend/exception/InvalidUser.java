package org.lisovskyi.backend.exception;

public class InvalidUser extends RuntimeException {
    public InvalidUser(String message) {
        super(message);
    }

    public InvalidUser(String message, Throwable cause) {
        super(message, cause);
    }
}
