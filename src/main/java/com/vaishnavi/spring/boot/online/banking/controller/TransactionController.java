package com.vaishnavi.spring.boot.online.banking.controller;

import com.vaishnavi.spring.boot.online.banking.model.Transaction;
import com.vaishnavi.spring.boot.online.banking.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionService service;

    @GetMapping("/transaction")
    public ResponseEntity<List<Transaction>> retrieve() throws Exception {
        logger.info("GET /transaction called");
        return new ResponseEntity<>(service.retrieve(), HttpStatus.OK);
    }

    @PostMapping("/transaction")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> store(@RequestBody Transaction transaction) {
        logger.info("POST /transaction called");
        return new ResponseEntity<>(service.store(transaction) ? "Transaction added" : "Not added", HttpStatus.CREATED);
    }

    @DeleteMapping("/transaction/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> delete(@PathVariable int id) throws Exception {
        logger.info("DELETE /transaction/" + id);
        return new ResponseEntity<>(service.delete(id) ? "Deleted" : "Not deleted", HttpStatus.OK);
    }

    @GetMapping("/transaction/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<Transaction> search(@PathVariable int id) {
        logger.info("GET /transaction/" + id);
        try {
            return new ResponseEntity<>(service.search(id), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


