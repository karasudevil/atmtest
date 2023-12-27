package com.sim.controller;

import com.sim.dao.LoginDAO;
import com.sim.dao.RecordDAO;
import com.sim.model.Account;
import com.sim.model.Record;
import com.sim.service.LoginServiceImp;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class AtmCheckController {
    private final Logger logger= LoggerFactory.getLogger(AtmCheckController.class);
    @Autowired
    private LoginDAO loginDAO;
    @Autowired
    private RecordDAO recordDAO;
    @GetMapping("/remain")
    public ResponseEntity<String> CheckRemain(HttpSession session){
        logger.info("Receive check remain request");
        String name= session.getAttribute("name").toString();
        logger.info(name);
        Account account= loginDAO.getAccountbyName(name);
        if(ObjectUtils.isEmpty(account)) return ResponseEntity.badRequest().body("account error");
        return ResponseEntity.status(HttpStatus.OK).body(Integer.valueOf(account.getCashamount()).toString());
    }
    @GetMapping("/detail-record")
    public ResponseEntity<List<Record> > CheckDetail(HttpSession session){
        logger.info("Receive check detail request");
        String id = session.getAttribute("uid").toString();
        List<Record> records= recordDAO.GetRecord(id);
        return ResponseEntity.status(HttpStatus.OK).body(records);
    }
}
