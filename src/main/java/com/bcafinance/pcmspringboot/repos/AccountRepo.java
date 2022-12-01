package com.bcafinance.pcmspringboot.repos;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 01/12/2022 15:17
Last modified on 15:17
Version 1.0
*/


import com.bcafinance.pcmspringboot.models.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepo extends JpaRepository<Accounts, Long> {
    Optional<Accounts> findByAccountName(String accountName);

    List<Accounts> searchByAccountName(String accountName);
}
