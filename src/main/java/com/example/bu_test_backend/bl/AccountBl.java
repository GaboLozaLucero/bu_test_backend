package com.example.bu_test_backend.bl;

import com.example.bu_test_backend.dao.AccountDao;
import com.example.bu_test_backend.dao.AccountTypeDao;
import com.example.bu_test_backend.dao.BranchDao;
import com.example.bu_test_backend.dao.ClientDao;
import com.example.bu_test_backend.dao.CoinDao;
import com.example.bu_test_backend.dto.AccountDto;
import com.example.bu_test_backend.model.Account;
import com.example.bu_test_backend.model.AccountType;
import com.example.bu_test_backend.model.Branch;
import com.example.bu_test_backend.model.Client;
import com.example.bu_test_backend.model.Coin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class AccountBl {

    private AccountDao accountDao;
    private ClientDao clientDao;
    private AccountTypeDao accountTypeDao;
    private CoinDao coinDao;
    private BranchDao branchDao;

    @Autowired
    public AccountBl(AccountDao accountDao, ClientDao clientDao, AccountTypeDao accountTypeDao, CoinDao coinDao, BranchDao branchDao){
        this.accountDao = accountDao;
        this.clientDao = clientDao;
        this.accountTypeDao = accountTypeDao;
        this.coinDao = coinDao;
        this.branchDao = branchDao;
    }

    public List<AccountDto> getAccountsByClientId(String clientId) {
        List<Account> accounts = accountDao.findByClient_ClientId(clientId);
        return accounts.stream()
                .map(this::mapToAccountDto)
                .collect(Collectors.toList());
    }

    public List<AccountDto> getAccountsByAccountTypeId(Integer accountTypeId) {
        List<Account> accounts = accountDao.findByAccountType_AccountTypeId(accountTypeId);
        return accounts.stream()
                .map(this::mapToAccountDto)
                .collect(Collectors.toList());
    }

    public AccountDto createAccount(AccountDto accountDto){
        //check if client exists
        Optional<Client> clientOpt = clientDao.findById(accountDto.getClientId());
        if(!clientOpt.isPresent()){
            throw new IllegalArgumentException("Client not found");
        }

        Account account = new Account();
        account.setClient(clientOpt.get());
        account.setAccountType(getAccountTypeById(accountDto.getAccountTypeId()));
        account.setCoin(getCoinById(accountDto.getCoinId()));
        account.setAmount(accountDto.getAmount());
        account.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        account.setBranch(getBranchById(accountDto.getBranchId()));

        account = accountDao.save(account);
        return mapToAccountDto(account);
    }

    // METHODS TO HELP ACCOUNT CREATION
    private AccountType getAccountTypeById(Integer accountTypeId) {
        return accountTypeDao.findById(accountTypeId)
                .orElseThrow(() -> new IllegalArgumentException("AccountType not found"));
    }

    private Coin getCoinById(Integer coinId) {
        return coinDao.findById(coinId)
                .orElseThrow(() -> new IllegalArgumentException("Coin not found"));
    }

    private Branch getBranchById(Integer branchId) {
        return branchDao.findById(branchId)
                .orElseThrow(() -> new IllegalArgumentException("Branch not found"));
    }

    public void deleteAccount(Integer accountId){
        accountDao.deleteById(accountId);
    }

    public AccountDto updateAccount(AccountDto updatedAccountDto) {
        // Retrieve the existing account entity from the database
        Account existingAccount = accountDao.findById(updatedAccountDto.getAccountId())
                                .orElseThrow(() -> new IllegalArgumentException("Account not found"));

        // Update the properties of the existing account
        // Also check that all attributes exist
        existingAccount.setClient(clientDao.findById(updatedAccountDto.getClientId())
                                .orElseThrow(() -> new IllegalArgumentException("Client not found")));
        existingAccount.setAccountType(accountTypeDao.findById(updatedAccountDto.getAccountTypeId())
                                        .orElseThrow(() -> new IllegalArgumentException("AccountType not found")));
        existingAccount.setCoin(coinDao.findById(updatedAccountDto.getCoinId())
                                .orElseThrow(() -> new IllegalArgumentException("Coin not found")));
        existingAccount.setAmount(updatedAccountDto.getAmount());
        existingAccount.setCreatedAt(existingAccount.getCreatedAt());
        existingAccount.setBranch(branchDao.findById(updatedAccountDto.getBranchId())
                                    .orElseThrow(() -> new IllegalArgumentException("Branch not found")));

        Account savedAccount = accountDao.save(existingAccount);
        return mapToAccountDto(savedAccount);
    }
    
    private AccountDto mapToAccountDto(Account account) {
        // Method 2 to create an Account Object
        return new AccountDto(
            account.getAccountId(),
            account.getClient().getClientId(),
            account.getClient().getClientName(),
            account.getAccountType().getAccountTypeId(),
            account.getAccountType().getAccountTypeName(),
            account.getCoin().getCoinId(),
            account.getCoin().getCoinName(),
            account.getAmount(),
            account.getCreatedAt(),
            account.getBranch().getBranchId(),
            account.getBranch().getBranchName()
        );
    }
}
