package com.self.bankapi.Services;

import com.self.bankapi.Model.Customer;
import com.self.bankapi.Repositories.CustomerRepository;
import com.self.bankapi.Responses.CustomerResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private final CustomerRepository customerRepository;
    @Override
    public CustomerResponse getCustomerInfo(String cust_no) {

      Customer  customer =  customerRepository.findByCustNo(cust_no);
        if(customer == null){
            throw new EntityNotFoundException("Customer not found");
        }
      CustomerResponse customerResponse = CustomerResponse.builder()
              .custNo(customer.getCustNo())
              .customer_type(customer.getCustomer_type())
              .customer_name(customer.getCustomer_name())
              .city(customer.getCity())
              .country(customer.getCountry())
              .branch_code(customer.getBranch_code())
              .officer_name(customer.getOfficer_name())
              .build();

      return  customerResponse;

    }
}
