package com.vaishnavi.spring.boot.online.banking.service;

import com.vaishnavi.spring.boot.online.banking.model.User;

import java.util.List;

public interface UserService {
    boolean store(User user);
    List<User> retrieve() throws Exception;
    User search(int id) throws Exception;
    boolean delete(int id) throws Exception;
}


