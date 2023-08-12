package com.self.bankapi.Controllers;

import com.self.bankapi.Requests.DoTrnRequest;
import com.self.bankapi.Requests.GetTrnRequest;
import com.self.bankapi.Responses.ApiResponse;
import com.self.bankapi.Responses.GetTrnResponse;
import com.self.bankapi.Services.TransactionService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
@Validated
public class TransactionController {
    private TransactionService transactionService;

    @PostMapping("/doAccountTransfer")
    public ApiResponse doAccountTransfer(@RequestBody @Valid DoTrnRequest doTrnRequest) {
        return transactionService.doLocalTransfer(doTrnRequest);
    }

    @GetMapping("/getStatement")
    public ApiResponse getStatement(
            @RequestBody GetTrnRequest getTrnRequest,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        PageRequest pageable = PageRequest.of(page, size);

        GetTrnResponse transactions = transactionService.getStatement(getTrnRequest.getAcNo(), pageable);

        return new ApiResponse(Boolean.TRUE, "success", 200, transactions);

    }
}
