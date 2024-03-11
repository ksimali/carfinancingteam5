package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreSQLConfig {
    private static final String URL = "jdbc:postgresql://localhost:5432/carfinancingteam5";
    private static final String USER = "root";
    private static final String PASSWORD = "carfinance";

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connecté à la base de données PostgreSQL.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public static void initializeDatabase() {
        // Requête SQL pour créer la table client
        String sqlClient = "CREATE TABLE IF NOT EXISTS client (" +
                "name VARCHAR(256)," +
                "email VARCHAR(256)," +
                "password VARCHAR(256)," +
                "phone VARCHAR(50)," +
                "sel VARCHAR(256)," +
                "occupation VARCHAR(100)," +
                "income NUMERIC," +
                "creditScore INTEGER," +
                "birthday Date," +
                "maritalStatus VARCHAR(50)," +
                "residencyPeriod INTEGER" +
                ");";
        // Requête SQL pour créer la table investor
        String sqlInvestor = "CREATE TABLE IF NOT EXISTS investor (" +
                "name VARCHAR(256)," +
                "email VARCHAR(256)," +
                "password VARCHAR(256)," +
                "phone VARCHAR(50)," +
                "sel VARCHAR(256)," +
                "bankName VARCHAR(100)," +
                "bankAccount VARCHAR(100)," +
                "riskLevel VARCHAR(100)," +
                "financialEducation VARCHAR(100)" +
                ");";
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();

            // Création des tables
            stmt.execute(sqlClient);
            stmt.execute(sqlInvestor);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
