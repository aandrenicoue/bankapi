package com.self.bankapi.Responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountResponse {
    private String account_type;
    private String ac_desc;
    private String ccy;
    private String branch_code;
    private String rib_key;
    private String ac_open_date;
    private String acy_val_bal;
    private String record_stat;
}
