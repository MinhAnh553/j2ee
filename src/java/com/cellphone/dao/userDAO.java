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
    
    public boolean checkToken(String token) {
        boolean checked = false;
        String query = "SELECT * FROM users WHERE token = ?";
        
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, token);
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
    
    public userModel getUserByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                userModel user = new userModel();
                
                user.setId(rs.getInt("id"));
                user.setRole(rs.getInt("role"));
                user.setEmail(rs.getString("email"));
                user.setFullName(rs.getString("fullName"));
                user.setPhone(rs.getString("phoneNumber"));
                user.setPassword(rs.getString("password"));
                user.setToken(rs.getString("token"));
                
                rs.close();
                stmt.close();
                conn.close();
                
                return user;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public userModel getUserById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                userModel user = new userModel();
                
                user.setId(rs.getInt("id"));
                user.setRole(rs.getInt("role"));
                user.setEmail(rs.getString("email"));
                user.setFullName(rs.getString("fullName"));
                user.setPhone(rs.getString("phoneNumber"));
                user.setPassword(rs.getString("password"));
                user.setToken(rs.getString("token"));
                
                rs.close();
                stmt.close();
                conn.close();
                
                return user;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public userModel create(userModel user) {
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
        userModel userResult = getUserByEmail(user.getEmail());
        return userResult;
    }  
}


