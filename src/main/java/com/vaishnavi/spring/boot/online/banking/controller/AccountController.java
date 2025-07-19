package com.vaishnavi.spring.boot.online.banking.controller;

import com.vaishnavi.spring.boot.online.banking.model.Account;
import com.vaishnavi.spring.boot.online.banking.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService service;

    @GetMapping("/account")
    public ResponseEntity<List<Account>> retrieve() throws Exception {
        logger.info("GET /account called");
        return new ResponseEntity<>(service.retrieve(), HttpStatus.OK);
    }

    @PostMapping("/account://localhost:8080")
    public ResponseEntity<String> store(@RequestBody Account account) {
        logger.info("POST /account called");
        return new ResponseEntity<>(service.store(account) ? "Account added" : "Account not added", HttpStatus.CREATED);
    }

    @DeleteMapping("/account/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> delete(@PathVariable int id) throws Exception {
        logger.info("DELETE /account/" + id);
        return new ResponseEntity<>(service.delete(id) ? "Account deleted" : "Account not deleted", HttpStatus.OK);
    }

    @GetMapping("/accounts/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<Account> search(@PathVariable int id) {
        logger.info("GET /account/" + id);
        try {
            return new ResponseEntity<>(service.search(id), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

