package com.self.bankapi.Repositories;

import com.self.bankapi.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
         Customer findByCustNo(String cust_no);

     Customer findByCountry (String country);
}
