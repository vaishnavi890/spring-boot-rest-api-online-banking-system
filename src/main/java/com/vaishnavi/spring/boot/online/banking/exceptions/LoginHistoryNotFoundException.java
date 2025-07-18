package com.vaishnavi.spring.boot.online.banking.exceptions;

public class LoginHistoryNotFoundException extends RuntimeException {
    public LoginHistoryNotFoundException() {
        super("Login history not found.");
    }

    public LoginHistoryNotFoundException(String message) {
        super(message);
    }
}

