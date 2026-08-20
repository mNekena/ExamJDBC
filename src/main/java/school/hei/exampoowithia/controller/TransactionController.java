package school.hei.exampoowithia.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import school.hei.exampoowithia.dto.TransactionDTO;
import school.hei.exampoowithia.service.TransactionService;

import java.util.List;

@RestController
@AllArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping("/transactions")
    public List<TransactionDTO> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/accounts/{id}/transactions")
    public List<TransactionDTO> getTransactionsByAccountId(@PathVariable String id) {
        return transactionService.getTransactionsByAccountId(id);
    }

    @PostMapping("/transactions")
    public TransactionDTO createTransaction(@RequestBody TransactionDTO transactionDTO) {
        return transactionService.createTransaction(transactionDTO);
    }
}
