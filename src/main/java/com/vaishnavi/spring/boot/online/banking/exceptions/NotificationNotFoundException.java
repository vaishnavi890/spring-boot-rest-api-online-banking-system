package com.vaishnavi.spring.boot.online.banking.exceptions;

public class NotificationNotFoundException extends RuntimeException {
    public NotificationNotFoundException() {
        super("Notification not found.");
    }

    public NotificationNotFoundException(String message) {
        super(message);
    }
}

