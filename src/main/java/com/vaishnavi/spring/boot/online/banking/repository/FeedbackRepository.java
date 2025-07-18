package com.vaishnavi.spring.boot.online.banking.repository;

import com.vaishnavi.spring.boot.online.banking.model.Feedback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FeedbackRepository implements EntityRepository<Feedback> {

    private static final Logger logger = LoggerFactory.getLogger(FeedbackRepository.class);
    private final List<Feedback> feedbackList = new ArrayList<>();
    private int index = -1;

    @Override
    public boolean store(Feedback feedback) {
        logger.info("Inside FeedbackRepository.store()");
        feedback.setFeedbackId(++index);
        feedbackList.add(index, feedback);
        return true;
    }

    @Override
    public boolean delete(int id) throws Exception {
        logger.info("Inside FeedbackRepository.delete()");
        feedbackList.remove(id);
        return true;
    }

    @Override
    public List<Feedback> retrieve() throws Exception {
        logger.info("Inside FeedbackRepository.retrieve()");
        return feedbackList;
    }

    @Override
    public Feedback search(int id) throws Exception {
        logger.info("Inside FeedbackRepository.search()");
        return feedbackList.get(id);
    }
}

