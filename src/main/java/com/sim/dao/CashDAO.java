package com.sim.dao;

import com.sim.model.AccountCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CashDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public int update(String accountID, int amount){
        String sql = "update account set cashAmount=? where ACCOUNTID=?";
        return jdbcTemplate.update(sql, amount, accountID);
    }

}
