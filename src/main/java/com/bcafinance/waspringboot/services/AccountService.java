package com.bcafinance.waspringboot.services;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 01/12/2022 15:17
Last modified on 15:17
Version 1.0
*/


import com.bcafinance.waspringboot.handler.ResourceNotFoundException;
import com.bcafinance.waspringboot.models.Accounts;
import com.bcafinance.waspringboot.repos.AccountRepo;
import com.bcafinance.waspringboot.utils.ConstantMessage;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.ResourceAccessException;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class AccountService {

    @Getter
    private AccountRepo accountRepo;

    @Autowired
    public void AccountService(AccountRepo accountRepo){
        this.accountRepo = accountRepo;
    }

    public void saveAccounts(Accounts accounts) throws Exception {
        accountRepo.save(accounts);
    }

    @Transactional(rollbackFor = {Exception.class})
    public void saveAllAccounts(List<Accounts> ls ) {
        accountRepo.saveAll(ls);
    }


    public Accounts findByAccountName(String accountName) throws Exception {
        List<Accounts> lsAccount = accountRepo.searchByAccountName(accountName);
        return accountRepo.findByAccountName(accountName).orElseThrow(() ->
                new ResourceNotFoundException(ConstantMessage.WARNING_CUSTOMER_NOT_FOUND));
    }


    public void updateAccountById(Accounts ac) throws Exception {
        Accounts accounts = accountRepo.findById(ac.getAccountId()).orElseThrow(() ->
                new ResourceAccessException(ConstantMessage.WARNING_CUSTOMER_NOT_FOUND));

        accounts.setModifiedBy("1");
        accounts.setModifiedDate(new Date());

        if (ac.getAccountName() != null
                && !Objects.equals(accounts.getAccountName(), ac.getAccountName())
                && !ac.getAccountName().equals(""))
        {
            accounts.setAccountName(ac.getAccountName());
        }

        if (ac.getAccountDescription() != null
                && !Objects.equals(accounts.getAccountDescription(), ac.getAccountDescription())
                && !ac.getAccountDescription().equals(""))
        {
            accounts.setAccountDescription(ac.getAccountDescription());
        }
    }

    public List<Accounts> findAccountNameLikes(String accountName) {
        return accountRepo.findByAccountNameLike(accountName);

    }

    public List<Accounts> findAllAccounts() {
        return accountRepo.findAll();
    }

    public Accounts findByAccountsId(long id) throws Exception {
        return accountRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(ConstantMessage.WARNING_NOT_FOUND));
    }
}
