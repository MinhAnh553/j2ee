/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cellphone.dao;

import com.cellphone.model.DatabaseConnection;
import com.cellphone.model.Shipping;
import java.sql.*;

/**
 *
 * @author duylo
 */
public class ShippingDAO {
    public void addShipping(Shipping shipping) throws SQLException {
    String query = "INSERT INTO shipping (order_id, name, email, phone, address, notes, status) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {  // Thêm RETURN_GENERATED_KEYS để lấy ID tự sinh

            stmt.setInt(1, shipping.getOrderId());
            stmt.setString(2, shipping.getName());
            stmt.setString(3, shipping.getEmail());
            stmt.setString(4, shipping.getPhone());
            stmt.setString(5, shipping.getAddress());
            stmt.setString(6, shipping.getNotes());
            stmt.setInt(7, shipping.getStatus());
            

            stmt.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
        throw e;
    }
   }
}
