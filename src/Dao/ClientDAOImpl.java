package Dao;

import Config.PostgreSQLConfig;
import Outils.HachageMotDePasse;
import model.Client;

import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Arrays;

public class ClientDAOImpl implements ClientDAO {
    @Override
    public Client addClient(Client client) {
        String sql = "INSERT INTO client (name, email, password, phone, sel, occupation, income, creditScore, birthday, maritalStatus, residencyPeriod) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            Connection conn =
                    PostgreSQLConfig.getConnection();
            PreparedStatement pstmt =
                    conn.prepareStatement(sql);
            pstmt.setString(1, client.getName());
            pstmt.setString(2, client.getEmail());
            pstmt.setString(3, client.getPassword());
            pstmt.setString(4, client.getPhone());
            pstmt.setString(5, client.getSel());
            pstmt.setString(6, client.getOccupation());
            pstmt.setBigDecimal(7, client.getIncome());
            pstmt.setInt(8, client.getCreditScore());
            pstmt.setDate(9, Date.valueOf(client.getBirthday()));
            pstmt.setString(10, client.getMaritalStatus());
            pstmt.setInt(11, client.getResidencyPeriod());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public Client getClientByEmail(String email) {
        String sql = "SELECT * FROM client WHERE email = ?;";
        Client client = null;

        try (Connection conn = PostgreSQLConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                client = new Client();
                client.setName(rs.getString("name"));
                client.setEmail(rs.getString("email"));
                client.setPassword(rs.getString("password"));
                client.setPhone(rs.getString("phone"));
                client.setSel(rs.getString("sel"));
                client.setOccupation(rs.getString("occupation"));
                client.setIncome(rs.getBigDecimal("income"));
                client.setCreditScore(rs.getInt("creditScore"));
                client.setBirthday(rs.getDate("birthday").toLocalDate());
                client.setMaritalStatus(rs.getString("maritalStatus"));
                client.setResidencyPeriod(rs.getInt("residencyPeriod"));
                client.afficherDetails();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }
}
