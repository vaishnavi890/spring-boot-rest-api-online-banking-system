package com.vaishnavi.spring.boot.online.banking.controller;

import com.vaishnavi.spring.boot.online.banking.model.LoginHistory;
import com.vaishnavi.spring.boot.online.banking.service.LoginHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginHistoryController {

    private static final Logger logger = LoggerFactory.getLogger(LoginHistoryController.class);

    @Autowired
    private LoginHistoryService service;

    @GetMapping("/loginhistory")
    public ResponseEntity<List<LoginHistory>> retrieve() throws Exception {
        logger.info("GET /loginhistory called");
        return new ResponseEntity<>(service.retrieve(), HttpStatus.OK);
    }

    @PostMapping("/loginhistory")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> store(@RequestBody LoginHistory loginHistory) {
        logger.info("POST /loginhistory called");
        return new ResponseEntity<>(service.store(loginHistory) ? "History added" : "Not added", HttpStatus.CREATED);
    }

    @DeleteMapping("/loginhistory/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> delete(@PathVariable int id) throws Exception {
        logger.info("DELETE /loginhistory/" + id);
        return new ResponseEntity<>(service.delete(id) ? "Deleted" : "Not deleted", HttpStatus.OK);
    }

    @GetMapping("/loginhistory/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<LoginHistory> search(@PathVariable int id) {
        logger.info("GET /loginhistory/" + id);
        try {
            return new ResponseEntity<>(service.search(id), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

