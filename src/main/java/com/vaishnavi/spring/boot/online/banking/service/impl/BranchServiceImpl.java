package com.vaishnavi.spring.boot.online.banking.service.impl;

import com.vaishnavi.spring.boot.online.banking.exceptions.BranchNotFoundException;
import com.vaishnavi.spring.boot.online.banking.model.Branch;
import com.vaishnavi.spring.boot.online.banking.repository.BranchRepository;
import com.vaishnavi.spring.boot.online.banking.service.BranchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchServiceImpl implements BranchService {

    private static final Logger logger = LoggerFactory.getLogger(BranchServiceImpl.class);

    @Autowired
    private BranchRepository repo;

    public boolean store(Branch branch) {
        logger.info("Storing branch");
        return repo.store(branch);
    }

    public List<Branch> retrieve() throws Exception {
        logger.info("Retrieving branches");
        List<Branch> list = repo.retrieve();
        if (list.isEmpty()) throw new BranchNotFoundException("No branches found");
        return list;
    }

    public Branch search(int id) throws Exception {
        logger.info("Searching branch with ID: {}", id);
        Branch branch = repo.search(id);
        if (branch == null) throw new BranchNotFoundException("Branch not found");
        return branch;
    }

    public boolean delete(int id) throws Exception {
        logger.info("Deleting branch with ID: {}", id);
        try {
            repo.delete(id);
        } catch (Exception e) {
            throw new BranchNotFoundException("Branch not found");
        }
        return true;
    }
}


