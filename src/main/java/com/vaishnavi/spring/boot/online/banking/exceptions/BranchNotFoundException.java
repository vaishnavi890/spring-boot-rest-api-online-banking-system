package com.vaishnavi.spring.boot.online.banking.exceptions;

public class BranchNotFoundException extends RuntimeException {
    public BranchNotFoundException() {
        super("Branch not found.");
    }

    public BranchNotFoundException(String message) {
        super(message);
    }
}