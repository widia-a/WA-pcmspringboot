package com.bcafinance.waspringboot.services;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 09/12/2022 14:21
Last modified on 14:21
Version 1.0
*/

import com.bcafinance.waspringboot.models.UjianAkhir;
import com.bcafinance.waspringboot.repos.UjianRepo;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class UjianService {

    @Getter
    private UjianRepo ujianRepo;

    @Autowired
    public UjianService(UjianRepo ujianRepo){this.ujianRepo = ujianRepo;}


    @Transactional(rollbackFor = {Exception.class, SQLException.class})
    public void saveUjianQuery(UjianAkhir ujianAkhir) {
        ujianRepo.insertQuery(ujianAkhir.getJumlah(),ujianAkhir.getHarga(), ujianAkhir.getNama());
    }

    @Transactional(rollbackFor = {Exception.class})
    public void saveAlls(List<UjianAkhir> lsUji) {
        ujianRepo.saveAll(lsUji);
    }

    public Iterable<UjianAkhir> pagingFindAll(Pageable pageable) {
            return ujianRepo.findAll(pageable);
    }
}
