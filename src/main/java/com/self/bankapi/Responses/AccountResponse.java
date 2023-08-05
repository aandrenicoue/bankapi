package com.self.bankapi.Responses;

import com.self.bankapi.Model.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountResponse {
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
