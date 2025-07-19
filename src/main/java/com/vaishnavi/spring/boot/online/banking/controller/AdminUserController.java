package com.vaishnavi.spring.boot.online.banking.controller;

import com.vaishnavi.spring.boot.online.banking.model.AdminUser;
import com.vaishnavi.spring.boot.online.banking.service.AdminUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminUserController {

    private static final Logger logger = LoggerFactory.getLogger(AdminUserController.class);

    @Autowired
    private AdminUserService service;

    @GetMapping("/adminuser")
    public ResponseEntity<List<AdminUser>> retrieve() throws Exception {
        logger.info("GET /adminuser called");
        return new ResponseEntity<>(service.retrieve(), HttpStatus.OK);
    }

    @PostMapping("/adminuser")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> store(@RequestBody AdminUser user) {
        logger.info("POST /adminuser called");
        return new ResponseEntity<>(service.store(user) ? "AdminUser added" : "AdminUser not added", HttpStatus.CREATED);
    }

    @DeleteMapping("/adminuser/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> delete(@PathVariable int id) throws Exception {
        logger.info("DELETE /adminuser/" + id);
        return new ResponseEntity<>(service.delete(id) ? "Deleted" : "Not deleted", HttpStatus.OK);
    }

    @GetMapping("/adminuser/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<AdminUser> search(@PathVariable int id) {
        logger.info("GET /adminuser/" + id);
        try {
            return new ResponseEntity<>(service.search(id), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

