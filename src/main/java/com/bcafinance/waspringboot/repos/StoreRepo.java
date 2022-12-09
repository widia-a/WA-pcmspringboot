package com.bcafinance.waspringboot.repos;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 04/12/2022 21:11
Last modified on 21:11
Version 1.0
*/


import com.bcafinance.waspringboot.models.Stores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepo extends JpaRepository<Stores,Long> {
    List<Stores> findByStoreNameLike(String storeName);
}
