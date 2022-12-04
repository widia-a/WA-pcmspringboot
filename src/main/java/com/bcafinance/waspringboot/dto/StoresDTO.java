package com.bcafinance.waspringboot.dto;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 04/12/2022 11:40
Last modified on 11:40
Version 1.0
*/

import com.bcafinance.waspringboot.utils.ConstantMessage;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StoresDTO {
    private Long storeId;

    @Length(max = 50, message = ConstantMessage.WARNING_STORE_NAME_MAX_LENGTH)
    @NotEmpty(message = ConstantMessage.WARNING_NAME_MANDATORY)
    private String storeName;

    @Length(message = ConstantMessage.WARNING_PHONE_NUMBER_MAX_LENGTH)
    @NotEmpty(message = ConstantMessage.WARNING_PH_NUMBER_MANDATORY)
    private  String phoneNumber;

}
