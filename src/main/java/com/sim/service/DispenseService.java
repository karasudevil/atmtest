package com.sim.service;

import com.sim.dao.CashDAO;
import com.sim.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DispenseService {
    @Autowired
    CashDAO cashDAO;
    public boolean dispenseCash(Account account, int amount){
        int cashNow;
        cashNow=account.getCashamount();
        if(amount<= cashNow){
            if(cashDAO.update(account.getAccountid(), cashNow+amount)!=0){
                account.setCashamount(cashNow+amount);
                return true;
            }
            else return false;
        }
        else return false;
    }
}
