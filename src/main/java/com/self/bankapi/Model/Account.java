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
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @Column(name = "cust_no")
    private String custNo;
    private String cust_ac_no;
    private AccountType account_type;
    private String ac_desc;
    private String ccy;
    private String branch_code;
    private Integer rib_key;
    private Instant ac_open_date;
    private Integer acy_val_bal;
    private String record_stat;
}
