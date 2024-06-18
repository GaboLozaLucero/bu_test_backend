package com.example.bu_test_backend.api;

import com.example.bu_test_backend.bl.AccountBl;
// import com.example.bu_test_backend.bl.ClientBl;
// import com.example.bu_test_backend.dao.AccountDao;
// import com.example.bu_test_backend.dao.ClientDao;
import com.example.bu_test_backend.dto.AccountDto;
// import com.example.bu_test_backend.dto.ClientDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/v1/client/accounts")
public class AccountApi {

    private AccountBl accountBl;

    @Autowired
    public AccountApi(AccountBl accountBl){
        this.accountBl=accountBl;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/{clientId}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AccountDto> getAllAccountByClientDtos(HttpServletRequest request, @PathVariable String clientId) {
        return accountBl.getAccountsByClientId(clientId);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AccountDto creAccountDto(@RequestBody @Valid AccountDto accountDto){
        return accountBl.createAccount(accountDto);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{accountId}")
    public void deleteAccount(@PathVariable Integer accountId){
        accountBl.deleteAccount(accountId);
    }

    @RequestMapping(method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public AccountDto updateAccount(@RequestBody @Valid AccountDto accountDto, HttpServletRequest request){
        AccountDto accountDtoResponse = accountBl.updateAccount(accountDto);
        return accountDtoResponse;
    }
}
