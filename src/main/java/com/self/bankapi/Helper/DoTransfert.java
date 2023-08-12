package com.self.bankapi.Helper;

import com.self.bankapi.Exception.InsufficientFundsException;
import com.self.bankapi.Model.Account;
import com.self.bankapi.Model.TranactionStatut;
import com.self.bankapi.Repositories.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Transactional
@Component
public class DoTransfert {
    @Autowired
    private Global globalHelper;
    @Autowired
    private AccountRepository accountRepository;

    public TranactionStatut doTransferToBeneficiary(String acNo, String drAcNo, Integer amount){

        //Check account

        Account account = globalHelper.checkAccount(acNo);

        //Check dr account
        Account drAccount = globalHelper.checkAccount(drAcNo);


        return TranactionStatut.PENDING;

    }

    public String genRefNo (){

        LocalDateTime now = LocalDateTime.now();
        String formattedDate = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));


        return formattedDate ;
    }
}
