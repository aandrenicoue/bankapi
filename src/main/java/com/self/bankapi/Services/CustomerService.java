package com.self.bankapi.Services;

import com.self.bankapi.Model.Customer;
import com.self.bankapi.Responses.CustomerResponse;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    CustomerResponse getCustomerInfo(String cust_no);
}
