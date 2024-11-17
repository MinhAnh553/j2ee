/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cellphone.dao;

import com.cellphone.model.DatabaseConnection;
import com.cellphone.model.OrderDetail;
import java.sql.*;

/**
 *
 * @author duylo
 */
public class OrderDetailDAO {
    //Thêm chi tiết đơn hàng
    public void addOrderDetail(OrderDetail orderdetail) throws SQLException {
    String query = "INSERT INTO `order_detail` (order_id, product_id, quantity, price) VALUES (?,?,?,?)";
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        
        stmt.setInt(1, orderdetail.getOrderId());   // Đặt order_id
        stmt.setInt(2, orderdetail.getProductId()); // Đặt product_id
        stmt.setInt(3, orderdetail.getQuantity());  // Đặt quantity
        stmt.setDouble(4, orderdetail.getPrice());  // Đặt price
        
        // Thực thi câu lệnh SQL
        stmt.executeUpdate();  // Chỉ cần gọi executeUpdate() mà không có đối số
        System.out.println("OrderDetail added successfully for Order ID: " + orderdetail.getId());
    } catch (SQLException e) {
        e.printStackTrace();
        throw new SQLException("Error while saving order detail: " + e.getMessage(), e);
    }
}

    
    
}
