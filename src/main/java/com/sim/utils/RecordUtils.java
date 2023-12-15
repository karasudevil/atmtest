package com.sim.utils;

import com.sim.model.Account;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RecordUtils {
    public String RecordWrapper(String recordType, Account account, String amount, Account destination){
        LocalDateTime localDateTime=LocalDateTime.now();
        String body="";
        body+="{";
        body+=localDateTime.toString();
        body+=",";
        String remain=Integer.valueOf(account.getCashamount()).toString();
        body = switch (recordType) {
            case "dispense", "deposit" -> body + amount + "," + remain;
            case "transfer" -> body + amount + "," + remain + "," + destination.getName();
            default -> body;
        };
        body+="}";
        return body;
    }
}
