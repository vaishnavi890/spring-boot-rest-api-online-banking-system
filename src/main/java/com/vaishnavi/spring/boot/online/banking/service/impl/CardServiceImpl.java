package com.vaishnavi.spring.boot.online.banking.service.impl;

import com.vaishnavi.spring.boot.online.banking.exceptions.CardNotFoundException;
import com.vaishnavi.spring.boot.online.banking.model.Card;
import com.vaishnavi.spring.boot.online.banking.repository.CardRepository;
import com.vaishnavi.spring.boot.online.banking.service.CardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    private static final Logger logger = LoggerFactory.getLogger(CardServiceImpl.class);

    @Autowired
    private CardRepository repo;

    public boolean store(Card card) {
        logger.info("Storing card");
        return repo.store(card);
    }

    public List<Card> retrieve() throws Exception {
        logger.info("Retrieving cards");
        List<Card> list = repo.retrieve();
        if (list.isEmpty()) throw new CardNotFoundException("No cards found");
        return list;
    }

    public Card search(int id) throws Exception {
        logger.info("Searching card with ID: {}", id);
        Card card = repo.search(id);
        if (card == null) throw new CardNotFoundException("Card not found");
        return card;
    }

    public boolean delete(int id) throws Exception {
        logger.info("Deleting card with ID: {}", id);
        try {
            repo.delete(id);
        } catch (Exception e) {
            throw new CardNotFoundException("Card not found");
        }
        return true;
    }
}


