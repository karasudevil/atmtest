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
    public Record getRecord(String recordType, Account account, int amount, Account destination){
        String body=recordUtils.RecordWrapper(recordType,account,Integer.valueOf(amount).toString(),destination);
        Record record=new Record();
        record.setRecordBody(body);
        record.setRecordType(recordType);
        record.setAccountID(account.getAccountid());
        AccountCount accountCount=recordDAO.GetCount(account.getAccountid());
        record.setRecordID(Integer.valueOf(accountCount.getRecordCount()+1).toString());
        recordDAO.UpdateCount(account.getAccountid());
        recordDAO.insertRecord(record, account.getAccountid());
        return record;
    }
}
