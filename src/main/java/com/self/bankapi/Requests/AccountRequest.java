package com.self.bankapi.Requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountRequest {
    @NotBlank(message = "custNo field is required")
    private String custNo;
}
