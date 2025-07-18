package com.vaishnavi.spring.boot.online.banking.service.impl;

import com.vaishnavi.spring.boot.online.banking.exceptions.TransactionNotFoundException;
import com.vaishnavi.spring.boot.online.banking.model.Transaction;
import com.vaishnavi.spring.boot.online.banking.repository.TransactionRepository;
import com.vaishnavi.spring.boot.online.banking.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

    @Autowired
    private TransactionRepository repo;

    public boolean store(Transaction txn) {
        logger.info("Storing transaction");
        return repo.store(txn);
    }

    public List<Transaction> retrieve() throws Exception {
        logger.info("Retrieving transactions");
        List<Transaction> list = repo.retrieve();
        if (list.isEmpty()) throw new TransactionNotFoundException("No transactions found");
        return list;
    }

    public Transaction search(int id) throws Exception {
        logger.info("Searching transaction with ID: {}", id);
        Transaction txn = repo.search(id);
        if (txn == null) throw new TransactionNotFoundException("Transaction not found");
        return txn;
    }

    public boolean delete(int id) throws Exception {
        logger.info("Deleting transaction with ID: {}", id);
        try {
            repo.delete(id);
        } catch (Exception e) {
            throw new TransactionNotFoundException("Transaction not found");
        }
        return true;
    }
}


