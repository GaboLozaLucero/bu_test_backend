package com.example.bu_test_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.bu_test_backend.model.Coin;

@Repository
public interface CoinDao extends JpaRepository<Coin, Integer>{
    
}
