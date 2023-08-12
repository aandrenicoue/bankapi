package com.self.bankapi.Helper;

import com.self.bankapi.Repositories.AccountRepository;
import com.self.bankapi.Repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@Component
public class GenerateCustNo {
    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;
    public String custNoNumber (){
        Long number =   customerRepository.count();
        return  String.format("%04d", ++ number );
    }
    public String accountNumber (String cust_no,int rib,String branch_code){

        LocalDateTime now = LocalDateTime.now();
        String formattedDate = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));


        return formattedDate + cust_no + rib;
    }


}
