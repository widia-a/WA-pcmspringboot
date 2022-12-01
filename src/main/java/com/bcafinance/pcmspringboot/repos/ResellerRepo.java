package com.bcafinance.pcmspringboot.repos;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 30/11/2022 14:11
Last modified on 14:11
Version 1.0
*/


import com.bcafinance.pcmspringboot.models.Resellers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ResellerRepo extends JpaRepository<Resellers, Long> {

    Optional<Resellers> findByEmail(String email);

    Optional<Resellers> findByResellerName(String resellerName);

    List<Resellers> searchByResellerNameStartsWith(String resellerName);

    List<Resellers> findByResellerNameNotLike(String resellerName);

    List<Resellers> findByResellerNameLike(String resellerName);

    List<Resellers> searchByResellerNameEndsWith(String resellerName);
}
