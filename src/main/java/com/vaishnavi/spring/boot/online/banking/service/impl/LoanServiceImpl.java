package com.vaishnavi.spring.boot.online.banking.service.impl;

import com.vaishnavi.spring.boot.online.banking.exceptions.LoanNotFoundException;
import com.vaishnavi.spring.boot.online.banking.model.Loan;
import com.vaishnavi.spring.boot.online.banking.repository.LoanRepository;
import com.vaishnavi.spring.boot.online.banking.service.LoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {

    private static final Logger logger = LoggerFactory.getLogger(LoanServiceImpl.class);

    @Autowired
    private LoanRepository repo;

    public boolean store(Loan loan) {
        logger.info("Storing loan");
        return repo.store(loan);
    }

    public List<Loan> retrieve() throws Exception {
        logger.info("Retrieving all loans");
        List<Loan> list = repo.retrieve();
        if (list.isEmpty()) throw new LoanNotFoundException("No loan records found");
        return list;
    }

    public Loan search(int id) throws Exception {
        logger.info("Searching loan with ID: {}", id);
        Loan loan = repo.search(id);
        if (loan == null) throw new LoanNotFoundException("Loan not found");
        return loan;
    }

    public boolean delete(int id) throws Exception {
        logger.info("Deleting loan with ID: {}", id);
        try {
            repo.delete(id);
        } catch (Exception e) {
            throw new LoanNotFoundException("Loan not found for deletion");
        }
        return true;
    }
}


