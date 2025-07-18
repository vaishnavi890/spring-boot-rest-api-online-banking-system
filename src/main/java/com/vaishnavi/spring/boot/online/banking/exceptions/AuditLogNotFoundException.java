package com.vaishnavi.spring.boot.online.banking.exceptions;

public class AuditLogNotFoundException extends RuntimeException {
    public AuditLogNotFoundException() {
        super("Audit log not found.");
    }

    public AuditLogNotFoundException(String message) {
        super(message);
    }
}

