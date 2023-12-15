package com.sim.utils;

import com.sim.dao.LoginDAO;
import com.sim.model.Account;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ControllerUtils {
    @Autowired
    private LoginDAO loginDAO;
    public Integer getUidFromHttpSession(HttpSession session){
        return Integer.valueOf(session.getAttribute("uid").toString());
    }
    public String  getNameFromHttpSession(HttpSession session){
        return session.getAttribute("name").toString();
    }
    public Account getAccountFromID(String ID){
        return loginDAO.getAccountbyID(ID);
    }
}
