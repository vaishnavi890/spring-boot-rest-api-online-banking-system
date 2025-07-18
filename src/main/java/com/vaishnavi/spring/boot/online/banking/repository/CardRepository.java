package com.vaishnavi.spring.boot.online.banking.repository;

import com.vaishnavi.spring.boot.online.banking.model.Card;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CardRepository implements EntityRepository<Card> {

    private static final Logger logger = LoggerFactory.getLogger(CardRepository.class);
    private final List<Card> cardList = new ArrayList<>();
    private int index = -1;

    @Override
    public boolean store(Card card) {
        logger.info("Inside CardRepository.store()");
        card.setCardId(++index);
        cardList.add(index, card);
        return true;
    }

    @Override
    public boolean delete(int id) throws Exception {
        logger.info("Inside CardRepository.delete()");
        cardList.remove(id);
        return true;
    }

    @Override
    public List<Card> retrieve() throws Exception {
        logger.info("Inside CardRepository.retrieve()");
        return cardList;
    }

    @Override
    public Card search(int id) throws Exception {
        logger.info("Inside CardRepository.search()");
        return cardList.get(id);
    }
}
