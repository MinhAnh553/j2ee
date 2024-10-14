/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.cellphone.controller;

import com.cellphone.dao.Products;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;
import com.cellphone.model.DatabaseConnection;
import com.cellphone.model.Product;
import jakarta.servlet.RequestDispatcher;

/**
 *
 * @author duylo
 */
@WebServlet(name = "home", urlPatterns = {""})
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        request.getRequestDispatcher("/index.jsp").forward(request, response);
        response.setContentType("text/html;charset=UTF-8");
        Products productList = new Products();

        try {
            // Kết nối đến cơ sở dữ liệu
            Connection connection = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM product";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet result = pstmt.executeQuery();

            // Kiểm tra và lấy thông tin sản phẩm
            while(result.next()) {
                Product product = new Product();
                product.setId(result.getInt("id"));
                product.setName(result.getString("name"));
                product.setBrand(result.getString("brand"));
                product.setColor(result.getString("typeByColor"));
                product.setImage(result.getString("image"));
                product.setDesc(result.getString("description"));
                product.setPrice(result.getDouble("price"));
                product.setSlug(result.getString("slug"));
                
                productList.addProduct(product);
//                System.out.println("Số lượng sản phẩm đã lấy: " + productList.getProductList().size());
//                
//                System.out.println("Sản phẩm đã lấy: ");
//                System.out.println("ID: " + product.getId());
//                System.out.println("Tên: " + product.getName());
//                System.out.println("Hãng: " + product.getBrand());
//                System.out.println("Màu: " + product.getTypeByColor());
//                System.out.println("Hình ảnh: " + product.getImage());
//                System.out.println("Mô tả: " + product.getDescription());
//                System.out.println("Giá: " + product.getPrice());
//                System.out.println("Slug: " + product.getSlug());
            }
        } catch (SQLException e) {
            throw new ServletException("Lỗi kết nối CSDL: " + e.getMessage(), e);
        }

        // Gửi sản phẩm đến JSP để hiển thị
        request.setAttribute("productList", productList.getProductList());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/client/pages/home.jsp"); // Đường dẫn tới JSP hiển thị thông tin sản phẩm
        dispatcher.forward(request, response);
    }

    
    
}
