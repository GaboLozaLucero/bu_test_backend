package com.example.bu_test_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.bu_test_backend.model.Account;

@Repository
public interface AccountDao extends JpaRepository<Account, Integer>{
    List<Account> findByClient_ClientId(String clientId);   //to find all accounts by clientId
    List<Account> findByAccountType_AccountTypeId(Integer accountTypeId);   //to find all accounts by accountTypeId if necessary
}
