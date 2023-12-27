package com.sim.controller;

import com.sim.dao.LoginDAO;
import com.sim.model.Account;
import com.sim.model.Record;
import com.sim.service.LoginServiceImp;
import com.sim.service.RecordService;
import com.sim.service.TransferService;
import com.sim.utils.ControllerUtils;
import com.sim.utils.RecordUtils;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AtmTransferController {
    @Autowired
    private TransferService transferService;
    @Autowired
    private ControllerUtils controllerUtils;
    @Autowired
    private LoginDAO loginDAO;
    @Autowired
    private RecordService recordService;
    private final Logger logger= LoggerFactory.getLogger(AtmTransferController.class);
    @GetMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestParam("destination")String name, @RequestParam("amount")int amount, HttpSession session){
        logger.info("Receive transfer request. Destination is "+name+"cash amount is"+amount);
        Account account,destination;
        destination=loginDAO.getAccountbyName(name);
        account=controllerUtils.getAccountFromID(controllerUtils.getUidFromHttpSession(session).toString());
        if(ObjectUtils.isEmpty(destination)){
            logger.error("Destination null.Transfer reject");
            return ResponseEntity.badRequest().body("Destination account null");
        }
        if(transferService.TransferCash(account,destination,amount)){
            logger.info("Transfer succeed");
            Record record;
            record=recordService.getRecord("transfer",account,-amount,destination.getName());
            Record record1;
            record1=recordService.getRecord("transfer", destination, amount, account.getName());
            logger.info("generate record "+record.toString());
            logger.info("generate destination record"+record1.toString());
            return  ResponseEntity.status(HttpStatus.OK).body("Transfer succeed");
        }
        else{
            logger.error("Transfer failed");
            return ResponseEntity.badRequest().body("Transfer failed");
        }

    }
}
