package com.self.bankapi.Helper;

import com.self.bankapi.Repositories.AccountRepository;
import com.self.bankapi.Repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GenerateCustNo {
    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;
    public String custNoNumber (){
        Long number =   customerRepository.count();
        return  String.format("%04d", ++ number );
    }

}
