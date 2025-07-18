package com.vaishnavi.spring.boot.online.banking.repository;

import com.vaishnavi.spring.boot.online.banking.model.Loan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LoanRepository implements EntityRepository<Loan> {

    private static final Logger logger = LoggerFactory.getLogger(LoanRepository.class);
    private final List<Loan> loanList = new ArrayList<>();
    private int index = -1;

    @Override
    public boolean store(Loan loan) {
        logger.info("Inside LoanRepository.store()");
        loan.setLoanId(++index);
        loanList.add(index, loan);
        return true;
    }

    @Override
    public boolean delete(int id) throws Exception {
        logger.info("Inside LoanRepository.delete()");
        loanList.remove(id);
        return true;
    }

    @Override
    public List<Loan> retrieve() throws Exception {
        logger.info("Inside LoanRepository.retrieve()");
        return loanList;
    }

    @Override
    public Loan search(int id) throws Exception {
        logger.info("Inside LoanRepository.search()");
        return loanList.get(id);
    }
}


