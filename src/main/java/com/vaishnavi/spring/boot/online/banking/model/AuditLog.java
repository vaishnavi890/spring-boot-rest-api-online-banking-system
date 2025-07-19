package com.vaishnavi.spring.boot.online.banking.model;

import lombok.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AuditLog {
    private int auditId;
    private int userId;
    private String action;        // e.g., "ACCOUNT_CREATED", "PASSWORD_CHANGED"
    private Date timestamp;
    private String description;

    public void setLogId(int i) {
    }
}


