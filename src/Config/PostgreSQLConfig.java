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
                "client_id SERIAL," +
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
                "residencyPeriod INTEGER," +
                "PRIMARY KEY(client_id)" +
                ");";
        // Requête SQL pour créer la table investors
        String sqlInvestor = "CREATE TABLE IF NOT EXISTS investor (" +
                "investor_id SERIAL," +
                "name VARCHAR(256)," +
                "email VARCHAR(256)," +
                "password VARCHAR(256)," +
                "phone VARCHAR(50)," +
                "sel VARCHAR(256)," +
                "bankName VARCHAR(100)," +
                "bankAccount VARCHAR(100)," +
                "riskLevel VARCHAR(100)," +
                "financialEducation VARCHAR(100)," +
                "PRIMARY KEY(investor_id)" +
                ");";
        // Requête SQL pour créer la table contenant les financements
        String sqlFinancing = "CREATE TABLE IF NOT EXISTS financing (" +
                "financing_id SERIAL," +
                "client_id INT," +
                "name VARCHAR(256)," +
                "email VARCHAR(256)," +
                "phone VARCHAR(256)," +
                "vin VARCHAR(64) NOT NULL," +
                "montant INT NOT NULL," +
                "duree INT NOT NULL," +
                "kilometre INT NOT NULL," +
                "created_at DATE NOT NULL," +
                "PRIMARY KEY(financing_id)," +
                "CONSTRAINT fk_financing_client FOREIGN KEY(client_id) REFERENCES client(client_id)" +
                ");";

        //Requête SQL pour créer la table contenant les transactions
        String sqlTransaction = "CREATE TABLE IF NOT EXISTS transaction (" +
                "transaction_id SERIAL," +
                "investor_id INT," +
                "type VARCHAR(25) NOT NULL," +
                "montant DECIMAL NOT NULL," +
                "date DATE NOT NULL," +
                "PRIMARY KEY(transaction_id)," +
                "CONSTRAINT fk_transaction_investor FOREIGN KEY(investor_id) REFERENCES investor(investor_id)" +
                ");";

        // Reqête SQL pour créer la table contenant les investissements
        String sqlInvestment = "CREATE TABLE IF NOT EXISTS investment (" +
                "investment_id SERIAL," +
                "investor_id INT," +
                "balance INT," +
                "date DATE," +
                "PRIMARY KEY(investment_id)," +
                "CONSTRAINT fk_investment_investor FOREIGN KEY(investor_id) REFERENCES investor(investor_id)" +
                ");";
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();

            // Création des tables
            stmt.execute(sqlClient);
            stmt.execute(sqlInvestor);
            stmt.execute(sqlFinancing);
            stmt.execute(sqlTransaction);
            stmt.execute(sqlInvestment);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
