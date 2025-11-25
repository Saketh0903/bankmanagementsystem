package com.example.bank.repository;

import com.example.bank.model.Account;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class AccountRepository {

    private final Map<Long, Account> accounts = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1L);

    public List<Account> findAll() {
        return new ArrayList<>(accounts.values());
    }

    public Optional<Account> findById(Long id) {
        return Optional.ofNullable(accounts.get(id));
    }

    public Account save(Account account) {
        if (account.getId() == null) {
            account.setId(idCounter.getAndIncrement());
        }
        accounts.put(account.getId(), account);
        return account;
    }

    public void deleteById(Long id) {
        accounts.remove(id);
    }

    public boolean existsById(Long id) {
        return accounts.containsKey(id);
    }
}
