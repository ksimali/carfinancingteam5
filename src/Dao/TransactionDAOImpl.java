package Dao;

import Config.PostgreSQLConfig;
import model.Transaction;

import java.sql.*;
import java.util.ArrayList;

public class TransactionDAOImpl implements TransactionDAO{
    @Override
    public Transaction addTransaction(Transaction transaction) {
        String sql = "INSERT INTO transaction (investor_id, type, montant, date) VALUES (?, ?, ?, ?);";

        try {
            Connection conn =
                    PostgreSQLConfig.getConnection();
            PreparedStatement pstmt =
                    conn.prepareStatement(sql);
            pstmt.setInt(1, transaction.getInvestor().getUserId());
            pstmt.setString(2, transaction.getTypeTransaction());
            pstmt.setDouble(3, transaction.getMontant());
            pstmt.setDate(4, Date.valueOf(transaction.getDate()));

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transaction;
    }

    @Override
    public ArrayList<Transaction> getAllTransactionsByInvestorId(int investorId) {
        String sql = "SELECT * FROM transaction WHERE investor_id = ?;";
        ArrayList<Transaction> transactions = new ArrayList<>();

        try (Connection conn = PostgreSQLConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, investorId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransactionId(rs.getInt("transaction_id"));
                transaction.setMontant(rs.getDouble("montant"));
                transaction.setDate(rs.getDate("date").toLocalDate());
                transaction.getInvestor().setUserId(rs.getInt("investor_id"));
                transaction.setTypeTransaction(rs.getString("type"));

                transactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }
}
