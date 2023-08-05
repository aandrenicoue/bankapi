package com.self.bankapi.Dataseeder;

import com.github.javafaker.Faker;
import com.self.bankapi.Helper.GenerateCustNo;
import com.self.bankapi.Model.Account;
import com.self.bankapi.Model.AccountType;
import com.self.bankapi.Model.Customer;
import com.self.bankapi.Model.CustomerType;
import com.self.bankapi.Repositories.AccountRepository;
import com.self.bankapi.Repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;

//@Component
public class CustomerSeeder implements CommandLineRunner {
    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;
    private  final GenerateCustNo generateCustNo;

    private final Faker faker;

    @Autowired
    public CustomerSeeder(CustomerRepository customerRepository, Faker faker,GenerateCustNo generateCustNo,AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
        this.generateCustNo = generateCustNo;
        this.faker = faker;
    }


    @Override
    @Scheduled(fixedRate = 1)
    public void run(String... args) {
        System.out.print("hello");
        for (int i = 0; i < 20; i++) {
            //Create customer
            Customer customer = new Customer();
            customer.setCustomer_name(faker.name().fullName());
            customer.setCustomer_type(CustomerType.CORPORATE);
            customer.setCity(faker.address().cityName());
            customer.setCountry(faker.address().country());
            customer.setBranch_code("004");
            customer.setOfficer_name(faker.name().fullName());
            customer.setCustNo(generateCustNo.custNoNumber());

            customerRepository.save(customer);

            //create account
            Account account = new Account();
            account.setAccount_type(AccountType.CURRENT);
            account.setCcy("XOF");
            account.setAc_desc(customer.getCustomer_name());
            account.setAc_open_date(Instant.now());
            account.setAcy_val_bal(50000);
            account.setRib_key(i);
            account.setBranch_code("004");
            account.setCust_ac_no(generateCustNo.accountNumber(customer.getCustNo(),i, customer.getBranch_code()));
            account.setCustNo(customer.getCustNo());

            accountRepository.save(account);

        }
        for (int i = 0; i < 20; i++) {
            Customer customer = new Customer();
            customer.setCustomer_name(faker.name().fullName());
            customer.setCustomer_type(CustomerType.INDIVIDUAL);
            customer.setCity(faker.address().cityName());
            customer.setCountry(faker.address().country());
            customer.setBranch_code("004");
            customer.setOfficer_name(faker.name().fullName());
            customer.setCustNo(generateCustNo.custNoNumber());

            customerRepository.save(customer);

            //create account
            Account account = new Account();
            account.setAccount_type(AccountType.CURRENT);
            account.setCcy("XOF");
            account.setAc_desc(customer.getCustomer_name());
            account.setAc_open_date(Instant.now());
            account.setAcy_val_bal(10000);
            account.setRib_key(i);
            account.setBranch_code("004");
            account.setCust_ac_no(generateCustNo.accountNumber(customer.getCustNo(),i, customer.getBranch_code()));
            account.setCustNo(customer.getCustNo());

            accountRepository.save(account);
        }

        for (int i = 0; i < 20; i++) {
            Customer customer = new Customer();
            customer.setCustomer_name(faker.name().fullName());
            customer.setCustomer_type(CustomerType.CORPORATE);
            customer.setCity(faker.address().cityName());
            customer.setCountry(faker.address().country());
            customer.setBranch_code("000");
            customer.setOfficer_name(faker.name().fullName());
            customer.setCustNo(generateCustNo.custNoNumber());

            customerRepository.save(customer);

            //create account
            Account account = new Account();
            account.setAccount_type(AccountType.CURRENT);
            account.setCcy("XOF");
            account.setAc_desc(customer.getCustomer_name());
            account.setAc_open_date(Instant.now());
            account.setAcy_val_bal(900000);
            account.setRib_key(i);
            account.setBranch_code("000");
            account.setCust_ac_no(generateCustNo.accountNumber(customer.getCustNo(),i, customer.getBranch_code()));
            account.setCustNo(customer.getCustNo());

            accountRepository.save(account);
        }

        for (int i = 0; i < 20; i++) {
            Customer customer = new Customer();
            customer.setCustomer_name(faker.name().fullName());
            customer.setCustomer_type(CustomerType.INDIVIDUAL);
            customer.setCity(faker.address().cityName());
            customer.setCountry(faker.address().country());
            customer.setBranch_code("000");
            customer.setOfficer_name(faker.name().fullName());
            customer.setCustNo(generateCustNo.custNoNumber());

            customerRepository.save(customer);

            //create account
            Account account = new Account();
            account.setAccount_type(AccountType.CURRENT);
            account.setCcy("XOF");
            account.setAc_desc(customer.getCustomer_name());
            account.setAc_open_date(Instant.now());
            account.setAcy_val_bal(1100000);
            account.setRib_key(i);
            account.setBranch_code("000");
            account.setCust_ac_no(generateCustNo.accountNumber(customer.getCustNo(),i, customer.getBranch_code()));
            account.setCustNo(customer.getCustNo());

            accountRepository.save(account);
        }
    }
}
