package school.hei.exampoowithia.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import school.hei.exampoowithia.dto.TransactionDTO;
import school.hei.exampoowithia.model.Transaction;
import school.hei.exampoowithia.model.TransactionType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class TransactionRepository {
    private final dbConnection dbConnection;

    public List<TransactionDTO> findAllByAccountId(String accountId) {
        String sql = "SELECT * FROM transactions WHERE account_id = '" + accountId + "'";
        var transactions = new ArrayList<TransactionDTO>();

        try (Connection connection = dbConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                var transaction = new TransactionDTO(
                        resultSet.getString("id"),
                        resultSet.getTimestamp("created_at").toInstant(),
                        TransactionType.valueOf(resultSet.getString("transaction_type")),
                        resultSet.getBigDecimal("amount"),
                        resultSet.getString("reason")
                );
                transactions.add(transaction);
            }
            return transactions;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
