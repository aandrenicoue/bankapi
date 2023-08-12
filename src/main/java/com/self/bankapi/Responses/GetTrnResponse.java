package com.self.bankapi.Responses;

import com.self.bankapi.Model.Transaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetTrnResponse {

    private List<Transaction> transactions;

    private Integer currentPage;

    private Integer total;

    private Integer totalPage;
}
