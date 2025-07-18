package com.vaishnavi.spring.boot.online.banking.service;

import com.vaishnavi.spring.boot.online.banking.model.AdminUser;
import java.util.List;

public interface AdminUserService {
    boolean store(AdminUser adminUser);
    List<AdminUser> retrieve() throws Exception;
    AdminUser search(int id) throws Exception;
    boolean delete(int id) throws Exception;
}
