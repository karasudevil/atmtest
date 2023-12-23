package com.sim.dao;

import com.sim.model.AccountCount;
import com.sim.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecordDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public int insertRecord(Record record, String id){
        String sql="insert into record values(?,?,?,?)";
        return jdbcTemplate.update(sql,id ,record.getRecordType(),Integer.parseInt(record.getRecordID()) , record.getRecordBody());
    }
    public AccountCount GetCount(String accountID){
        String sql= "select * from account_record where accountid=" + accountID;
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(AccountCount.class));
    }
    public int UpdateCount(String accountID){
        String sql = "update account_record set recordcount=recordcount+1 where accountid="+ accountID;
        return jdbcTemplate.update(sql);
    }
    public List<Record> GetRecord(String accountID){
        List<Record> records;
        String sql="select * from record where accountid="+ accountID;
        records= jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Record.class));
        return records;
    }

}
