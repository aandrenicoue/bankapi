package com.self.bankapi.Responses;

import com.self.bankapi.Model.CustomerType;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponse {
    private String custNo;

    private String unique_id_name;
    private String country;
    private String branch_code;
    private String officer_name;
    private CustomerType customer_type;
    private String customer_name;
    private String city;
}
