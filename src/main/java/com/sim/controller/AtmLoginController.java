package com.sim.controller;

import com.sim.model.Account;
import com.sim.service.LoginService;
import com.sim.service.LoginServiceImp;
import jakarta.servlet.http.HttpSession;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AtmLoginController {
    private final Logger logger = LoggerFactory.getLogger(AtmLoginController.class);
    @Autowired
    private LoginServiceImp loginService;
    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestParam("name") String name, @RequestParam("password") String password, HttpSession session){
        logger.info("Received name:"+name+" password"+password);
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
        session.setAttribute("uid", account.getAccountid());
        session.setAttribute("name", account.getName());
        return ResponseEntity.status(HttpStatus.OK).body(account.toString());
    }
    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session){
        logger.info("Received logout request");
        session.removeAttribute("uid");
        session.removeAttribute("name");
        return ResponseEntity.status(HttpStatus.OK).body("account logout");
    }
    @GetMapping("/password")
    public ResponseEntity<String> passwordChange(@RequestParam("new_password") String  password,HttpSession session){
        logger.info("Received password change request");
        String accountID= session.getAttribute("uid").toString();
        if(loginService.ChangePasswordService(accountID,password))
            return ResponseEntity.status(HttpStatus.OK).body("change password succeed");
        return ResponseEntity.badRequest().body("password change failed");
    }

}
