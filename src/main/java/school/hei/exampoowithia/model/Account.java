package school.hei.exampoowithia.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Account {
    private String id;
    private AccountType accountType;
    private List<Transaction> transactions;
}
