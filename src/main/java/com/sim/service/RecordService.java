package com.sim.service;

import com.sim.dao.RecordDAO;
import com.sim.model.Account;
import com.sim.model.AccountCount;
import com.sim.model.Record;
import com.sim.utils.RecordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordService {
    @Autowired
    private RecordDAO recordDAO;
    @Autowired
    private RecordUtils recordUtils;
    public Record getRecord(String recordType, Account account, int amount, String  destination){
        String body=recordUtils.RecordWrapper(recordType,account,Integer.valueOf(amount).toString());
        Record record=new Record();
        record.setAmount(Integer.valueOf(amount).toString());
        record.setData(body);
        record.setDestination(destination);
        record.setRemain(Integer.valueOf(account.getCashamount()).toString());
        record.setRecordType(recordType);
        record.setAccountID(account.getAccountid());
        AccountCount accountCount=recordDAO.GetCount(account.getAccountid());
        record.setRecordID(Integer.valueOf(recordDAO.GetRecordCount()+1).toString());
        recordDAO.UpdateCount(account.getAccountid());
        recordDAO.insertRecord(record, account.getAccountid());
        return record;
    }
}
