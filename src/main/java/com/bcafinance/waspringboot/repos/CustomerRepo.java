package com.bcafinance.waspringboot.repos;

import com.bcafinance.waspringboot.models.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CustomerRepo extends JpaRepository<Customers,Long> {

    Optional<Customers> findByEmail(String email);
}
