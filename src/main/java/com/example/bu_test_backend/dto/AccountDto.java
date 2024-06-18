package com.example.bu_test_backend.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class AccountDto {
    private Integer accountId;
    private String clientId;
    private String clientName;
    private Integer accountTypeId;
    private String accountTypeName;
    private Integer coinId;
    private String coinName;
    private BigDecimal amount;
    private Timestamp createdAt;
    private Integer branchId;
    private String branchName;

    // Default constructor
    public AccountDto() {}

    // Parameterized constructor
    public AccountDto(Integer accountId, String clientId, String clientName, Integer accountTypeId, 
                      String accountTypeName, Integer coinId, String coinName, BigDecimal amount, 
                      Timestamp createdAt, Integer branchId, String branchName) {
        this.accountId = accountId;
        this.clientId = clientId;
        this.clientName = clientName;
        this.accountTypeId = accountTypeId;
        this.accountTypeName = accountTypeName;
        this.coinId = coinId;
        this.coinName = coinName;
        this.amount = amount;
        this.createdAt = createdAt;
        this.branchId = branchId;
        this.branchName = branchName;
    }

    // Getters and Setters
    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

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

    public Integer getCoinId() {
        return coinId;
    }

    public void setCoinId(Integer coinId) {
        this.coinId = coinId;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    @Override
    public String toString() {
        return "AccountDto [accountId=" + accountId + ", clientId=" + clientId + ", clientName=" + clientName +
               ", accountTypeId=" + accountTypeId + ", accountTypeName=" + accountTypeName + ", coinId=" + coinId + 
               ", coinName=" + coinName + ", amount=" + amount + ", createdAt=" + createdAt + ", branchId=" + branchId +
               ", branchName=" + branchName + "]";
    }
}
