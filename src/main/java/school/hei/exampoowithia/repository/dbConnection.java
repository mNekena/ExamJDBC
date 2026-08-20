package school.hei.exampoowithia.repository;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class dbConnection {
    public Connection getConnection() {
        try {
            var connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/bank",
                    "mnekena",
                    "000000"
            );
            return connection;
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

}
