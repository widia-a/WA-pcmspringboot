package com.bcafinance.pcmspringboot.services;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 30/11/2022 14:19
Last modified on 14:19
Version 1.0
*/

import com.bcafinance.pcmspringboot.handler.FormatValidation;
import com.bcafinance.pcmspringboot.handler.ResourceNotFoundException;
import com.bcafinance.pcmspringboot.models.Resellers;
import com.bcafinance.pcmspringboot.repos.ResellerRepo;
import com.bcafinance.pcmspringboot.utils.ConstantMessage;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class ResellerService {
    
    @Getter
    private ResellerRepo resellerRepo;
    
    @Autowired
    public void ResellerService(ResellerRepo resellerRepo){
       this.resellerRepo = resellerRepo;
    }

    public void saveResellers(Resellers resellers) throws Exception {
        if (resellers.getResellerName()==null) throw new DataIntegrityViolationException(ConstantMessage.ERROR_DATA_INVALID);
        if (resellers.getPhoneNumber()==null) throw new DataIntegrityViolationException(ConstantMessage.ERROR_DATA_INVALID);

//        FormatValidation.phoneNumberFormatValidation(resellers.getPhoneNumber());
//        FormatValidation.emailFormatValidation(resellers.getEmail());
//
//        Optional<Resellers>resByEmail = resellerRepo.findByEmail(resellers.getEmail());
//        if (resByEmail.isPresent()){
//            throw new ResourceNotFoundException(ConstantMessage.WARNING_EMAIL_EXIST);
//        }
        resellerRepo.save(resellers);
    }

    public Resellers findByResellerId(long id) throws Exception {
        return resellerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(ConstantMessage.WARNING_NOT_FOUND));
    }

    public List<Resellers> findAllResellers() {
        return resellerRepo.findAll();
    }

    @Transactional
    public void updateResellerById(Resellers r) throws Exception {
        Resellers resellers = resellerRepo.findById(r.getId()).orElseThrow(() -> new ResourceNotFoundException(ConstantMessage.WARNING_CUSTOMER_NOT_FOUND));

        resellers.setModifiedBy("1");
        resellers.setModifiedDate(new Date());

        if(r.getResellerName() != null
                && !Objects.equals(resellers.getResellerName(),r.getResellerName())
                && !r.getResellerName().equals(""))
        {
            resellers.setResellerName(r.getResellerName());
        }

        if(r.getEmail() != null &&
                r.getEmail().length()>0 &&
                !Objects.equals(resellers.getEmail(),r.getEmail()))

        {
            FormatValidation.emailFormatValidation(r.getEmail());

            Optional<Resellers> cBeanOptional = resellerRepo.findByEmail(r.getEmail());
            if(cBeanOptional.isPresent())
            {
                throw new ResourceNotFoundException(ConstantMessage.WARNING_EMAIL_EXIST);
            }
            resellers.setEmail(r.getEmail());
        }

        if(r.getAddressLine() != null
                && !Objects.equals(resellers.getAddressLine(),r.getAddressLine())
                && !r.getAddressLine().equals(""))
        {
            resellers.setAddressLine(r.getAddressLine());
        }

        if(r.getPhoneNumber() != null &&
                r.getPhoneNumber().length()>0 &&
                !Objects.equals(resellers.getPhoneNumber(),r.getPhoneNumber())){

            FormatValidation.phoneNumberFormatValidation(r.getPhoneNumber());
            resellers.setPhoneNumber(r.getPhoneNumber());
        }

        if (r.getBusinessType() != null
            && !Objects.equals(resellers.getBusinessType(),r.getBusinessType())
                && !r.getBusinessType().equals("")){
            resellers.setBusinessType(r.getBusinessType());
        }
    }

    public void updateResellerByIdV2(Resellers r) throws Exception {
        Resellers resellers = resellerRepo.findById(r.getId()).orElseThrow(() -> new ResourceNotFoundException(ConstantMessage.WARNING_CUSTOMER_NOT_FOUND));

        resellers.setModifiedBy("1");
        resellers.setModifiedDate(new Date());

        if(r.getResellerName() != null && !Objects.equals(resellers.getResellerName(),r.getResellerName()) && !r.getResellerName().equals(""))
        {
            resellers.setResellerName(r.getResellerName());
        }

        if(r.getEmail() != null &&
                r.getEmail().length()>0 &&
                !Objects.equals(resellers.getEmail(),r.getEmail()))

        {
            FormatValidation.emailFormatValidation(r.getEmail());

            Optional<Resellers> cBeanOptional = resellerRepo.findByEmail(r.getEmail());
            if(cBeanOptional.isPresent())
            {
                throw new ResourceNotFoundException(ConstantMessage.WARNING_EMAIL_EXIST);
            }
            resellers.setEmail(r.getEmail());
        }

        if(r.getAddressLine() != null
                && !Objects.equals(resellers.getAddressLine(),r.getAddressLine())
                && !r.getAddressLine().equals(""))
        {
            resellers.setAddressLine(r.getAddressLine());
        }

        if(r.getPhoneNumber() != null &&
                r.getPhoneNumber().length()>0 &&
                !Objects.equals(resellers.getPhoneNumber(),r.getPhoneNumber())){

            FormatValidation.phoneNumberFormatValidation(r.getPhoneNumber());
            resellers.setPhoneNumber(r.getPhoneNumber());
        }

        if (r.getBusinessType() != null
                && !Objects.equals(resellers.getBusinessType(),r.getBusinessType())
                && !r.getBusinessType().equals("")){
            resellers.setBusinessType(r.getBusinessType());
        }

    }

    public Resellers findByResellerName(String resellerName) throws Exception {
        List<Resellers> lsTest = resellerRepo.searchByResellerNameStartsWith(resellerName);
        return resellerRepo.findByResellerName(resellerName).orElseThrow(()->
                new ResourceNotFoundException(ConstantMessage.WARNING_PRODUCT_NOT_FOUND));

    }

    public List<Resellers> findResellerNameNotLikes(String resellerName)
    {
        return resellerRepo.findByResellerNameNotLike(resellerName);
    }

    public List<Resellers> findResellerNameLikes(String resellerName)
    {
        return resellerRepo.findByResellerNameLike(resellerName);
    }

    public List<Resellers> findResellerNameEndWith(String resellerName)
    {
        return resellerRepo.searchByResellerNameStartsWith(resellerName);
    }

    public List<Resellers> findResellerNameStartWith(String resellerName)
    {
        return resellerRepo.searchByResellerNameEndsWith(resellerName);
    }

    @Transactional(rollbackFor = {Exception.class})
    public void saveAllResellers(List<Resellers> ls ) {
        resellerRepo.saveAll(ls);
    }
}
