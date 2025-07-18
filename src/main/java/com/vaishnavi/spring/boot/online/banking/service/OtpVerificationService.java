package com.vaishnavi.spring.boot.online.banking.service;

import com.vaishnavi.spring.boot.online.banking.model.OtpVerification;

import java.util.List;

public interface OtpVerificationService {
    boolean store(OtpVerification otpVerification);
    List<OtpVerification> retrieve() throws Exception;
    OtpVerification search(int id) throws Exception;
    boolean delete(int id) throws Exception;
}


