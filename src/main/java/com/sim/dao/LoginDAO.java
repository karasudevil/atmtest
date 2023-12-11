package com.sim.dao;

import com.sim.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Account getAccountbyID(String id){
        String sql = "select * from account where id="+id;
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Account.class));
    }
    public Account getAccountbyName(String name){
        String sql = "select * from account where name="+name;
        return  jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class));
    }

    public int update(Account account, int amount){
        String sql = "update account set cashAmount=? where id=?";
        return jdbcTemplate.update(sql, amount, account.getAccountId());
    }


}