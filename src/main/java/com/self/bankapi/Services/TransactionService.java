package com.self.bankapi.Services;

import com.self.bankapi.Model.Account;
import com.self.bankapi.Model.Transaction;
import com.self.bankapi.Requests.DoTrnRequest;
import com.self.bankapi.Responses.ApiResponse;
import com.self.bankapi.Responses.GetTrnResponse;
import org.springframework.data.domain.Pageable;

public interface TransactionService {
    ApiResponse doLocalTransfer (DoTrnRequest doTrnRequest);

     Transaction doTransferToBeneficiary(Account account, Account drAccount, Integer amount,String description);

    GetTrnResponse getStatement (String acNo, Pageable pageable);


}
