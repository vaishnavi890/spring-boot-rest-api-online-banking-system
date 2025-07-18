package com.vaishnavi.spring.boot.online.banking.repository;

import com.vaishnavi.spring.boot.online.banking.model.AdminUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AdminUserRepository implements EntityRepository<AdminUser> {

    private static final Logger logger = LoggerFactory.getLogger(AdminUserRepository.class);
    private final List<AdminUser> adminList = new ArrayList<>();
    private int index = -1;

    @Override
    public boolean store(AdminUser adminUser) {
        logger.info("Inside AdminUserRepository.store()");
        adminUser.setAdminId(++index);
        adminList.add(index, adminUser);
        return true;
    }

    @Override
    public boolean delete(int id) throws Exception {
        logger.info("Inside AdminUserRepository.delete()");
        adminList.remove(id);
        return true;
    }

    @Override
    public List<AdminUser> retrieve() throws Exception {
        logger.info("Inside AdminUserRepository.retrieve()");
        return adminList;
    }

    @Override
    public AdminUser search(int id) throws Exception {
        logger.info("Inside AdminUserRepository.search()");
        return adminList.get(id);
    }
}
