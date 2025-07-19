package com.vaishnavi.spring.boot.online.banking.model;

import lombok.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Card {
    private int cardId;
    private int accountId;
    private String cardType;     // e.g., "DEBIT", "CREDIT"
    private Date issueDate;
    private Date expiryDate;
    private String status;       // e.g., "ACTIVE", "BLOCKED"

    public void setCardId(int i) {
    }
}

