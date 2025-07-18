package com.vaishnavi.spring.boot.online.banking.service;

import com.vaishnavi.spring.boot.online.banking.model.Branch;

import java.util.List;

public interface BranchService {
    boolean store(Branch branch);
    List<Branch> retrieve() throws Exception;
    Branch search(int id) throws Exception;
    boolean delete(int id) throws Exception;
}

