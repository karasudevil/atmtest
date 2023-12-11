package com.sim.service;

import com.sim.model.Account;

public interface LoginService {
    public boolean isAccountValid(String name);
    public Account accountInfo(String name, String password);
}
