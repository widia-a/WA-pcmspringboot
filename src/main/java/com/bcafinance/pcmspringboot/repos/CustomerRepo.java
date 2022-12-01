package com.bcafinance.pcmspringboot.repos;

import com.bcafinance.pcmspringboot.models.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CustomerRepo extends JpaRepository<Customers,Long> {

    Optional<Customers> findByEmail(String email);
}
