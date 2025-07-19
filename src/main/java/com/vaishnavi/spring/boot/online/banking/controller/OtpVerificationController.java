package com.vaishnavi.spring.boot.online.banking.controller;

import com.vaishnavi.spring.boot.online.banking.model.OtpVerification;
import com.vaishnavi.spring.boot.online.banking.service.OtpVerificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OtpVerificationController {

    private static final Logger logger = LoggerFactory.getLogger(OtpVerificationController.class);

    @Autowired
    private OtpVerificationService service;

    @GetMapping("/otpverification")
    public ResponseEntity<List<OtpVerification>> retrieve() throws Exception {
        logger.info("GET /otpverification called");
        return new ResponseEntity<>(service.retrieve(), HttpStatus.OK);
    }

    @PostMapping("/otpverification")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> store(@RequestBody OtpVerification otp) {
        logger.info("POST /otpverification called");
        return new ResponseEntity<>(service.store(otp) ? "OTP added" : "Not added", HttpStatus.CREATED);
    }

    @DeleteMapping("/otpverification/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> delete(@PathVariable int id) throws Exception {
        logger.info("DELETE /otpverification/" + id);
        return new ResponseEntity<>(service.delete(id) ? "Deleted" : "Not deleted", HttpStatus.OK);
    }

    @GetMapping("/otpverification/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<OtpVerification> search(@PathVariable int id) {
        logger.info("GET /otpverification/" + id);
        try {
            return new ResponseEntity<>(service.search(id), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

