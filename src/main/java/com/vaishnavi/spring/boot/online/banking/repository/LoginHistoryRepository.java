package com.vaishnavi.spring.boot.online.banking.repository;

import com.vaishnavi.spring.boot.online.banking.model.LoginHistory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LoginHistoryRepository implements EntityRepository<LoginHistory> {

    private static final Logger logger = LoggerFactory.getLogger(LoginHistoryRepository.class);
    private final List<LoginHistory> historyList = new ArrayList<>();
    private int index = -1;

    @Override
    public boolean store(LoginHistory history) {
        logger.info("Inside LoginHistoryRepository.store()");
        history.setLoginId(++index);
        historyList.add(index, history);
        return true;
    }

    @Override
    public boolean delete(int id) throws Exception {
        logger.info("Inside LoginHistoryRepository.delete()");
        historyList.remove(id);
        return true;
    }

    @Override
    public List<LoginHistory> retrieve() throws Exception {
        logger.info("Inside LoginHistoryRepository.retrieve()");
        return historyList;
    }

    @Override
    public LoginHistory search(int id) throws Exception {
        logger.info("Inside LoginHistoryRepository.search()");
        return historyList.get(id);
    }
}


