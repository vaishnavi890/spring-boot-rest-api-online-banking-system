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

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAccounts() {
        logger.info("GET /account called");
        return new ResponseEntity<>(service.retrieveAccount(), HttpStatus.OK);
    }

    @PostMapping("/accounts")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> addAccount(@RequestBody Account account) {
        logger.info("POST /accounts called");
        return new ResponseEntity<>(service.storeAccount(account) ? "Account added" : "Account not added", HttpStatus.CREATED);
    }

    @DeleteMapping("/accounts/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> deleteAccount(@PathVariable int id) {
        logger.info("DELETE /accounts/" + id);
        return new ResponseEntity<>(service.deleteAccount(id) ? "Account deleted" : "Account not deleted", HttpStatus.OK);
    }

    @GetMapping("/accounts/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<Account> getAccountById(@PathVariable int id) {
        logger.info("GET /accounts/" + id);
        return new ResponseEntity<>(service.searchAccount(id), HttpStatus.OK);
    }
}

