package com.cellphone.dao;

import com.cellphone.model.DatabaseConnection;
import com.cellphone.model.brandModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class brandDAO {
    public List<brandModel> getAllBrand() {
        List<brandModel> brandList = new ArrayList<>();
        
        String sql = "SELECT * FROM brand";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name"); 
                String logo = rs.getString("logo"); 

                brandModel brand = new brandModel(id, name, logo);
                brandList.add(brand);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return brandList;
    }
}
