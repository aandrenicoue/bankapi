package com.self.bankapi.Responses;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponse {
    private String unique_id_name;
    private String country;
    private String branch_code;
    private String officer_name;
    private String customer_type;
    private String customer_name;
    private String city;
}
