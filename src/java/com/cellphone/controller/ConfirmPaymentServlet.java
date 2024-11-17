/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.cellphone.controller;

import com.cellphone.dao.OrderDAO;
import com.cellphone.dao.PaymentDAO;
import com.cellphone.dao.ShippingDAO;
import com.cellphone.model.DatabaseConnection;
import com.cellphone.model.Order;
import com.cellphone.model.Payment;
import com.cellphone.model.Shipping;
import com.cellphone.model.userModel;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.List;

/**
 *
 * @author duylo
 */
@WebServlet(name = "ConfirmPaymentServlet", urlPatterns = {"/ConfirmPaymentServlet"})
public class ConfirmPaymentServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Nhận các tham số từ form
        String order_id = request.getParameter("order_id");
        String deliveryMethod = request.getParameter("deliveryMethod");
        String receiveMethod = request.getParameter("receiveMethod");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        if(phone == null){
            phone="0";
        }
        String address = request.getParameter("address");
        String orderNote = request.getParameter("orderNote");
        String paymentMethod = request.getParameter("paymentMethod");
        String total = request.getParameter("total");
        //Lấy thông tin khách hàng từ phiên đăng nhập
        userModel user = (userModel) request.getSession().getAttribute("account");
        String fullName = user.getFullName();
        String email = user.getEmail();
        String phoneNumber = user.getPhone();
        if(phoneNumber == null){
            phoneNumber = "0";
        }
        try {
//             Kết nối đến cơ sở dữ liệu
            Connection connection = DatabaseConnection.getConnection();
            //Lưu vào shipping
            if(Integer.parseInt(receiveMethod) == 1){
                Shipping shipping = new Shipping();
                shipping.setOrderId(Integer.parseInt(order_id));
                shipping.setName(name);
                shipping.setEmail(email);
                shipping.setPhone(phone);
                shipping.setAddress(address);
                shipping.setNotes(orderNote);
                shipping.setStatus(0);
                ShippingDAO shippingdao = new ShippingDAO();
                shippingdao.addShipping(shipping);
                


            }
            //Lưu vào payment
            Payment payment = new Payment();
            payment.setOrderId(Integer.parseInt(order_id));
            payment.setAmount(Double.parseDouble(total));
            payment.setPaymentMethod(0);
            payment.setStatus(0);
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            payment.setCreatedAt(currentTime);
            payment.setUpdatedAt(currentTime);
            PaymentDAO paymentdao = new PaymentDAO();
            paymentdao.createPayment(payment);
            // Sau khi lưu payment, lấy payment_id từ database
            int paymentId = payment.getId();
            
            
            
            // Cập nhật payment_id và receive_method vào bảng order
            String updateOrderSQL = "UPDATE `order` SET payment_id = ?, receive_method = ? WHERE id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(updateOrderSQL)) {
                stmt.setInt(1, paymentId);
                stmt.setInt(2, Integer.parseInt(receiveMethod));
                stmt.setInt(3, Integer.parseInt(order_id));
                stmt.executeUpdate();
            }
            OrderDAO orderDAO = new OrderDAO(); // DAO để lấy thông tin đơn hàng
            int user_id = user.getId();
            List<Order> orders = orderDAO.getOrderByUserId(user_id);
            request.setAttribute("orders", orders);
            // Xóa giỏ hàng sau khi đặt hàng
            request.getSession().removeAttribute("cart");
            
            
            
            }catch (SQLException e) {
            throw new ServletException("Lỗi kết nối CSDL: " + e.getMessage(), e);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/client/pages/orderTracking.jsp");
        dispatcher.forward(request, response);
        
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
     
        
        
        
        
        
     
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/client/pages/orderTracking.jsp"); // Đường dẫn tới JSP hiển thị thông tin sản phẩm
//            dispatcher.forward(request, response);
processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
