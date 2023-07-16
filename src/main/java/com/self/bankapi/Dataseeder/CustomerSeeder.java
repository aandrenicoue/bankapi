package com.self.bankapi.Dataseeder;

import com.github.javafaker.Faker;
import com.self.bankapi.Helper.GenerateCustNo;
import com.self.bankapi.Model.Customer;
import com.self.bankapi.Repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomerSeeder implements CommandLineRunner {
    private final CustomerRepository customerRepository;
    private  final GenerateCustNo generateCustNo;

    private final Faker faker;

    @Autowired
    public CustomerSeeder(CustomerRepository customerRepository, Faker faker,GenerateCustNo generateCustNo) {
        this.customerRepository = customerRepository;
        this.generateCustNo = generateCustNo;
        this.faker = faker;
    }


    @Override
    public void run(String... args) {
        System.out.print("hello");
        for (int i = 0; i < 20; i++) {
            Customer customer = new Customer();
            customer.setCustomer_name(faker.name().fullName());
            customer.setCustomer_type("C");
            customer.setCity(faker.address().cityName());
            customer.setCountry(faker.address().country());
            customer.setBranch_code("004");
            customer.setOfficer_name(faker.name().fullName());
            customer.setCustNo(generateCustNo.custNoNumber());

            customerRepository.save(customer);
        }
        for (int i = 0; i < 20; i++) {
            Customer customer = new Customer();
            customer.setCustomer_name(faker.name().fullName());
            customer.setCustomer_type("S");
            customer.setCity(faker.address().cityName());
            customer.setCountry(faker.address().country());
            customer.setBranch_code("004");
            customer.setOfficer_name(faker.name().fullName());
            customer.setCustNo(generateCustNo.custNoNumber());

            customerRepository.save(customer);
        }

        for (int i = 0; i < 20; i++) {
            Customer customer = new Customer();
            customer.setCustomer_name(faker.name().fullName());
            customer.setCustomer_type("S");
            customer.setCity(faker.address().cityName());
            customer.setCountry(faker.address().country());
            customer.setBranch_code("000");
            customer.setOfficer_name(faker.name().fullName());
            customer.setCustNo(generateCustNo.custNoNumber());

            customerRepository.save(customer);
        }

        for (int i = 0; i < 20; i++) {
            Customer customer = new Customer();
            customer.setCustomer_name(faker.name().fullName());
            customer.setCustomer_type("C");
            customer.setCity(faker.address().cityName());
            customer.setCountry(faker.address().country());
            customer.setBranch_code("000");
            customer.setOfficer_name(faker.name().fullName());
            customer.setCustNo(generateCustNo.custNoNumber());

            customerRepository.save(customer);
        }
    }
}
