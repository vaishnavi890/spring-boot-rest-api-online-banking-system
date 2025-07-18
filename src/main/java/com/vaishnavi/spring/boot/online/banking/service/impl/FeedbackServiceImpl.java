package com.vaishnavi.spring.boot.online.banking.service.impl;

import com.vaishnavi.spring.boot.online.banking.exceptions.FeedbackNotFoundException;
import com.vaishnavi.spring.boot.online.banking.model.Feedback;
import com.vaishnavi.spring.boot.online.banking.repository.FeedbackRepository;
import com.vaishnavi.spring.boot.online.banking.service.FeedbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private static final Logger logger = LoggerFactory.getLogger(FeedbackServiceImpl.class);

    @Autowired
    private FeedbackRepository repo;

    public boolean store(Feedback feedback) {
        logger.info("Storing feedback");
        return repo.store(feedback);
    }

    public List<Feedback> retrieve() throws Exception {
        logger.info("Retrieving feedback");
        List<Feedback> list = repo.retrieve();
        if (list.isEmpty()) throw new FeedbackNotFoundException("No feedback found");
        return list;
    }

    public Feedback search(int id) throws Exception {
        logger.info("Searching feedback with ID: {}", id);
        Feedback feedback = repo.search(id);
        if (feedback == null) throw new FeedbackNotFoundException("Feedback not found");
        return feedback;
    }

    public boolean delete(int id) throws Exception {
        logger.info("Deleting feedback with ID: {}", id);
        try {
            repo.delete(id);
        } catch (Exception e) {
            throw new FeedbackNotFoundException("Feedback not found");
        }
        return true;
    }
}

