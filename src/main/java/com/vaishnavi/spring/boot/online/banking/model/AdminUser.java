package com.vaishnavi.spring.boot.online.banking.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AdminUser {
    private int adminId;
    private String username;
    private String password;
    private String role;     // e.g., "MANAGER", "AUDITOR"
    private String status;   // "ACTIVE", "INACTIVE"
}


