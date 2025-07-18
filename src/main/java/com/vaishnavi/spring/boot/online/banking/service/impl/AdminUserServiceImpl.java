package com.vaishnavi.spring.boot.online.banking.service.impl;

import com.vaishnavi.spring.boot.online.banking.exceptions.AdminUserNotFoundException;
import com.vaishnavi.spring.boot.online.banking.model.AdminUser;
import com.vaishnavi.spring.boot.online.banking.repository.AdminUserRepository;
import com.vaishnavi.spring.boot.online.banking.service.AdminUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    private static final Logger logger = LoggerFactory.getLogger(AdminUserServiceImpl.class);

    @Autowired
    private AdminUserRepository repo;

    public boolean store(AdminUser user) {
        logger.info("Storing admin user");
        return repo.store(user);
    }

    public List<AdminUser> retrieve() throws Exception {
        logger.info("Retrieving all admin users");
        List<AdminUser> list = repo.retrieve();
        if (list.isEmpty()) throw new AdminUserNotFoundException("No admin users found");
        return list;
    }

    public AdminUser search(int id) throws Exception {
        logger.info("Searching admin user with ID: {}", id);
        AdminUser user = repo.search(id);
        if (user == null) throw new AdminUserNotFoundException("Admin user not found");
        return user;
    }

    public boolean delete(int id) throws Exception {
        logger.info("Deleting admin user with ID: {}", id);
        try {
            repo.delete(id);
        } catch (Exception e) {
            throw new AdminUserNotFoundException("Admin user not found");
        }
        return true;
    }
}


