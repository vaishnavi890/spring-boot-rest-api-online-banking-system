package com.vaishnavi.spring.boot.online.banking.controller;

import com.vaishnavi.spring.boot.online.banking.model.Feedback;
import com.vaishnavi.spring.boot.online.banking.service.FeedbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FeedbackController {

    private static final Logger logger = LoggerFactory.getLogger(FeedbackController.class);

    @Autowired
    private FeedbackService service;

    @GetMapping("/feedback")
    public ResponseEntity<List<Feedback>> retrieve() throws Exception {
        logger.info("GET /feedback called");
        return new ResponseEntity<>(service.retrieve(), HttpStatus.OK);
    }

    @PostMapping("/feedback")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> store(@RequestBody Feedback feedback) {
        logger.info("POST /feedback called");
        return new ResponseEntity<>(service.store(feedback) ? "Feedback added" : "Feedback not added", HttpStatus.CREATED);
    }

    @DeleteMapping("/feedback/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> delete(@PathVariable int id) throws Exception {
        logger.info("DELETE /feedback/" + id);
        return new ResponseEntity<>(service.delete(id) ? "Deleted" : "Not deleted", HttpStatus.OK);
    }

    @GetMapping("/feedback/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<Feedback> search(@PathVariable int id) {
        logger.info("GET /feedback/" + id);
        try {
            return new ResponseEntity<>(service.search(id), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


