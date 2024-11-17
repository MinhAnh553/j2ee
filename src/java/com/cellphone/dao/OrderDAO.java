package com.cellphone.dao;

import com.cellphone.model.DatabaseConnection;
import com.cellphone.model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author duylo
 */
public class OrderDAO {
    
    // Tạo đơn hàng mới
    public int createOrder(Order order) throws SQLException {
    String query = "INSERT INTO `order` (user_id, payment_id, receive_method, total, status, created_at, updated_at) VALUES (?,?,?,?,?,?,?)";
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {  // Thêm RETURN_GENERATED_KEYS để lấy ID tự sinh

        stmt.setInt(1, order.getUserId());
        stmt.setInt(2, order.getPaymentId());
        stmt.setInt(3, order.getReceiveMethod());
        stmt.setDouble(4, order.getTotal());
        stmt.setInt(5, order.getStatus());
        stmt.setTimestamp(6, order.getCreatedAt());  // Thêm thời gian tạo
        stmt.setTimestamp(7, order.getUpdatedAt());  // Thêm thời gian cập nhật
        stmt.executeUpdate(); // Thực thi câu lệnh INSERT


        // Lấy ID mới vừa được sinh ra (auto-generated)
        try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);  // Trả về ID của đơn hàng mới
            } else {
                throw new SQLException("Creating order failed, no ID obtained.");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw e;
    }
}


    // Tìm đơn hàng dựa trên user_id
    public List<Order> getOrderByUserId(int user_id) {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM `order` WHERE user_id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, user_id);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setUserId(rs.getInt("user_id"));
                order.setPaymentId(rs.getInt("payment_id"));
                order.setReceiveMethod(rs.getInt("receive_method"));
                order.setTotal(rs.getDouble("total"));
                order.setStatus(rs.getInt("status"));
                order.setCreatedAt(rs.getTimestamp("created_at"));  // Đọc thời gian tạo
                order.setUpdatedAt(rs.getTimestamp("updated_at"));  // Đọc thời gian cập nhật
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
    
    //Tìm đơn hàng dựa trên order_id
    public Order getOrderByOrderId(int order_id){
        Order order = new Order();
        String query = "SELECT * FROM `order` WHERE order_id =? ";
        try (Connection conn = DatabaseConnection.getConnection(); 
            PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, order_id);
                ResultSet rs = stmt.executeQuery(query);
                
                order.setId(order_id);
                order.setUserId(rs.getInt("user_id"));
                order.setPaymentId(rs.getInt("payment_id"));
                order.setReceiveMethod(rs.getInt("receive_method"));
                order.setTotal(rs.getDouble("total"));
                order.setStatus(rs.getInt("status"));
                order.setCreatedAt(rs.getTimestamp("created_at"));  // Đọc thời gian tạo
                order.setUpdatedAt(rs.getTimestamp("updated_at"));  // Đọc thời gian cập nhật
            
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }
    //Hủy đơn hàng
    public boolean cancelOrder(int order_id){
        Order order = getOrderByOrderId(order_id);
        if(order.getStatus()==0){
            boolean updateSuccess = updateOrderStatus(order_id, 2);
            if (updateSuccess) {
                return true;
            } else {
                // Nếu không thể cập nhật, trả về false
                return false;
            }    
        }
        return false; 
    }

    // Cập nhật trạng thái đơn hàng
    public boolean updateOrderStatus(int order_id, int status) {
        String query = "UPDATE `order` SET status = ?, updated_at = ? WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, status);
            stmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));  // Cập nhật thời gian hiện tại
            stmt.setInt(3, order_id);
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0; // Nếu có bản ghi được cập nhật, trả về true
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
