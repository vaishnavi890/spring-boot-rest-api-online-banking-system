package com.vaishnavi.spring.boot.online.banking.controller;

import com.vaishnavi.spring.boot.online.banking.model.Branch;
import com.vaishnavi.spring.boot.online.banking.service.BranchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BranchController {

    private static final Logger logger = LoggerFactory.getLogger(BranchController.class);

    @Autowired
    private BranchService service;

    @GetMapping("/branch")
    public ResponseEntity<List<Branch>> retrieve() throws Exception {
        logger.info("GET /branch called");
        return new ResponseEntity<>(service.retrieve(), HttpStatus.OK);
    }

    @PostMapping("/branch")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> store(@RequestBody Branch branch) {
        logger.info("POST /branch called");
        return new ResponseEntity<>(service.store(branch) ? "Branch added" : "Branch not added", HttpStatus.CREATED);
    }

    @DeleteMapping("/branch/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> delete(@PathVariable int id) throws Exception {
        logger.info("DELETE /branch/" + id);
        return new ResponseEntity<>(service.delete(id) ? "Branch deleted" : "Branch not deleted", HttpStatus.OK);
    }

    @GetMapping("/branch/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<Branch> search(@PathVariable int id) {
        logger.info("GET /branch/" + id);
        try {
            return new ResponseEntity<>(service.search(id), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

