package com.cellphone.dao;

import com.cellphone.model.DatabaseConnection;
import com.cellphone.model.Product;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class productDAO {
    public void create(Product product) {
        String sql = "INSERT INTO product (name, brand, price, typeByColor, image, description, slug) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getBrand());
            stmt.setDouble(3, product.getPrice());  
            stmt.setString(4, product.getTypeByColor());
            stmt.setString(5, product.getImage());
            stmt.setString(6, product.getDescription());
            stmt.setString(7, product.getSlug());
            
            stmt.executeUpdate();

            stmt.close();
            conn.close();
            
        } catch(SQLException e) {
            e.printStackTrace();
        }

    }  
    
    public List<Product> getAllProduct() {
        List<Product> productList = new ArrayList<>();
        
        String sql = "SELECT * FROM product";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String brand = rs.getString("brand");
                float price = rs.getFloat("price");
                String color = rs.getString("typeByColor");
                String image = rs.getString("image");
                String description = rs.getString("description"); 

                Product product = new Product(id, name, brand, price, color, image, description);
                productList.add(product);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return productList;
    }
}
