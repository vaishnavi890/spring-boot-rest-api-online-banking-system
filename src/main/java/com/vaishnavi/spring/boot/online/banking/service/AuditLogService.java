package com.vaishnavi.spring.boot.online.banking.service;

import com.vaishnavi.spring.boot.online.banking.model.AuditLog;

import java.util.List;

public interface AuditLogService {
    boolean store(AuditLog auditLog);
    List<AuditLog> retrieve() throws Exception;
    AuditLog search(int id) throws Exception;
    boolean delete(int id) throws Exception;
}

