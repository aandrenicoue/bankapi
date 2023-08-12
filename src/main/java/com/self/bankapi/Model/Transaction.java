package com.self.bankapi.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Transaction {
    @Id
    @Column(name = "trn_ref_no")
    private String trnRefNo;
    private Instant trn_dt;
    private Instant book_dt;
    private String trn_ccy;
    @Column(name = "ac_no")
    private String acNo;
    private String dr_ac_no;
    private Integer amount;
    private String description;
    private TranactionStatut trn_st;


}
