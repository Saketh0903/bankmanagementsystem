package com.example.bank.service;

import com.example.bank.model.Account;
import com.example.bank.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;

        // Seed a couple of demo accounts
        repository.save(new Account(null, "Alice", "SAVINGS", 15000.0));
        repository.save(new Account(null, "Bob", "CURRENT", 2500.0));
    }

    public List<Account> getAllAccounts() {
        return repository.findAll();
    }

    public Account getAccount(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Account createAccount(Account account) {
        account.setId(null);
        return repository.save(account);
    }

    public Account updateAccount(Long id, Account account) {
        if (!repository.existsById(id)) {
            return null;
        }
        account.setId(id);
        return repository.save(account);
    }

    public boolean deleteAccount(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}
