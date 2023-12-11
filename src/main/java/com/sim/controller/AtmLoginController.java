package com.sim.controller;

import com.sim.model.Account;
import com.sim.service.LoginService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AtmLoginController {
    private final Logger logger = LoggerFactory.getLogger(AtmLoginController.class);
    private LoginService loginService;
    @GetMapping("/login")
    public ResponseEntity<String> login(String name, String password){
        if(!loginService.isAccountValid(name)){
            logger.error("Got Invalid Account");
            return ResponseEntity.badRequest().body("Invalid Account name!");
        }
        Account account=loginService.accountInfo(name,password);
        if(ObjectUtils.isEmpty(account)){
            logger.error("Account not exist");
            return ResponseEntity.badRequest().body("Account not exist");
        }
        logger.info("Response "+account.toString());
        return ResponseEntity.status(HttpStatus.OK).body(account.toString());
    }

}
