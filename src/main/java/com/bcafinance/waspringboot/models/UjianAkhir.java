package com.bcafinance.waspringboot.models;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 09/12/2022 14:18
Last modified on 14:18
Version 1.0
*/


import com.bcafinance.waspringboot.utils.ConstantMessage;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "UjianAkhir")

public class UjianAkhir implements Serializable {

    private static final long serialversionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull(message = ConstantMessage.ERROR_TIDAK_BOLEH_KOSONG_VAR_1) //"VARIABEL 1 WAJIB DIISI" (PINDAHKAN PESAN KE ConstantMessage)
    @Column(name = "Jumlah" ,nullable = false)
    private Integer jumlah;

    @NotNull(message = ConstantMessage.ERROR_TIDAK_BOLEH_KOSONG_VAR_2)//"VARIABEL 2 WAJIB DIISI" (PINDAHKAN PESAN KE ConstantMessage)
    @Column(name = "Harga" ,nullable = false)
    private Double harga;

    @NotEmpty(message = ConstantMessage.ERROR_TIDAK_BOLEH_KOSONG_VAR_3)//"VARIABEL 3 WAJIB DIISI" (PINDAHKAN PESAN KE class ConstantMessage)
    @Column(name = "Nama",nullable = false)
    private String nama ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public Double getHarga() {
        return harga;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
