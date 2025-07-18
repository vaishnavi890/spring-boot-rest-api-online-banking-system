package com.vaishnavi.spring.boot.online.banking.service.impl;

import com.vaishnavi.spring.boot.online.banking.exceptions.AuditLogNotFoundException;
import com.vaishnavi.spring.boot.online.banking.model.AuditLog;
import com.vaishnavi.spring.boot.online.banking.repository.AuditLogRepository;
import com.vaishnavi.spring.boot.online.banking.service.AuditLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditLogServiceImpl implements AuditLogService {

    private static final Logger logger = LoggerFactory.getLogger(AuditLogServiceImpl.class);

    @Autowired
    private AuditLogRepository repo;

    public boolean store(AuditLog log) {
        logger.info("Storing audit log");
        return repo.store(log);
    }

    public List<AuditLog> retrieve() throws Exception {
        logger.info("Retrieving audit logs");
        List<AuditLog> list = repo.retrieve();
        if (list.isEmpty()) throw new AuditLogNotFoundException("No audit logs found");
        return list;
    }

    public AuditLog search(int id) throws Exception {
        logger.info("Searching audit log with ID: {}", id);
        AuditLog log = repo.search(id);
        if (log == null) throw new AuditLogNotFoundException("Audit log not found");
        return log;
    }

    public boolean delete(int id) throws Exception {
        logger.info("Deleting audit log with ID: {}", id);
        try {
            repo.delete(id);
        } catch (Exception e) {
            throw new AuditLogNotFoundException("Audit log not found");
        }
        return true;
    }
}

