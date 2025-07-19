package com.vaishnavi.spring.boot.online.banking.controller;

import com.vaishnavi.spring.boot.online.banking.model.AuditLog;
import com.vaishnavi.spring.boot.online.banking.service.AuditLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuditLogController {
    private static final Logger logger = LoggerFactory.getLogger(AuditLogController.class);

    @Autowired
    private AuditLogService service;

    @GetMapping("/auditlog")
    public ResponseEntity<List<AuditLog>> retrieve() throws Exception {
        logger.info("GET /auditlog called");
        return new ResponseEntity<>(service.retrieve(), HttpStatus.OK);
    }

    @PostMapping("/auditlog")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> store(@RequestBody AuditLog auditLog) {
        logger.info("POST /auditlog called");
        return new ResponseEntity<>(service.store(auditLog) ? "AuditLog added" : "AuditLog not added", HttpStatus.CREATED);
    }

    @DeleteMapping("/auditlog/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> delete(@PathVariable int id) {
        logger.info("DELETE /auditlog/" + id);
        try {
            return new ResponseEntity<>(service.delete(id) ? "Deleted" : "Not deleted", HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


