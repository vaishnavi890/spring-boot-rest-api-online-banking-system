package com.vaishnavi.spring.boot.online.banking.model;

import lombok.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class LoginHistory {
    private int loginId;
    private int userId;
    private Date loginTime;
    private String ipAddress;
    private String deviceInfo;
    private boolean successful;
}

