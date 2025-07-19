package com.vaishnavi.spring.boot.online.banking.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Account {
    private int accountId;
    private int userId;
    private String accountType;  // e.g., "SAVINGS", "CURRENT"
    private double balance;
    private String status;       // e.g., "ACTIVE", "INACTIVE"

    public void setAccountId(int i) {
    }
}


