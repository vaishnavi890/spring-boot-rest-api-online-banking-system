package com.vaishnavi.spring.boot.online.banking.repository;

import com.vaishnavi.spring.boot.online.banking.model.Branch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BranchRepository implements EntityRepository<Branch> {

    private static final Logger logger = LoggerFactory.getLogger(BranchRepository.class);
    private final List<Branch> branchList = new ArrayList<>();
    private int index = -1;

    @Override
    public boolean store(Branch branch) {
        logger.info("Inside BranchRepository.store()");
        branch.setBranchId(++index);
        branchList.add(index, branch);
        return true;
    }

    @Override
    public boolean delete(int id) throws Exception {
        logger.info("Inside BranchRepository.delete()");
        branchList.remove(id);
        return true;
    }

    @Override
    public List<Branch> retrieve() throws Exception {
        logger.info("Inside BranchRepository.retrieve()");
        return branchList;
    }

    @Override
    public Branch search(int id) throws Exception {
        logger.info("Inside BranchRepository.search()");
        return branchList.get(id);
    }
}

