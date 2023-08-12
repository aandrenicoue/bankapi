package com.self.bankapi.Requests;

import com.self.bankapi.Model.TranactionStatut;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoTrnRequest {
    private String trn_ccy;
    private String acNo;
    private String dr_ac_no;
    private Integer amount;
    private String description;
}
