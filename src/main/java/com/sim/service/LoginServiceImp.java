package com.sim.service;

import com.sim.model.Account;
import com.sim.dao.LoginDAO;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImp implements LoginService{
    @Autowired
    LoginDAO loginDAO;
    private final Logger logger= LoggerFactory.getLogger(LoginServiceImp.class);
    @Override
    public boolean isAccountValid(String name) {
        if(name.length()!=16 ) return false;
        char[] chars = new char[name.length()];
        chars= name.toCharArray();
        for(int i=0;i< name.length(); i++) {
            if (chars[i] < '0' || chars[i] > '9') return false;
        }
        return true;
    }

    @Override
    public Account accountInfo(String name, String password) {
        try{
            Account account=loginDAO.getAccountbyName(name);
            logger.info(account.toString());
            if(account.getPassword().equals(password)){
                return account;
            }
            else return null;
        }catch (DataAccessException e){
            e.printStackTrace();
            return null;
        }

    }
}
