package com.self.bankapi.Services;

import com.self.bankapi.Responses.AccountResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    List<AccountResponse> getAccountInfo(String cust_no);
}
