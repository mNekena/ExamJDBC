package school.hei.exampoowithia.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import school.hei.exampoowithia.dto.TransactionDTO;
import school.hei.exampoowithia.model.Transaction;
import school.hei.exampoowithia.model.TransactionType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class TransactionRepository {
    private final dbConnection dbConnection;

    public List<TransactionDTO> findAll() {
        String sql = "SELECT * FROM transactions";
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
            System.out.println("Error while fetching all transactions: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

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
            System.out.println("Error while fetching transactions for account ID " + accountId + ": " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public TransactionDTO saveTransaction(TransactionDTO transactionDTO) {
        String sql = "INSERT INTO transactions (id, account_id, created_at, transaction_type, amount, reason) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, transactionDTO.getId());
            preparedStatement.setTimestamp(2, Timestamp.from(transactionDTO.getCreatedAt()));
            preparedStatement.setString(3, transactionDTO.getTransactionType().name());
            preparedStatement.setBigDecimal(4, transactionDTO.getAmount());
            preparedStatement.setString(5, transactionDTO.getReason());

            preparedStatement.executeUpdate();
            return transactionDTO;
        } catch (Exception e) {
            System.out.println("Error while saving transaction: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
