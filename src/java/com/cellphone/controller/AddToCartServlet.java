/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.cellphone.controller;

import com.cellphone.model.CartItem;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duylo
 */
@WebServlet(name = "AddToCart", urlPatterns = {"/AddToCart"})
public class AddToCartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String productId = request.getParameter("productId");
            String productName = request.getParameter("productName");
            String productImage = request.getParameter("productImage");
            String productPrice = request.getParameter("productPrice");
            int productQuantity = 1;
            
            //Lấy giỏ hàng session nếu có
            HttpSession session = request.getSession();
            List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
            
            //Nếu chưa có session giỏ hàng, thì ta tạo session giỏ hàng
            if(cart==null){
                cart = new ArrayList<>();
                //Lưu giỏ hàng vào session
                session.setAttribute("cart", cart);

            }
            
            //Kiểm tra sản phẩm có trong giỏ hàng chưa
            boolean productExist = false;
            for (CartItem item : cart){
                //Nếu có thì tăng số lượng thêm 1
                if (item.getProductId()==Integer.parseInt(productId)){
                    item.setProductQuantity(item.getProductQuantity()+1);
                    productExist = true;
                    break;
                }
            }
            
            //Nếu chưa có, tạo 1 sản phẩm mới và thêm vào giỏ hàng
            if(!productExist){
                CartItem cartitem = new CartItem(Integer.parseInt(productId), productName, Double.parseDouble(productPrice),productImage,productQuantity);
                cart.add(cartitem);  
            }
                        
            if (cart != null) {
                System.out.println("Giỏ hàng: " + cart);
            } else {
                System.out.println("Giỏ hàng trống.");
            }
            
            
            //Chuyển đến trang giỏ hàng
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/client/pages/cart.jsp"); // Đường dẫn tới JSP hiển thị thông tin sản phẩm
            dispatcher.forward(request, response);


    }

}
