package com.self.bankapi.Repositories;

import com.self.bankapi.Model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransactionRepository extends JpaRepository<Transaction, String> {

    //    @Query(value = "SELECT * FROM TRANSACTIONS WHERE (ac_n0 = ?1 OR dr_ac_no = ?1 ) ORDER BY trn_dt DESC LIMIT ?2  OFFSET ?3", nativeQuery = true)
    //    List<Transaction> findByCustNo(String cust_no,Integer limit,Integer offset);

    @Query(value = "SELECT * FROM TRANSACTION WHERE (ac_no = ?1 OR dr_ac_no = ?1 ) ORDER BY trn_dt DESC", nativeQuery = true)
    Page<Transaction> findByCustNo(String cust_no, Pageable pageable);


}
