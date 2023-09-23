package com.example.repository;

import com.example.entity.Account;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<Account, Integer>{
    
    boolean existsByUsername(@Param("username") String username);
    Optional<Account> findByUsername(@Param("username") String username);
}
