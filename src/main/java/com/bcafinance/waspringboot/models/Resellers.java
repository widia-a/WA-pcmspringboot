package com.bcafinance.waspringboot.models;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 30/11/2022 13:59
Last modified on 13:59
Version 1.0
*/

import com.bcafinance.waspringboot.utils.ConstantMessage;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//@Data
@Entity
@Table(name = "MstResellers")
public class Resellers implements Serializable {

    private static final long serialversionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ResellerID")
    private Long resId;

    @Length(message = ConstantMessage.WARNING_RESELLER_NAME_MAX_LENGTH)
    @NotEmpty(message = ConstantMessage.WARNING_NAME_MANDATORY)
    @Column(name = "ResellerName",length = 100 ,nullable = false)
    private String resellerName;

    @Column(name = "BusinessType", length = 50, nullable = true)
    private String businessType;

    @Column(name = "AddressLine",nullable = true)
    private String addressLine;

    @Length(message = ConstantMessage.WARNING_PHONE_NUMBER_MAX_LENGTH)
    @NotEmpty(message = ConstantMessage.WARNING_PH_NUMBER_MANDATORY)
    @Column(name = "PhoneNumber",length = 20,nullable = false,unique = true)
    private String phoneNumber;

    @Length(message = ConstantMessage.WARNING_EMAIL_MAX_LENGTH)
    @NotEmpty(message = ConstantMessage.WARNING_RES_EMAIL_MANDATORY)
    @Column(name = "Email",length = 50 ,nullable = false,unique = true)
    private String email;

    @Column(name = "YearOpened",length = 10,nullable = true)
    private String yearOpened;

    @Column(name = "CreatedBy",nullable = false)
    private String createdBy = "1";

    @Column(name = "CreatedDate",nullable = true)
    private Date createdDate = new Date();

    @Column(name = "ModifiedBy",nullable = true)
    private String modifiedBy ;

    @Column(name = "ModifiedDate",nullable = true)
    private Date modifiedDate;

    @Column(name = "IsActive",nullable = true)
    private boolean isActive = true;

    @ManyToMany(mappedBy = "resellers")
    @JsonBackReference
    @JsonIgnoreProperties(ignoreUnknown = true)
    private Set<Stores> storeList = new HashSet<Stores>();

    public Resellers() {
    }

    public Long getResId(){
        return resId;
    }

    public void setResId(Long resId) {
        this.resId = resId;
    }

    public String getResellerName(){return resellerName;}

    public void setResellerName(String resellerName) {
        this.resellerName = resellerName;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getYearOpened() {
        return yearOpened;
    }

    public void setYearOpened(String yearOpened) {
        this.yearOpened = yearOpened;
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

    public Set<Stores> getStoreList() {
        return storeList;
    }

    public void setStoreList(Set<Stores> storeList) {
        this.storeList = storeList;
    }
}
