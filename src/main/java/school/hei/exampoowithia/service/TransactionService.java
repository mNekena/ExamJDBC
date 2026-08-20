package school.hei.exampoowithia.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import school.hei.exampoowithia.dto.TransactionDTO;
import school.hei.exampoowithia.repository.TransactionRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public List<TransactionDTO> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public List<TransactionDTO> getTransactionsByAccountId(String accountId) {
        return transactionRepository.findAllByAccountId(accountId);
    }

    public TransactionDTO createTransaction(TransactionDTO transactionDTO) {
        return transactionRepository.saveTransaction(transactionDTO);
    }
}
