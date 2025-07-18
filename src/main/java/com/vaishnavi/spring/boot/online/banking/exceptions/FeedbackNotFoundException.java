package com.vaishnavi.spring.boot.online.banking.exceptions;

public class FeedbackNotFoundException extends RuntimeException {
    public FeedbackNotFoundException() {
        super("Feedback not found.");
    }

    public FeedbackNotFoundException(String message) {
        super(message);
    }
}

