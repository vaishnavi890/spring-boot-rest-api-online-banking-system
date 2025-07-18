package com.vaishnavi.spring.boot.online.banking.service;

import com.vaishnavi.spring.boot.online.banking.model.Transaction;

import java.util.List;

public interface TransactionService {
    boolean store(Transaction transaction);
    List<Transaction> retrieve() throws Exception;
    Transaction search(int id) throws Exception;
    boolean delete(int id) throws Exception;
}

