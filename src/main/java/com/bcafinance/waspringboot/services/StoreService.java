package com.bcafinance.waspringboot.services;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 04/12/2022 21:12
Last modified on 21:12
Version 1.0
*/


import com.bcafinance.waspringboot.models.Stores;
import com.bcafinance.waspringboot.repos.StoreRepo;
import com.bcafinance.waspringboot.utils.ConstantMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.ResourceAccessException;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class StoreService {
    
    private StoreRepo storeRepo;
    
    @Autowired
    public StoreService (StoreRepo storeRepo){
        this.storeRepo = storeRepo;
    }
    public void saveStores(Stores stores) throws Exception {
        storeRepo.save(stores);
    }

    @Transactional(rollbackFor = {Exception.class})
    public void saveAllStores(List<Stores> stores) {
        storeRepo.saveAll(stores);
    }

    public void updateStoreById(Stores stores) throws Exception{
        Stores stores1 =storeRepo.findById(stores.getStoreId()).orElseThrow(() ->
                new ResourceAccessException(ConstantMessage.WARNING_CUSTOMER_NOT_FOUND));
        stores.setModifiedBy("1");
        stores.setModifiedDate(new Date());
        if (stores.getStoreName() != null
                && !Objects.equals(stores.getStoreName(), stores.getStoreName())
                && !stores.getStoreName().equals(""))
        {
            stores.setStoreName(stores.getStoreName());
        }

        if (stores.getAddress() != null
                && !Objects.equals(stores.getAddress(), stores.getAddress())
                && !stores.getAddress().equals(""))
        {
            stores.setAddress(stores.getAddress());
        }
    }


    public List<Stores> findStoreNameLikes(String storeName) {
        return storeRepo.findByStoreNameLike(storeName);
    }

    public List<Stores> findAllStore() {
        return storeRepo.findAll();
    }

    public Stores findByStoresId(long storeId) throws Exception {
        return storeRepo.findById(storeId).orElseThrow(() ->
                new ResourceAccessException(ConstantMessage.WARNING_CUSTOMER_NOT_FOUND));
    }

}
