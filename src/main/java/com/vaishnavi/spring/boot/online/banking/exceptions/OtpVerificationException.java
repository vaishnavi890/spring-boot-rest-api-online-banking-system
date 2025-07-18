package com.vaishnavi.spring.boot.online.banking.exceptions;

public class OtpVerificationException extends RuntimeException {
    public OtpVerificationException() {
        super("OTP verification failed.");
    }

    public OtpVerificationException(String message) {
        super(message);
    }
}

