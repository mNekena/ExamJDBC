package school.hei.exampoowithia.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import school.hei.exampoowithia.dto.TransactionDTO;
import school.hei.exampoowithia.service.TransactionService;

import java.util.List;

@Controller
@AllArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping("/transactions")


    @GetMapping("/accounts/{id}/transactions")
    public List<TransactionDTO> getTransactionsByAccountId(@PathVariable String id) {
        return transactionService.getTransactionsByAccountId(id);
    }
}
