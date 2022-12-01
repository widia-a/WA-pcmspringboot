package com.bcafinance.pcmspringboot.models;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 30/11/2022 13:59
Last modified on 13:59
Version 1.0
*/

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Data
@Entity
@Table(name = "MstResellers")
public class Resellers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ResellerID")
    private Long id;

    @Column(name = "ResellerName",length = 100 ,nullable = false)
    private String resellerName;

    @Column(name = "BusinessType", length = 50, nullable = true)
    private String businessType;

    @Column(name = "AddressLine",nullable = true)
    private String addressLine;

    @Column(name = "PhoneNumber",length = 20,nullable = true,unique = true)
    private String phoneNumber;

    @Column(name = "Email",length = 50 ,nullable = true,unique = true)
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

    public Resellers() {
    }

}
