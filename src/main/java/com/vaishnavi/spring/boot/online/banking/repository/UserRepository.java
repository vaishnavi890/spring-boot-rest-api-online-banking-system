package com.vaishnavi.spring.boot.online.banking.repository;

import com.vaishnavi.spring.boot.online.banking.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements EntityRepository<User> {

    private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);
    private final List<User> userList = new ArrayList<>();
    private int index = -1;

    @Override
    public boolean store(User user) {
        logger.info("Inside UserRepository.store()");
        user.setUserId(++index);
        userList.add(index, user);
        return true;
    }

    @Override
    public boolean delete(int id) throws Exception {
        logger.info("Inside UserRepository.delete()");
        userList.remove(id);
        return true;
    }

    @Override
    public List<User> retrieve() throws Exception {
        logger.info("Inside UserRepository.retrieve()");
        return userList;
    }

    @Override
    public User search(int id) throws Exception {
        logger.info("Inside UserRepository.search()");
        return userList.get(id);
    }
}


