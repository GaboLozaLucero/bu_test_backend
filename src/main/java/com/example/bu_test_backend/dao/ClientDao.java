package com.example.bu_test_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bu_test_backend.model.Client;

@Repository
public interface ClientDao extends JpaRepository<Client, String>{
    
}
