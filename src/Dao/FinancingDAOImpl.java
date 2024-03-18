package Dao;

import Config.PostgreSQLConfig;
import model.Financing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class FinancingDAOImpl implements FinancingDAO {
    @Override
    public Financing addFinancing(Financing financing) {
        String sql = "INSERT INTO Financing (name, email, phone, vin, montant, duree, kilometre, created_at) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        try (Connection conn = PostgreSQLConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, financing.getName());
            pstmt.setString(2, financing.getEmail());
            pstmt.setString(3, financing.getPhone());
            pstmt.setString(4, financing.getVin());
            pstmt.setInt(5, financing.getMontant());
            pstmt.setInt(6, financing.getDuree());
            pstmt.setInt(7, financing.getKilometre());
            pstmt.setTimestamp(8, new Timestamp(System.currentTimeMillis()));

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("La demande de financement a été ajouté avec succés");
            } else {
                System.out.println("L'ajout de la demande de financement a été contrant");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return financing;
    }
}
