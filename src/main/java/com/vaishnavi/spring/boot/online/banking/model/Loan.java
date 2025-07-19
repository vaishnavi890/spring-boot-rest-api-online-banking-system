package com.vaishnavi.spring.boot.online.banking.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Loan {
    private int loanId;
    private int userId;
    private double amount;
    private String type;         // e.g., "HOME", "PERSONAL", "CAR"
    private double interestRate;
    private int duration;        // in months
    private String status;       // e.g., "APPROVED", "PENDING", "REJECTED"

    public void setLoanId(int i) {
    }
}

