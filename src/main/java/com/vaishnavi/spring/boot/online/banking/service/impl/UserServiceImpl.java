package com.vaishnavi.spring.boot.online.banking.service.impl;

import com.vaishnavi.spring.boot.online.banking.exceptions.UserNotFoundException;
import com.vaishnavi.spring.boot.online.banking.model.User;
import com.vaishnavi.spring.boot.online.banking.repository.UserRepository;
import com.vaishnavi.spring.boot.online.banking.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository repo;

    public boolean store(User user) {
        logger.info("Storing user");
        return repo.store(user);
    }

    public List<User> retrieve() throws Exception {
        logger.info("Retrieving users");
        List<User> list = repo.retrieve();
        if (list.isEmpty()) throw new UserNotFoundException("No users found");
        return list;
    }

    public User search(int id) throws Exception {
        logger.info("Searching user with ID: {}", id);
        User user = repo.search(id);
        if (user == null) throw new UserNotFoundException("User not found");
        return user;
    }

    public boolean delete(int id) throws Exception {
        logger.info("Deleting user with ID: {}", id);
        try {
            repo.delete(id);
        } catch (Exception e) {
            throw new UserNotFoundException("User not found");
        }
        return true;
    }
}


