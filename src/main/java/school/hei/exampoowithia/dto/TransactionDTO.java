package school.hei.exampoowithia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import school.hei.exampoowithia.model.TransactionType;

import java.math.BigDecimal;
import java.time.Instant;

@AllArgsConstructor
@Getter
public class TransactionDTO {
    private String id;
    private Instant createdAt;
    private TransactionType transactionType;
    private BigDecimal amount;
    private String reason;
}
