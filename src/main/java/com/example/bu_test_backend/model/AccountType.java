package com.example.bu_test_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "account_type")
public class AccountType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_type_id")
    private Integer accountTypeId;

    @Column(name = "account_type_name", length = 20, nullable = false)
    private String accountTypeName;

    public AccountType() {}
    
    public Integer getAccountTypeId() {
        return accountTypeId;
    }
    public void setAccountTypeId(Integer accountTypeId) {
        this.accountTypeId = accountTypeId;
    }
    public String getAccountTypeName() {
        return accountTypeName;
    }
    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }
    
    @Override
    public String toString() {
        return "AccountType [accountTypeId=" + accountTypeId + ", accountTypeName=" + accountTypeName + "]";
    }

    
}
