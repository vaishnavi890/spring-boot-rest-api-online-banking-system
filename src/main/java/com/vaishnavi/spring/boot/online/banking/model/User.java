package com.vaishnavi.spring.boot.online.banking.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User {
    private int userId;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String role;        // e.g., "CUSTOMER", "ADMIN"
    private String kycStatus;   // e.g., "PENDING", "VERIFIED"
}

