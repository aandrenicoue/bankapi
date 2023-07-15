package com.self.bankapi.Services;

import com.self.bankapi.Model.Account;
import com.self.bankapi.Repositories.AccountRepository;
import com.self.bankapi.Responses.AccountResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{
    private final AccountRepository accountRepository;
    @Override
    public List<AccountResponse> getAccountInfo(String custNo) {

        //Recuperer la liste des comptes
        List<Account> accounts =  accountRepository.getAccountByCustNo(custNo);

        //Transformer les accountsList en accountResponseList
        List<AccountResponse> accountResponses = accounts.stream().map(account -> {
           //Transformer les account en accountResponse
            AccountResponse accountResponse = AccountResponse.builder()
                    .account_type(account.getAccount_type())
                    .ccy(account.getCcy())
                    .ac_open_date(account.getAc_open_date())
                    .rib_key(account.getRib_key())
                    .ac_desc(account.getAc_desc())
                    .acy_val_bal(account.getAcy_val_bal())
                    .build();
            return accountResponse;
        })
        .collect(Collectors.toList());

        return  accountResponses;

    }
}
