package com.self.bankapi.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String account_type;
    private String ac_desc;
    private String ccy;
    private String branch_code;
    private String rib_key;
    private String ac_open_date;
    private String acy_val_bal;
    private String record_stat;
}
