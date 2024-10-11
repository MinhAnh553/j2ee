package com.cellphone.dao;

import com.cellphone.model.DatabaseConnection;
import com.cellphone.model.userModel;
import com.cellphone.providers.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userDAO {
    public boolean checkExistEmail(String email) {
        boolean checked = false;
        String query = "SELECT * FROM users WHERE email = ?";
        
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                checked = true;
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return checked;
    }
    
    public String create(userModel user) {
        String token = Util.generateToken();
        String sql = "INSERT INTO users(email, password, fullName, token) VALUES (?,?,?,?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getFullName());
            stmt.setString(4, token);
            
            stmt.executeUpdate();

            stmt.close();
            conn.close();
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return token;
    }  
}


