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
public class AtmDispenseController {
    private final Logger logger= LoggerFactory.getLogger(AtmDispenseController.class);
    @Autowired
    private DispenseService dispenseService;
    @Autowired
    private ControllerUtils controllerUtils;
    @Autowired
    private RecordService recordService;
    @GetMapping("/dispense")
    public ResponseEntity<String> Dispense(@RequestParam("dispenseAmount")int amount, HttpSession session){
        logger.info("Receive dispense request"+amount);
        Account account;
        account=controllerUtils.getAccountFromID(controllerUtils.getUidFromHttpSession(session).toString());
        if(dispenseService.dispenseCash(account, -amount)){
            logger.info("Dispense success");

            Record record= recordService.getRecord("dispense", account, -amount, null);
            logger.info("add record"+ record.toString());
            return ResponseEntity.status(HttpStatus.OK).body("Dispense succeed");
        }
        else{
            logger.info("Dispense failed");
            return ResponseEntity.badRequest().body("Dispense failed");
        }
    }
}
