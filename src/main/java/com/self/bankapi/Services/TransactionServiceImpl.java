package com.self.bankapi.Services;

import com.self.bankapi.Exception.InsufficientFundsException;
import com.self.bankapi.Helper.DoTransfert;
import com.self.bankapi.Helper.Global;
import com.self.bankapi.Model.Account;
import com.self.bankapi.Model.TranactionStatut;
import com.self.bankapi.Model.Transaction;
import com.self.bankapi.Repositories.TransactionRepository;
import com.self.bankapi.Requests.DoTrnRequest;
import com.self.bankapi.Responses.ApiResponse;
import com.self.bankapi.Responses.GetTrnResponse;
import com.self.bankapi.Responses.ResponseHandler;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Transactional
@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService{

    private final Global global;
    private final DoTransfert doTransfert;

    private final TransactionRepository transactionRepository;
    private  final ResponseHandler responseHandler;
    public ApiResponse doLocalTransfer(DoTrnRequest doTrnRequest) {

        Account account = global.checkAccount(doTrnRequest.getAcNo());

        if (account == null) throw  new EntityNotFoundException("Invalid destination account");

        Account drAccount = global.checkAccount(doTrnRequest.getDr_ac_no());

        if (drAccount == null) throw  new EntityNotFoundException("Invalid source account");

        //Check account and balance
        TranactionStatut status = doTransfert.doTransferToBeneficiary(account.getCustAcNo(), drAccount.getCustAcNo() ,doTrnRequest.getAmount());
        System.out.println(status);

        //Save transaction
        Transaction transaction = new Transaction();
        transaction.setAcNo(account.getCustAcNo());
        transaction.setDr_ac_no(drAccount.getCustAcNo());
        transaction.setTrn_dt(Instant.now());
        transaction.setBook_dt(Instant.now());
        transaction.setDescription(doTrnRequest.getDescription());
        transaction.setAmount(doTrnRequest.getAmount());
        transaction.setTrn_ccy(doTrnRequest.getTrn_ccy());
        transaction.setTrn_st(status);
        transaction.setTrnRefNo(doTransfert.genRefNo());

        // Check dr balance
        if (drAccount.getAcy_val_bal() < doTrnRequest.getAmount()){
            transaction.setTrn_st(TranactionStatut.FAILED);
            throw new InsufficientFundsException("Withdrawal amount exceeds the account balance.");
        }

        //Update account and dr account balance
        account.setAcy_val_bal(account.getAcy_val_bal() + doTrnRequest.getAmount());
        drAccount.setAcy_val_bal(drAccount.getAcy_val_bal() + doTrnRequest.getAmount());

        transaction.setTrn_st(TranactionStatut.DONE);

        transactionRepository.save(transaction);

        return new ApiResponse(Boolean.TRUE,"success",200,transaction);

    }

    @Override
    public Transaction doTransferToBeneficiary(Account account, Account drAccount, Integer amount,String description) {
        return null;
    }

    @Override
    public GetTrnResponse getStatement(String acNo, Pageable pageable) {
        Page<Transaction> transactions = transactionRepository.findByCustNo(acNo,pageable);

        return  new GetTrnResponse().builder()
                .transactions(transactions.getContent())
                .total(transactions.getTotalPages())
                .currentPage(transactions.getNumber())
                .build();
    }


}
