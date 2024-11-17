/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cellphone.dao;
import com.cellphone.model.DatabaseConnection;
import java.sql.*;
import com.cellphone.model.Payment;


/**
 *
 * @author duylo
 */
public class PaymentDAO {
    public void createPayment(Payment payment) throws SQLException {
    String query = "INSERT INTO `payment` (order_id, amount, payment_method, status, created_at, updated_at) VALUES (?,?,?,?,?,?)";
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS)) { 

        stmt.setInt(1, payment.getOrderId());
        stmt.setDouble(2, payment.getAmount());
        stmt.setInt(3, payment.getPaymentMethod());
        stmt.setInt(4, payment.getStatus());
        stmt.setTimestamp(5, payment.getCreatedAt());  // Thêm thời gian tạo
        stmt.setTimestamp(6, payment.getUpdatedAt());  // Thêm thời gian cập nhật
        stmt.executeUpdate(); // Thực thi câu lệnh INSERT
        // Lấy ID vừa tạo
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                payment.setId(rs.getInt(1));  // Set ID của payment
            }

        
    } catch (SQLException e) {
        e.printStackTrace();
        throw e;
    }
    }
       
    
}

    