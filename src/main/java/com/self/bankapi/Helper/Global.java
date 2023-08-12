package com.self.bankapi.Helper;

import com.self.bankapi.Model.Account;
import com.self.bankapi.Repositories.AccountRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class Global {

    private final AccountRepository accountRepository;

    public Account checkAccount(String ac_no) {
        //get Account
        Account account = accountRepository.findByCustAcNo(ac_no);

        if (account == null) {
            throw new EntityNotFoundException("invalid account");
        }

        return account;
    }


}
