package com.cellphone.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userModel {
    public static boolean isUserValid(String email, String password) {
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, email);
            stmt.setString(2, password);
            
            ResultSet rs = stmt.executeQuery();
            
            // Nếu tìm thấy kết quả trả về, lấy và in thông tin email và password
            if (rs.next()) {
                String userEmail = rs.getString("email");
                String userFullName = rs.getString("fullName");

                System.out.println("Email: " + userEmail);
                System.out.println("Họ tên: " + userFullName);

                return true; // Trả về true nếu tìm thấy người dùng
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false; // Trả về false nếu không tìm thấy
    }
}
