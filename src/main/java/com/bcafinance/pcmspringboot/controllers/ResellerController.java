package com.bcafinance.pcmspringboot.controllers;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 30/11/2022 14:21
Last modified on 14:21
Version 1.0
*/

import com.bcafinance.pcmspringboot.handler.ResourceNotFoundException;
import com.bcafinance.pcmspringboot.handler.ResponseHandler;
import com.bcafinance.pcmspringboot.models.Customers;
import com.bcafinance.pcmspringboot.models.Resellers;
import com.bcafinance.pcmspringboot.services.ResellerService;
import com.bcafinance.pcmspringboot.utils.ConstantMessage;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class ResellerController {

    @Getter
    private ResellerService resellerService;

    public ResellerController(){

    }

    @Autowired
    public ResellerController(ResellerService resellerService) {
    this.resellerService = resellerService;
    }

    @PostMapping("/v1/resellers")
    public ResponseEntity<Object>
    saveReseller(@RequestBody Resellers resellers) throws Exception{
        if (resellers==null) throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        resellerService.saveResellers(resellers);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED, null, null, null);
    }

    @GetMapping("/v1/resellers/{id}")
    public ResponseEntity<Object> getResellersById(@PathVariable("id") long id) throws Exception{
        Resellers resellers = resellerService.findByResellerId(id);

        if (resellers != null){
            return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK, resellers, null, null);
        }
        else {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_NOT_FOUND);
        }
    }

    @GetMapping("/v1/resellers/datas/all/0")
    public ResponseEntity<Object> findAllResellers() throws Exception{
        int data = 0;
        List<Resellers> lsResellers = resellerService.findAllResellers();

        if (lsResellers.size()==0){
            throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
        }

        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK ,lsResellers, null, null);
    }

    @PutMapping("/v1/resellers/t")
    public ResponseEntity<Object> updateResellerById(@RequestBody Resellers resellers) throws Exception{
        resellerService.updateResellerById(resellers);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,null,null,null);
    }

    @PutMapping("/v2/resellers/t")
    public ResponseEntity<Object> updateResellerByIDV2(@RequestBody Resellers resellers)throws Exception{
        resellerService.updateResellerByIdV2(resellers);
        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,"",null,null);
    }

    @GetMapping("/resellers/datas/search/{resellerName}")
    public ResponseEntity<Object> getResellerByResellerName(@PathVariable("resellerName") String resellerName)throws Exception{
        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,resellerService.findByResellerName(resellerName),null,null);
    }

    @GetMapping("/resellers/datas/nl/{resellerName}")
    public ResponseEntity<Object> getResellersNotLike(@PathVariable("resellerName") String resellerName)throws Exception{

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,resellerService.findResellerNameNotLikes(resellerName),null,null);
    }

    @GetMapping("/resellers/datas/l/{resellerName}")
    public ResponseEntity<Object> getResellersLike(@PathVariable("resellerName") String resellerName)throws Exception{

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,resellerService.findResellerNameLikes(resellerName),null,null);
    }

    @GetMapping("/resellers/datas/s/{resellerName}")
    public ResponseEntity<Object> getResellerNamesEndWith(@PathVariable("resellerName") String resellerName)throws Exception{

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,resellerService.findResellerNameEndWith(resellerName),null,null);
    }

    @GetMapping("/resellers/datas/e/{resellerName}")
    public ResponseEntity<Object> getResellerNamesStartWith(@PathVariable("resellerName") String resellerName) throws Exception{

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,resellerService.findResellerNameStartWith(resellerName),null,null);
    }

    @PostMapping("/resellers/bat")
    public ResponseEntity<Object>
    saveAllResellers(@RequestBody List<Resellers> resellers) throws Exception {

        if(resellers==null)throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        resellerService.saveAllResellers(resellers);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,null,null,null);
    }


}

