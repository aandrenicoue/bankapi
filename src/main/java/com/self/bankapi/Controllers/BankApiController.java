package com.self.bankapi.Controllers;

import com.self.bankapi.Model.Account;
import com.self.bankapi.Model.Customer;
import com.self.bankapi.Repositories.CustomerRepository;
import com.self.bankapi.Requests.AccountRequest;
import com.self.bankapi.Requests.CustomerRequest;
import com.self.bankapi.Responses.AccountResponse;
import com.self.bankapi.Responses.CustomerResponse;
import com.self.bankapi.Services.AccountService;
import com.self.bankapi.Services.CustomerService;
import com.self.bankapi.Services.CustomerServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
@Validated
public class BankApiController {
    private CustomerService customerService;
    private AccountService accountService;

    @GetMapping("/customer")
    public ResponseEntity<CustomerResponse> getCustomerInfo( @RequestBody @Valid CustomerRequest cust_no){

        CustomerResponse customerResponse = customerService.getCustomerInfo(cust_no.getCustNo());
        return   ResponseEntity.ok(customerResponse);
    }

    @GetMapping("/customer/accounts")
    public ResponseEntity<List<AccountResponse>> getAccountInfo(@RequestBody AccountRequest cust_no){
        List<AccountResponse> account = accountService.getAccountInfo(cust_no.getCustNo());

        return ResponseEntity.ok(account);
    }

}
