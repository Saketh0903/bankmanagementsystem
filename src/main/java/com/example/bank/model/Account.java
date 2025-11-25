package com.example.bank.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Account {

    private Long id;

    @NotBlank
    private String holderName;

    @NotBlank
    private String type; // SAVINGS, CURRENT, etc.

    @NotNull
    @Min(0)
    private Double balance;

    public Account() {
    }

    public Account(Long id, String holderName, String type, Double balance) {
        this.id = id;
        this.holderName = holderName;
        this.type = type;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
