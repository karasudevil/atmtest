package com.sim.controller;

import com.sim.model.Account;
import com.sim.model.Record;
import com.sim.service.DispenseService;
import com.sim.service.RecordService;
import com.sim.utils.ControllerUtils;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AtmDepositController {
    private final Logger logger= LoggerFactory.getLogger(AtmDepositController.class);
    @Autowired
    private DispenseService dispenseService;
    @Autowired
    private ControllerUtils controllerUtils;
    @Autowired
    private RecordService recordService;

    @GetMapping("/deposit")
    public ResponseEntity<String> Deposit(@RequestParam("depositAmount")int amount, HttpSession session){
        logger.info("Receive deposit request "+amount);
        Account account;
        account=controllerUtils.getAccountFromID(controllerUtils.getUidFromHttpSession(session).toString());
        if(dispenseService.dispenseCash(account,amount)){
            logger.info("Deposit service start");
            Record record= recordService.getRecord("deposit", account, amount, null);
            logger.info("add record "+ record.toString());
            return ResponseEntity.status(HttpStatus.OK).body("Deposit succeed");
        }
        else{
            logger.info("Deposit failed");
            return ResponseEntity.badRequest().body("Deposit failed");
        }
    }
}
