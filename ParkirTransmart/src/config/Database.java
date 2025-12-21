package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    private static Database instance;
    private Connection connection;

    private Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/parkir_transmart"
                + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
                "root",
                ""
            );
        } catch (Exception e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
