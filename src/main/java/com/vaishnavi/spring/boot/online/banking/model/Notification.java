package com.vaishnavi.spring.boot.online.banking.model;

import lombok.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Notification {
    private int notificationId;
    private int userId;
    private String message;
    private String type;       // e.g., "EMAIL", "SMS", "PUSH"
    private Date sentAt;
    private String status;     // e.g., "SENT", "FAILED", "PENDING"

    public void setNotificationId(int i) {
    }
}

