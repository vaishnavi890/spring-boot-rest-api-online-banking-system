package com.vaishnavi.spring.boot.online.banking.repository;

import com.vaishnavi.spring.boot.online.banking.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionRepository implements EntityRepository<Transaction> {

    private static final Logger logger = LoggerFactory.getLogger(TransactionRepository.class);
    private final List<Transaction> txnList = new ArrayList<>();
    private int index = -1;

    @Override
    public boolean store(Transaction txn) {
        logger.info("Inside TransactionRepository.store()");
        txn.setTransactionId(++index);
        txnList.add(index, txn);
        return true;
    }

    @Override
    public boolean delete(int id) throws Exception {
        logger.info("Inside TransactionRepository.delete()");
        txnList.remove(id);
        return true;
    }

    @Override
    public List<Transaction> retrieve() throws Exception {
        logger.info("Inside TransactionRepository.retrieve()");
        return txnList;
    }

    @Override
    public Transaction search(int id) throws Exception {
        logger.info("Inside TransactionRepository.search()");
        return txnList.get(id);
    }
}


