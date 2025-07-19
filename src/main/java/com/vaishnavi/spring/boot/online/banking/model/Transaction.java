package com.vaishnavi.spring.boot.online.banking.model;

import lombok.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Transaction {
    private int txnId;
    private int fromAccountId;
    private int toAccountId;
    private double amount;
    private String txnType;      // e.g., "TRANSFER", "DEPOSIT", "WITHDRAWAL"
    private Date date;
    private String status;       // e.g., "SUCCESS", "FAILED", "PENDING"

    public void setTransactionId(int i) {
    }
}

