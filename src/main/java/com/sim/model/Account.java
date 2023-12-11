package com.sim.model;

import java.util.List;

public class Account {
    private String AccountId;
    private final String name;
    private final String password;
    private int cashAmount;
    public  Account(String name, String password){
        this.name=name;
        this.password=password;
    }

    public void setAccountId(String accountId) {
        AccountId = accountId;
    }

    public void setCashAmount(int cashAmount) {
        this.cashAmount = cashAmount;
    }

    public String getAccountId() {
        return AccountId;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getCashAmount() {
        return cashAmount;
    }

    @Override
    public String toString(){
        return "Account={" +
                "AccountID=" + this.AccountId +
                "name=" + this.name +
                "password=" + this.password +
                "cashAmount=" + this.cashAmount +
                "}";
    }

}
