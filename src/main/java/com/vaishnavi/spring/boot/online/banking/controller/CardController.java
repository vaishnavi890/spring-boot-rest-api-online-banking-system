package com.vaishnavi.spring.boot.online.banking.controller;

import com.vaishnavi.spring.boot.online.banking.model.Card;
import com.vaishnavi.spring.boot.online.banking.service.CardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardController {

    private static final Logger logger = LoggerFactory.getLogger(CardController.class);

    @Autowired
    private CardService service;

    @GetMapping("/card")
    public ResponseEntity<List<Card>> retrieve() throws Exception {
        logger.info("GET /card called");
        return new ResponseEntity<>(service.retrieve(), HttpStatus.OK);
    }

    @PostMapping("/card")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> store(@RequestBody Card card) {
        logger.info("POST /card called");
        return new ResponseEntity<>(service.store(card) ? "Card added" : "Card not added", HttpStatus.CREATED);
    }

    @DeleteMapping("/card/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> delete(@PathVariable int id) throws Exception {
        logger.info("DELETE /card/" + id);
        return new ResponseEntity<>(service.delete(id) ? "Card deleted" : "Card not deleted", HttpStatus.OK);
    }

    @GetMapping("/card/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<Card> search(@PathVariable int id) {
        logger.info("GET /card/" + id);
        try {
            return new ResponseEntity<>(service.search(id), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

