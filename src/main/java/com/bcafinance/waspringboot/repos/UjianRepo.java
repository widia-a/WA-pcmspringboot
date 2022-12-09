package com.bcafinance.waspringboot.repos;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 09/12/2022 14:20
Last modified on 14:20
Version 1.0
*/


import com.bcafinance.waspringboot.models.UjianAkhir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UjianRepo extends JpaRepository<UjianAkhir, Long> {

    @Modifying
    @Query(
            value =
                    "INSERT INTO UjianAkhir (Jumlah, Harga, Nama)" +
                            " VALUES (:Jumlah, :Harga, :Nama)",
            nativeQuery = true)
    void insertQuery(
            @Param("Jumlah") Integer jumlah,
            @Param("Harga") Double harga,
            @Param("Nama") String nama
    );

}
