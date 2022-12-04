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

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

//@Data
public class ResellersDTO {

    @Length(max = 100,message = ConstantMessage.WARNING_RESELLER_NAME_MAX_LENGTH)
    @NotEmpty(message = ConstantMessage.WARNING_NAME_MANDATORY)
    private String resellerName;

    @Length(max = 20,message = ConstantMessage.WARNING_PHONE_NUMBER_MAX_LENGTH)
    @NotEmpty(message = ConstantMessage.WARNING_PH_NUMBER_MANDATORY)
    private String phoneNumber;

    @NotEmpty(message = ConstantMessage.WARNING_EMAIL_MAX_LENGTH)
    @Email(message = ConstantMessage.ERROR_EMAIL_FORMAT_INVALID)
    private String email;
}
