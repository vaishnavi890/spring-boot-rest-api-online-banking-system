package com.vaishnavi.spring.boot.online.banking.service.impl;

import com.vaishnavi.spring.boot.online.banking.exceptions.AccountNotFoundException;
import com.vaishnavi.spring.boot.online.banking.model.Account;
import com.vaishnavi.spring.boot.online.banking.repository.AccountRepository;
import com.vaishnavi.spring.boot.online.banking.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public boolean store(Account account) {
        logger.info("Inside AccountServiceImpl.store()");
        return accountRepository.store(account);
    }

    @Override
    public List<Account> retrieve() throws Exception {
        logger.info("Inside AccountServiceImpl.retrieve()");
        List<Account> list = accountRepository.retrieve();
        if (list.isEmpty()) {
            throw new AccountNotFoundException("No accounts found.");
        }
        return list;
    }

    @Override
    public Account search(int id) throws Exception {
        logger.info("Inside AccountServiceImpl.search()");
        Account account = accountRepository.search(id);
        if (account == null) {
            throw new AccountNotFoundException("Account with ID " + id + " not found.");
        }
        return account;
    }

    @Override
    public boolean delete(int id) throws Exception {
        logger.info("Inside AccountServiceImpl.delete()");
        try {
            accountRepository.delete(id);
        } catch (Exception e) {
            throw new AccountNotFoundException("Account could not be deleted.");
        }
        return true;
    }
}

