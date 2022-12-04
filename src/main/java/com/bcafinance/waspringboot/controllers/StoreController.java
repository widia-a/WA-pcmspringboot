package com.bcafinance.waspringboot.controllers;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 04/12/2022 21:11
Last modified on 21:11
Version 1.0
*/

import com.bcafinance.waspringboot.handler.ResourceNotFoundException;
import com.bcafinance.waspringboot.handler.ResponseHandler;
import com.bcafinance.waspringboot.models.Stores;
import com.bcafinance.waspringboot.services.StoreService;
import com.bcafinance.waspringboot.utils.ConstantMessage;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/")
public class StoreController {
    @Getter
    private StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService){
        this.storeService = storeService;
    }

    @PostMapping("v1/stores")
    public ResponseEntity<Object>
    saveStore(@Valid @RequestBody Stores stores) throws Exception{
        storeService.saveStores(stores);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED, null, null, null);
    }

    @PostMapping("/stores/btch")
    public ResponseEntity<Object>
    saveAllStores(@RequestBody List<Stores> stores,
                    @RequestHeader Map<String,String> headers,
                    @RequestParam Map<String,String> params,
                    WebRequest request, Error error) throws Exception {

        if(stores==null)throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        storeService.saveAllStores(stores);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,null,null,null);
    }

    @PutMapping("/stores/updt")
    public ResponseEntity<Object> updateStoreById(@RequestBody Stores stores,
                                                    @RequestHeader Map<String,String> headers,
                                                    @RequestParam Map<String,String> params,
                                                    WebRequest request, Error error) throws Exception{
        storeService.updateStoreById(stores);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,null,null,null);
    }

    @GetMapping("/stores/datas/l/{storeName}")
    public ResponseEntity<Object> getStoreNameLike(@PathVariable("storeName") String storeName)throws Exception{

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,storeService.findStoreNameLikes(storeName),null,null);
    }

    @GetMapping("/stores/{StoreId}")
    public ResponseEntity<Object> getStoreById(@PathVariable("storeId") long storeId) throws Exception {
        Stores stores = storeService.findByStoresId(storeId);

        if(stores != null)
        {
            return new ResponseHandler().
                    generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK,stores,null,null);
        }
        else
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_NOT_FOUND);
        }
    }

    @GetMapping("stores/datas/all/0")
    public ResponseEntity<Object> findAllStores() throws Exception{
        List<Stores> lsStores = storeService.findAllStore();

        if (lsStores.size()==0){
            throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
        }

        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK ,lsStores, null, null);
    }
}
