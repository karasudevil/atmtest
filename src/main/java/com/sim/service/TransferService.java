package com.sim.service;

import com.sim.dao.CashDAO;
import com.sim.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferService {
    @Autowired
    public  DispenseService dispenseService;
    public boolean TransferCash(Account account, Account destination, int amount){
        if(!dispenseService.dispenseCash(account, -amount)){
            return false;
        }
        if(!dispenseService.dispenseCash(destination, amount)) {
            return false;
        }
        return true;
    }
}
