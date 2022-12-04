package com.bcafinance.waspringboot.models;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 04/12/2022 11:39
Last modified on 11:39
Version 1.0
*/

import com.bcafinance.waspringboot.utils.ConstantMessage;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//@Data
@Entity
@Table(name = "MstStores")
public class Stores implements Serializable {

    private static final long serialversionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StoreID")
    private Long storeId;

    @Length(message = ConstantMessage.WARNING_STORE_NAME_MAX_LENGTH)
    @NotEmpty(message = ConstantMessage.WARNING_NAME_MANDATORY)
    @Column(name = "StoreName",length = 50 ,nullable = false)
    private String storeName;

    @Column(name = "Address",nullable = true)
    private String address;

    @Length(message = ConstantMessage.WARNING_PHONE_NUMBER_MAX_LENGTH)
    @NotEmpty(message = ConstantMessage.WARNING_PH_NUMBER_MANDATORY)
    @Column(name = "PhoneNumber",length = 20,nullable = false,unique = true)
    private String phoneNumber;

    @Length(message = ConstantMessage.WARNING_EMAIL_MAX_LENGTH)
    @Column(name = "Email",length = 50 ,nullable = true,unique = true)
    private String email;

    @ManyToMany
    @JoinTable(
            name = "StoreReseller",
            joinColumns = @JoinColumn(name = "StoreId", referencedColumnName = "StoreId"),
            inverseJoinColumns = @JoinColumn(name = "ResellerID", referencedColumnName = "ResellerID")
    )
    private Set<Resellers> resellers = new HashSet<Resellers>();

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

    public Stores(){}

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Set<Resellers> getResellers() {
        return resellers;
    }

    public void setResellers(Set<Resellers> resellers) {
        this.resellers = resellers;
    }
}

