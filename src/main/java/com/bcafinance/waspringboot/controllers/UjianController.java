package com.bcafinance.waspringboot.controllers;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 09/12/2022 14:22
Last modified on 14:22
Version 1.0
*/

import com.bcafinance.waspringboot.handler.ResourceNotFoundException;
import com.bcafinance.waspringboot.handler.ResponseHandler;
import com.bcafinance.waspringboot.models.UjianAkhir;
import com.bcafinance.waspringboot.services.UjianService;
import com.bcafinance.waspringboot.utils.ConstantMessage;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/")
public class UjianController {

    @Getter
    private UjianService ujianService;

//    @Autowired
//    private ModelMapper modelMapper;

    private List<UjianAkhir> lsuji = new ArrayList<UjianAkhir>();

    @Autowired
    public UjianController(UjianService ujianService){
        this.ujianService = ujianService;
    }

    @PostMapping("/v1/ujian/insert")
    public ResponseEntity<Object> saveInsertQuery(@RequestBody UjianAkhir ujianAkhir)throws Exception{
        ujianService.saveUjianQuery(ujianAkhir);
        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_INSERT_QUERY, HttpStatus.OK,null,null,null);
    }

    @PostMapping("/v1/ujian/savebat")
    public ResponseEntity<Object>
    saveAllDatas(@RequestBody List<UjianAkhir> ujianAkhirs) throws Exception {

        if(ujianAkhirs==null)throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        ujianService.saveAlls(ujianAkhirs);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,null,null,null);
    }

    @GetMapping("/v1/search/{size}/{page}")
    public ResponseEntity<Object> pageFindAll(
             @PathVariable("size") int size, @PathVariable("page") int page
    ) throws Exception{
        Pageable pageable = PageRequest.of(page, size);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,ujianService.pagingFindAll(pageable), null, null);
    }
}
