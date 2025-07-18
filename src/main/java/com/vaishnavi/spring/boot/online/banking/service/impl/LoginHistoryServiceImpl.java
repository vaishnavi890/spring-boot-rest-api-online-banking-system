package com.vaishnavi.spring.boot.online.banking.service.impl;

import com.vaishnavi.spring.boot.online.banking.exceptions.LoginHistoryNotFoundException;
import com.vaishnavi.spring.boot.online.banking.model.LoginHistory;
import com.vaishnavi.spring.boot.online.banking.repository.LoginHistoryRepository;
import com.vaishnavi.spring.boot.online.banking.service.LoginHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginHistoryServiceImpl implements LoginHistoryService {

    private static final Logger logger = LoggerFactory.getLogger(LoginHistoryServiceImpl.class);

    @Autowired
    private LoginHistoryRepository repo;

    public boolean store(LoginHistory login) {
        logger.info("Storing login history");
        return repo.store(login);
    }

    public List<LoginHistory> retrieve() throws Exception {
        logger.info("Retrieving login history");
        List<LoginHistory> list = repo.retrieve();
        if (list.isEmpty()) throw new LoginHistoryNotFoundException("No login history found");
        return list;
    }

    public LoginHistory search(int id) throws Exception {
        logger.info("Searching login history with ID: {}", id);
        LoginHistory login = repo.search(id);
        if (login == null) throw new LoginHistoryNotFoundException("Login history not found");
        return login;
    }

    public boolean delete(int id) throws Exception {
        logger.info("Deleting login history with ID: {}", id);
        try {
            repo.delete(id);
        } catch (Exception e) {
            throw new LoginHistoryNotFoundException("Login history not found");
        }
        return true;
    }
}


