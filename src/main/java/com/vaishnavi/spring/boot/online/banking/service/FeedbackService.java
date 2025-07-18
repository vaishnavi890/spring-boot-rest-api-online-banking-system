package com.vaishnavi.spring.boot.online.banking.service;

import com.vaishnavi.spring.boot.online.banking.model.Feedback;

import java.util.List;

public interface FeedbackService {
    boolean store(Feedback feedback);
    List<Feedback> retrieve() throws Exception;
    Feedback search(int id) throws Exception;
    boolean delete(int id) throws Exception;
}


