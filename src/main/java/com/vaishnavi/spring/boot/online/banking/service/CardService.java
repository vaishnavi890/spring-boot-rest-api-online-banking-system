package com.vaishnavi.spring.boot.online.banking.service;

import com.vaishnavi.spring.boot.online.banking.model.Card;

import java.util.List;

public interface CardService {
    boolean store(Card card);
    List<Card> retrieve() throws Exception;
    Card search(int id) throws Exception;
    boolean delete(int id) throws Exception;
}


