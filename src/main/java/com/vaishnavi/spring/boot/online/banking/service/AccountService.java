package com.vaishnavi.spring.boot.online.banking.service;

import com.vaishnavi.spring.boot.online.banking.model.Account;
import java.util.List;

public interface AccountService {
        boolean store(Account account);
        List<Account> retrieve() throws Exception;
        Account search(int id) throws Exception;
        boolean delete(int id) throws Exception;
    }



