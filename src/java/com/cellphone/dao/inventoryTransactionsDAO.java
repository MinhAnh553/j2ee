package com.cellphone.dao;

import com.cellphone.model.DatabaseConnection;
import com.cellphone.model.inventoryTransactionsModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class inventoryTransactionsDAO {
    public void create(inventoryTransactionsModel inventoryTransaction) {
        String sql = "INSERT INTO inventory_transactions (product_id, transaction_type, quantity, current_stock, note, created_by) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, inventoryTransaction.getProductId());
            stmt.setString(2, inventoryTransaction.getTransactionType()); 
            stmt.setInt(3, inventoryTransaction.getQuantity());
            stmt.setInt(4, inventoryTransaction.getCurrentStock());
            stmt.setString(5, inventoryTransaction.getNote());
            stmt.setInt(6, inventoryTransaction.getCreatedBy());
            
            stmt.executeUpdate();

            stmt.close();
            conn.close();
            
        } catch(SQLException e) {
            e.printStackTrace();
        }

    } 
    
    public List<inventoryTransactionsModel> getAllTransactions() {
        List<inventoryTransactionsModel> transactions = new ArrayList<>();
        String sql = "SELECT * FROM inventory_transactions ORDER BY transaction_date DESC";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             ResultSet rs = stmt.executeQuery();
             
            while (rs.next()) {
                inventoryTransactionsModel transaction = new inventoryTransactionsModel();
                transaction.setId(rs.getInt("id"));
                transaction.setProductId(rs.getInt("product_id"));
                transaction.setTransactionType(rs.getString("transaction_type"));
                transaction.setQuantity(rs.getInt("quantity"));
                transaction.setTransactionDate(rs.getTimestamp("transaction_date").toString());
                transaction.setCurrentStock(rs.getInt("current_stock"));
                transaction.setNote(rs.getString("note"));
                transaction.setCreatedBy(rs.getInt("created_by"));
                
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return transactions;
    }
}
