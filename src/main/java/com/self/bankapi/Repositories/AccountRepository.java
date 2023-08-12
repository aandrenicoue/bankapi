package com.self.bankapi.Repositories;

import com.self.bankapi.Model.Account;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {
    List<Account> getAccountByCustNo(String custNo);

    Account findByCustAcNo(String acNo);
}
