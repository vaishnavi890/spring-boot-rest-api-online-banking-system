package com.vaishnavi.spring.boot.online.banking.exceptions;

public class CardNotFoundException extends RuntimeException {
    public CardNotFoundException() {
        super("Card not found.");
    }

    public CardNotFoundException(String message) {
        super(message);
    }
}

