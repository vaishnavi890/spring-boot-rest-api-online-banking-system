package com.vaishnavi.spring.boot.online.banking.exceptions;

public class AdminUserNotFoundException extends RuntimeException {
    public AdminUserNotFoundException() {
        super("Admin user not found.");
    }

    public AdminUserNotFoundException(String message) {
        super(message);
    }
}

