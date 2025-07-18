package com.vaishnavi.spring.boot.online.banking.service;

import com.vaishnavi.spring.boot.online.banking.model.LoginHistory;

import java.util.List;

public interface LoginHistoryService {
    boolean store(LoginHistory loginHistory);
    List<LoginHistory> retrieve() throws Exception;
    LoginHistory search(int id) throws Exception;
    boolean delete(int id) throws Exception;
}



