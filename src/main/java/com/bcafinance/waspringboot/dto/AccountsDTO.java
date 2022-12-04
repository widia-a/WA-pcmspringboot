package com.bcafinance.waspringboot.dto;
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

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

//@Data
public class AccountsDTO {
    @Length(max = 50,message = ConstantMessage.WARNING_ACCOUNT_NAME_MAX_LENGTH)
    @NotEmpty(message = ConstantMessage.WARNING_NAME_MANDATORY)
    private String resellerName;

    @Length(max = 20,message = ConstantMessage.WARNING_ACC_NUM_MAX_LENGTH)
    @Column(name = "AccountNumber",length = 20,nullable = true)
    private String accountNumber;
}
