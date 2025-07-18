package com.vaishnavi.spring.boot.online.banking.repository;

import com.vaishnavi.spring.boot.online.banking.model.OtpVerification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OtpVerificationRepository implements EntityRepository<OtpVerification> {

    private static final Logger logger = LoggerFactory.getLogger(OtpVerificationRepository.class);
    private final List<OtpVerification> otpList = new ArrayList<>();
    private int index = -1;

    @Override
    public boolean store(OtpVerification otp) {
        logger.info("Inside OtpVerificationRepository.store()");
        otp.setOtpId(++index);
        otpList.add(index, otp);
        return true;
    }

    @Override
    public boolean delete(int id) throws Exception {
        logger.info("Inside OtpVerificationRepository.delete()");
        otpList.remove(id);
        return true;
    }

    @Override
    public List<OtpVerification> retrieve() throws Exception {
        logger.info("Inside OtpVerificationRepository.retrieve()");
        return otpList;
    }

    @Override
    public OtpVerification search(int id) throws Exception {
        logger.info("Inside OtpVerificationRepository.search()");
        return otpList.get(id);
    }
}


