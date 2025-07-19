package com.vaishnavi.spring.boot.online.banking.controller;

import com.vaishnavi.spring.boot.online.banking.model.Loan;
import com.vaishnavi.spring.boot.online.banking.service.LoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoanController {

    private static final Logger logger = LoggerFactory.getLogger(LoanController.class);

    @Autowired
    private LoanService service;

    @GetMapping("/loan")
    public ResponseEntity<List<Loan>> retrieve() throws Exception {
        logger.info("GET /loan called");
        return new ResponseEntity<>(service.retrieve(), HttpStatus.OK);
    }

    @PostMapping("/loan")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> store(@RequestBody Loan loan) {
        logger.info("POST /loan called");
        return new ResponseEntity<>(service.store(loan) ? "Loan added" : "Loan not added", HttpStatus.CREATED);
    }

    @DeleteMapping("/loan/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> delete(@PathVariable int id) throws Exception {
        logger.info("DELETE /loan/" + id);
        return new ResponseEntity<>(service.delete(id) ? "Deleted" : "Not deleted", HttpStatus.OK);
    }

    @GetMapping("/loan/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<Loan> search(@PathVariable int id) {
        logger.info("GET /loan/" + id);
        try {
            return new ResponseEntity<>(service.search(id), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
