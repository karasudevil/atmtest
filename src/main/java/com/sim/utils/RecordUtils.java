package com.sim.utils;

import com.sim.model.Account;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RecordUtils {
    public String RecordWrapper(String recordType, Account account, String amount){
        LocalDateTime localDateTime=LocalDateTime.now();
        String body="";
        body+=localDateTime.toString().substring(0, 19);
        return body;
        //record body形式：{日期，交易数额，余额，目标账户（转账时出现）}
    }
}
