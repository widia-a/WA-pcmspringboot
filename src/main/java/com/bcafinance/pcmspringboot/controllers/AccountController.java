package com.bcafinance.pcmspringboot.controllers;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 01/12/2022 15:15
Last modified on 15:15
Version 1.0
*/

import com.bcafinance.pcmspringboot.handler.ResourceNotFoundException;
import com.bcafinance.pcmspringboot.handler.ResponseHandler;
import com.bcafinance.pcmspringboot.models.Accounts;
import com.bcafinance.pcmspringboot.models.Resellers;
import com.bcafinance.pcmspringboot.services.AccountService;
import com.bcafinance.pcmspringboot.utils.ConstantMessage;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class AccountController {

    @Getter
    private AccountService accountService;

    public AccountController(){}

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping("/accounts")
    public ResponseEntity<Object>
    saveAccount(@RequestBody Accounts accounts) throws Exception{
        if (accounts==null) throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        accountService.saveAccounts(accounts);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED, null, null, null);
    }

    @GetMapping("/accounts/datas/search/{resellerName}")
    public ResponseEntity<Object> getAccountByAccountName(@PathVariable("accountName") String accountName)throws Exception{
        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,accountService.findByAccountName(accountName),null,null);
    }

    @PutMapping("/accounts/up")
    public ResponseEntity<Object> updateAccountById(@RequestBody Accounts accounts) throws Exception{
        accountService.updateAccountById(accounts);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,null,null,null);
    }


}
