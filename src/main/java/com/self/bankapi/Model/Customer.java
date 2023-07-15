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
public class Customer {

    @Id
    @Column(name = "cust_no")
    private String custNo;
    private String unique_id_name;
    private String country;
    private String branch_code;
    private String officer_name;
    private String customer_type;
    private String customer_name;
    private String city;
}
