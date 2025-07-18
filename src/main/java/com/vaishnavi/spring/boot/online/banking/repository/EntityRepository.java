package com.vaishnavi.spring.boot.online.banking.repository;

import java.util.List;

public interface EntityRepository<T> {
    boolean store(T obj);
    boolean delete(int id) throws Exception;
    List<T> retrieve() throws Exception;
    T search(int id) throws Exception;
}


