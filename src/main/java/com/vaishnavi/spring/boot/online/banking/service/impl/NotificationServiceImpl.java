package com.vaishnavi.spring.boot.online.banking.service.impl;

import com.vaishnavi.spring.boot.online.banking.exceptions.NotificationNotFoundException;
import com.vaishnavi.spring.boot.online.banking.model.Notification;
import com.vaishnavi.spring.boot.online.banking.repository.NotificationRepository;
import com.vaishnavi.spring.boot.online.banking.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    private static final Logger logger = LoggerFactory.getLogger(NotificationServiceImpl.class);

    @Autowired
    private NotificationRepository repo;

    public boolean store(Notification notification) {
        logger.info("Storing notification");
        return repo.store(notification);
    }

    public List<Notification> retrieve() throws Exception {
        logger.info("Retrieving notifications");
        List<Notification> list = repo.retrieve();
        if (list.isEmpty()) throw new NotificationNotFoundException("No notifications found");
        return list;
    }

    public Notification search(int id) throws Exception {
        logger.info("Searching notification with ID: {}", id);
        Notification notification = repo.search(id);
        if (notification == null) throw new NotificationNotFoundException("Notification not found");
        return notification;
    }

    public boolean delete(int id) throws Exception {
        logger.info("Deleting notification with ID: {}", id);
        try {
            repo.delete(id);
        } catch (Exception e) {
            throw new NotificationNotFoundException("Notification not found");
        }
        return true;
    }
}


