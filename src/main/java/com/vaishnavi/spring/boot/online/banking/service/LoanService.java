package com.vaishnavi.spring.boot.online.banking.service;

import com.vaishnavi.spring.boot.online.banking.model.Loan;

import java.util.List;

public interface LoanService {
    boolean store(Loan loan);
    List<Loan> retrieve() throws Exception;
    Loan search(int id) throws Exception;
    boolean delete(int id) throws Exception;
}


