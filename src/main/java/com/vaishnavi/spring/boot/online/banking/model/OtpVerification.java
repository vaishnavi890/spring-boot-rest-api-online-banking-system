package com.vaishnavi.spring.boot.online.banking.model;

import lombok.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class OtpVerification {
    private int otpId;
    private int userId;
    private String otpCode;
    private Date generatedAt;
    private Date expiresAt;
    private boolean verified;
}


