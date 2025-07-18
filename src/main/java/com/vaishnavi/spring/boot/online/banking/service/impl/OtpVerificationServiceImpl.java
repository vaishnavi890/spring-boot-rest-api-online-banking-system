package com.vaishnavi.spring.boot.online.banking.service.impl;

import com.vaishnavi.spring.boot.online.banking.exceptions.OtpVerificationException;
import com.vaishnavi.spring.boot.online.banking.model.OtpVerification;
import com.vaishnavi.spring.boot.online.banking.repository.OtpVerificationRepository;
import com.vaishnavi.spring.boot.online.banking.service.OtpVerificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OtpVerificationServiceImpl implements OtpVerificationService {

    private static final Logger logger = LoggerFactory.getLogger(OtpVerificationServiceImpl.class);

    @Autowired
    private OtpVerificationRepository repo;

    public boolean store(OtpVerification otp) {
        logger.info("Storing OTP verification");
        return repo.store(otp);
    }

    public List<OtpVerification> retrieve() throws Exception {
        logger.info("Retrieving OTP verifications");
        List<OtpVerification> list = repo.retrieve();
        if (list.isEmpty()) throw new OtpVerificationException("No OTP verifications found");
        return list;
    }

    public OtpVerification search(int id) throws Exception {
        logger.info("Searching OTP verification with ID: {}", id);
        OtpVerification otp = repo.search(id);
        if (otp == null) throw new OtpVerificationException("OTP verification not found");
        return otp;
    }

    public boolean delete(int id) throws Exception {
        logger.info("Deleting OTP verification with ID: {}", id);
        try {
            repo.delete(id);
        } catch (Exception e) {
            throw new OtpVerificationException("OTP verification not found");
        }
        return true;
    }
}


