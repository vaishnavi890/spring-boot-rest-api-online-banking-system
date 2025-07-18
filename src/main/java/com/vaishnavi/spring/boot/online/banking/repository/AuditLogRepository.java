package com.vaishnavi.spring.boot.online.banking.repository;

import com.vaishnavi.spring.boot.online.banking.model.AuditLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AuditLogRepository implements EntityRepository<AuditLog> {

    private static final Logger logger = LoggerFactory.getLogger(AuditLogRepository.class);
    private final List<AuditLog> logList = new ArrayList<>();
    private int index = -1;

    @Override
    public boolean store(AuditLog log) {
        logger.info("Inside AuditLogRepository.store()");
        log.setLogId(++index);
        logList.add(index, log);
        return true;
    }

    @Override
    public boolean delete(int id) throws Exception {
        logger.info("Inside AuditLogRepository.delete()");
        logList.remove(id);
        return true;
    }

    @Override
    public List<AuditLog> retrieve() throws Exception {
        logger.info("Inside AuditLogRepository.retrieve()");
        return logList;
    }

    @Override
    public AuditLog search(int id) throws Exception {
        logger.info("Inside AuditLogRepository.search()");
        return logList.get(id);
    }
}
