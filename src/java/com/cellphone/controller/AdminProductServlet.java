package com.cellphone.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin-product")
public class AdminProductServlet extends HttpServlet {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/cellphone";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = ""; 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Nhan data tu form
        String name = request.getParameter("name");
        String brand = request.getParameter("brand");
        String price = request.getParameter("price");
        String typeByColor = request.getParameter("typeByColor");
        String image = request.getParameter("image");
        String description = request.getParameter("description");
        String parameter = request.getParameter("parameter");

        // Check null
        if (name == null || brand == null || price == null || typeByColor == null || image == null || description == null
                || name.isEmpty() || brand.isEmpty() || price.isEmpty() || typeByColor.isEmpty() || image.isEmpty() || description.isEmpty()) {
 
            response.sendRedirect("./admin-product?message=error");
            return;
        }

        // Them vao CSDL
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String sql = "INSERT INTO product (name, brand, price, typeByColor, image, description, parameter) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, brand);
            stmt.setDouble(3, Double.parseDouble(price));  
            stmt.setString(4, typeByColor);
            stmt.setString(5, image);
            stmt.setString(6, description);
            stmt.setString(7, parameter);

            int result = stmt.executeUpdate();
            conn.close();

            // Check result
            if (result > 0) {
                // Thanh cong
                response.sendRedirect("./admin-product?message=success");
            } else {
                // That bai
                response.sendRedirect("./admin-product?message=error");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Loi
            response.sendRedirect("./admin-product?message=error");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if ("delete".equals(action)) {
            String id = request.getParameter("id");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

                String sql = "DELETE FROM product WHERE id=?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, Integer.parseInt(id));

                stmt.executeUpdate();
                conn.close();
                response.sendRedirect("./admin-product?message=deleted");
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("./admin-product?message=error");
            }
        } else {
            request.getRequestDispatcher("/views/admin/pages/product.jsp").forward(request, response);
        }
    }
}
