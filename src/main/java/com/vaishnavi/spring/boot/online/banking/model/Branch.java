package com.vaishnavi.spring.boot.online.banking.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Branch {
    private int branchId;
    private String branchName;
    private String address;
    private String city;
    private String state;
    private String ifscCode;
    private String contactNumber;

    public void setBranchId(int i) {
    }
}


