package com.vaishnavi.spring.boot.online.banking.controller;

import com.vaishnavi.spring.boot.online.banking.model.User;
import com.vaishnavi.spring.boot.online.banking.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService service;

    @GetMapping("/user")
    public ResponseEntity<List<User>> retrieve() throws Exception {
        logger.info("GET /user called");
        return new ResponseEntity<>(service.retrieve(), HttpStatus.OK);
    }

    @PostMapping("/user")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> store(@RequestBody User user) {
        logger.info("POST /user called");
        return new ResponseEntity<>(service.store(user) ? "User added" : "Not added", HttpStatus.CREATED);
    }

    @DeleteMapping("/user/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> delete(@PathVariable int id) throws Exception {
        logger.info("DELETE /user/" + id);
        return new ResponseEntity<>(service.delete(id) ? "Deleted" : "Not deleted", HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<User> search(@PathVariable int id) {
        logger.info("GET /user/" + id);
        try {
            return new ResponseEntity<>(service.search(id), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}