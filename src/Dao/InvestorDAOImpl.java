package Dao;

import Config.PostgreSQLConfig;
import Outils.HachageMotDePasse;
import model.Investor;

import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Arrays;

public class InvestorDAOImpl implements InvestorDAO{
    @Override
    public Investor addInvestor(Investor investor) {
        String sql = "INSERT INTO investor (name, email, password, phone, sel, bankName, bankAccount, riskLevel, financialEducation) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            Connection conn =
                    PostgreSQLConfig.getConnection();
            PreparedStatement pstmt =
                    conn.prepareStatement(sql);
            pstmt.setString(1, investor.getName());
            pstmt.setString(2, investor.getEmail());
            pstmt.setString(3, investor.getPassword());
            pstmt.setString(4, investor.getPhone());
            pstmt.setString(5, investor.getSel());
            pstmt.setString(6, investor.getBankName());
            pstmt.setString(7, investor.getBankAccount());
            pstmt.setString(8, investor.getRiskLevel());
            pstmt.setString(9, investor.getFinancialEducation());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return investor;
    }

    @Override
    public Investor getInvestorByEmail(String email) {
        String sql = "SELECT * FROM investor WHERE email = ?;";
        Investor investor = null;

        try (Connection conn = PostgreSQLConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                investor = new Investor();
                investor.setUserId(rs.getInt("investor_id"));
                investor.setName(rs.getString("name"));
                investor.setEmail(rs.getString("email"));
                investor.setPassword(rs.getString("password"));
                investor.setPhone(rs.getString("phone"));
                investor.setSel(rs.getString("sel"));
                investor.setBankName(rs.getString("bankName"));
                investor.setBankAccount(rs.getString("bankAccount"));
                investor.setRiskLevel(rs.getString("riskLevel"));
                investor.setFinancialEducation(rs.getString("financialEducation"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return investor;
    }
}
