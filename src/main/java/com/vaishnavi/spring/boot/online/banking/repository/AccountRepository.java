package com.vaishnavi.spring.boot.online.banking.repository;

import com.vaishnavi.spring.boot.online.banking.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountRepository implements EntityRepository<Account> {
    private static final Logger logger = LoggerFactory.getLogger(AccountRepository.class);
    private final List<Account> accountList = new ArrayList<>();
    private int index = -1;

    @Override
    public boolean store(Account account) {
        logger.info("Inside AccountRepository.store()");
        account.setAccountId(++index);
        accountList.add(index, account);
        return true;
    }

    @Override
    public boolean delete(int id) throws Exception {
        logger.info("Inside AccountRepository.delete()");
        accountList.remove(id);
        return true;
    }

    @Override
    public List<Account> retrieve() throws Exception {
        logger.info("Inside AccountRepository.retrieve()");
        return accountList;
    }

    @Override
    public Account search(int id) throws Exception {
        logger.info("Inside AccountRepository.search()");
        return accountList.get(id);
    }
}


