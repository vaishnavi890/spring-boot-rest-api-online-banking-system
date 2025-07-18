package com.vaishnavi.spring.boot.online.banking.service;

import com.vaishnavi.spring.boot.online.banking.model.Notification;

import java.util.List;

public interface NotificationService {
    boolean store(Notification notification);
    List<Notification> retrieve() throws Exception;
    Notification search(int id) throws Exception;
    boolean delete(int id) throws Exception;
}

