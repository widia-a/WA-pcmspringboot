package com.bcafinance.waspringboot.models;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 01/12/2022 15:10
Last modified on 15:10
Version 1.0
*/

import com.bcafinance.waspringboot.utils.ConstantMessage;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@Entity
@Table(name = "MstAccount")
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AccountID")
    private Long accountId;

    @ManyToOne
    @JoinColumn(name = "ResellerID")
    private Resellers resellers;

    @Length(max = 50,message = ConstantMessage.WARNING_ACCOUNT_NAME_MAX_LENGTH)
    @NotEmpty(message = ConstantMessage.WARNING_NAME_MANDATORY)
    @Column(name = "AccountName",length = 50,nullable = false)
    private String accountName;

    @Length(max = 20,message = ConstantMessage.WARNING_ACC_NUM_MAX_LENGTH)
    @Column(name = "AccountNumber",length = 20,nullable = true)
    private String accountNumber;

    @Column(name = "AccountDescription",length = 50,nullable = true)
    private String accountDescription;

    @Column(name = "CreatedBy",nullable = true)
    private String createdBy = "1";

    @Column(name = "CreatedDate",nullable = true)
    private Date createdDate = new Date();

    @Column(name = "ModifiedBy",nullable = true)
    private String modifiedBy ;

    @Column(name = "ModifiedDate",nullable = true)
    private Date modifiedDate;

    @Column(name = "IsActive",nullable = false)
    private boolean isActive = true;

    public Accounts() {
    }

    public long getId(){
        return accountId;
    }

    public void setId(Long id){
        this.accountId = id;
    }

    public Resellers getReseller(){
        return resellers;
    }

    public void setResellers(Resellers resellers) {
        this.resellers = resellers;
    }

    public String getName(){ return accountName;}

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber(){ return accountNumber;}

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountDescription(){
        return  accountDescription;
    }

    public void setAccountDescription(String accountDescription) {
        this.accountDescription = accountDescription;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


}
