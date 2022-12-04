package com.bcafinance.waspringboot.controllers;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 01/12/2022 15:15
Last modified on 15:15
Version 1.0
*/

import com.bcafinance.waspringboot.handler.ResourceNotFoundException;
import com.bcafinance.waspringboot.handler.ResponseHandler;
import com.bcafinance.waspringboot.models.Accounts;
import com.bcafinance.waspringboot.services.AccountService;
import com.bcafinance.waspringboot.utils.ConstantMessage;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/")
public class AccountController {

    @Getter
    private AccountService accountService;

//    public AccountController(){}

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping("/accounts")
    public ResponseEntity<Object>
    saveAccount(@RequestBody Accounts accounts,
                @RequestHeader Map<String,String> headers,
                @RequestParam Map<String,String> params,
            WebRequest request, Error error) throws Exception{
        if (accounts==null) throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        accountService.saveAccounts(accounts);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED, null, null, null);
    }

    @PostMapping("/accounts/bat")
    public ResponseEntity<Object>
    saveAllAccounts(@RequestBody List<Accounts> accounts,
                    @RequestHeader Map<String,String> headers,
                    @RequestParam Map<String,String> params,
                    WebRequest request, Error error) throws Exception {

        if(accounts==null)throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        accountService.saveAllAccounts(accounts);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,null,null,null);
    }

    @PutMapping("/accounts/up")
    public ResponseEntity<Object> updateAccountById(@RequestBody Accounts accounts,
                                                    @RequestHeader Map<String,String> headers,
                                                    @RequestParam Map<String,String> params,
                                                    WebRequest request, Error error) throws Exception{
        accountService.updateAccountById(accounts);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,null,null,null);
    }

    @GetMapping("/accounts/datas/l/{accountName}")
    public ResponseEntity<Object> getAccountsLike(@PathVariable("accountName") String accountName)throws Exception{

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,accountService.findAccountNameLikes(accountName),null,null);
    }

    @GetMapping("/accounts/datas/all/2")
    public ResponseEntity<Object> findAllAccounts()throws Exception{
        List<Accounts> lsAccounts = accountService.findAllAccounts();

        if(lsAccounts.size()==0)
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
        }

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,lsAccounts,null,null);
    }

    @GetMapping("/accounts/{accountId}")
    public ResponseEntity<Object> getAccountById(@PathVariable("accountId") long accountId) throws Exception {
        Accounts accounts = accountService.findByAccountsId(accountId);

        if(accounts != null)
        {
            return new ResponseHandler().
                    generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK,accounts,null,null);
        }
        else
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_NOT_FOUND);
        }
    }


}
