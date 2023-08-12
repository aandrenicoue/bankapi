package com.self.bankapi.Controllers;

import com.self.bankapi.Helper.ExcelGenerator;
import com.self.bankapi.Model.Transaction;
import com.self.bankapi.Repositories.TransactionRepository;
import com.self.bankapi.Requests.DoTrnRequest;
import com.self.bankapi.Requests.GetTrnRequest;
import com.self.bankapi.Responses.ApiResponse;
import com.self.bankapi.Responses.GetTrnResponse;
import com.self.bankapi.Services.TransactionService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
@Validated
public class TransactionController {
    private TransactionService transactionService;
    private final TransactionRepository transactionRepository;

    @PostMapping("/doAccountTransfer")
    public ApiResponse doAccountTransfer(@RequestBody @Valid DoTrnRequest doTrnRequest) {
        return transactionService.doLocalTransfer(doTrnRequest);
    }

    @GetMapping("/getStatement")
    public ApiResponse getStatement(
            @RequestBody GetTrnRequest getTrnRequest,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {

        PageRequest pageable = PageRequest.of(page, size);

        GetTrnResponse transactions = transactionService.getStatement(getTrnRequest.getAcNo(), pageable);

        return new ApiResponse(Boolean.TRUE, "success", 200, transactions);

    }

    @GetMapping("/export-to-excel")
    public void exportIntoExcelFile(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=student" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Transaction> listOfStudents = transactionRepository.findAll();
        ExcelGenerator generator = new ExcelGenerator(listOfStudents);
        generator.generateExcelFile(response);
    }
}
