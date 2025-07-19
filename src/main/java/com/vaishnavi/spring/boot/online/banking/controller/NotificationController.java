package com.vaishnavi.spring.boot.online.banking.controller;

import com.vaishnavi.spring.boot.online.banking.model.Notification;
import com.vaishnavi.spring.boot.online.banking.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotificationController {

    private static final Logger logger = LoggerFactory.getLogger(NotificationController.class);

    @Autowired
    private NotificationService service;

    @GetMapping("/notification")
    public ResponseEntity<List<Notification>> retrieve() throws Exception {
        logger.info("GET /notification called");
        return new ResponseEntity<>(service.retrieve(), HttpStatus.OK);
    }

    @PostMapping("/notification")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> store(@RequestBody Notification notification) {
        logger.info("POST /notification called");
        return new ResponseEntity<>(service.store(notification) ? "Notification added" : "Not added", HttpStatus.CREATED);
    }

    @DeleteMapping("/notification/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> delete(@PathVariable int id) throws Exception {
        logger.info("DELETE /notification/" + id);
        return new ResponseEntity<>(service.delete(id) ? "Deleted" : "Not deleted", HttpStatus.OK);
    }

    @GetMapping("/notification/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<Notification> search(@PathVariable int id) {
        logger.info("GET /notification/" + id);
        try {
            return new ResponseEntity<>(service.search(id), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

