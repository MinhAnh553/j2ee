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
            stmt.setInt(3, product.getPrice());  
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
                int price = rs.getInt("price");
                String color = rs.getString("typeByColor");
                String image = rs.getString("image");
                String description = rs.getString("description"); 
                int stock = rs.getInt("stock");
                
                Product product = new Product(id, name, brand, price, color, image, description, stock);
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
    
    public void delete(int id) {
        String sql = "DELETE FROM product WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            stmt.executeUpdate();

            stmt.close();
            conn.close();
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void update(Product product) {
        String sql = "UPDATE product SET name = ?, brand = ?, price = ?, typeByColor = ?, image = ?, description = ?, stock = ?, slug = ? WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getBrand());
            stmt.setInt(3, product.getPrice());  
            stmt.setString(4, product.getTypeByColor());
            stmt.setString(5, product.getImage());
            stmt.setString(6, product.getDescription());
            stmt.setInt(7, Math.max(product.getStock(), 0));
            stmt.setString(8, product.getSlug());
            stmt.setInt(9, product.getId());  
            stmt.executeUpdate();

            stmt.close();
            conn.close();
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Product getProductByID(int id) {
        String sql = "SELECT * FROM product WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()) {
                String name = rs.getString("name");
                String brand = rs.getString("brand");
                int price = rs.getInt("price");
                String color = rs.getString("typeByColor");
                String image = rs.getString("image");
                String description = rs.getString("description"); 
                int stock = rs.getInt("stock");

                Product product = new Product(id, name, brand, price, color, image, description, stock);

                
                rs.close();
                stmt.close();
                conn.close();
                
                return product;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
}
