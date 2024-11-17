/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.cellphone.controller;

import com.cellphone.dao.OrderDAO;
import com.cellphone.dao.OrderDetailDAO;
import com.cellphone.model.CartItem;
import com.cellphone.model.DatabaseConnection;
import com.cellphone.model.Order;
import com.cellphone.model.OrderDetail;
import com.cellphone.model.userModel;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.*;
import java.util.*;

/**
 *
 * @author duylo
 */
@WebServlet(name = "OrderServlet", urlPatterns = {"/OrderServlet"})
public class OrderServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OrderServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
        // Sử dụng response.getWriter().print() để in ra trang web
        out.print("Entering OrderServlet doGet() <br>");
        
        OrderDAO orderDAO = new OrderDAO(); // DAO để lấy thông tin đơn hàng
        userModel user = (userModel) request.getSession().getAttribute("account");
        if (user == null) {
            out.print("User is not logged in, redirecting to login <br>");
            response.sendRedirect(request.getContextPath() + "/login"); // Chuyển hướng đến trang đăng nhập nếu chưa đăng nhập
            return;
        } else {
            out.print("User is logged in: " + user.getFullName() + "<br>");
        }
        int user_id = user.getId();
        out.print("User ID: " + user_id + "<br>");

        // Lấy danh sách đơn hàng của người dùng
        List<Order> orders = orderDAO.getOrderByUserId(user_id);
        out.print("Found " + orders.size() + " orders for user " + user.getId() + "<br>");
        // In từng đơn hàng ra console hoặc vào response
    if (orders != null && !orders.isEmpty()) {
        for (Order order : orders) {
            // In thông tin của từng đơn hàng
            System.out.println("Order ID: " + order.getId());
            System.out.println("Status: " + order.getStatus());
            System.out.println("Total: " + order.getTotal());
            System.out.println("Created At: " + order.getCreatedAt());
            System.out.println("Updated At: " + order.getUpdatedAt());
            // Thêm thông tin vào response (hoặc bạn có thể gửi nó vào JSP)
            out.println("<p>Order ID: " + order.getId() + "</p>");
            out.println("<p>Status: " + order.getStatus() + "</p>");
            out.println("<p>Total: " + order.getTotal() + "</p>");
            out.println("<p>Created At: " + order.getCreatedAt() + "</p>");
            out.println("<p>Updated At: " + order.getUpdatedAt() + "</p>");
        }
    } else {
        System.out.println("No orders found.");
        out.println("<p>No orders found.</p>");
    }
        
        request.setAttribute("orders", orders);
        
        
        // Chuyển tiếp request đến JSP
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/client/pages/orderTracking.jsp");
        dispatcher.forward(request, response);
    }
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
        
        HttpSession session = request.getSession();
        //Lấy thông tin từ giỏ hàng
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        // Lấy đối tượng userModel từ session
        userModel user = (userModel) session.getAttribute("account");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login");  // Chuyển hướng đến trang đăng nhập nếu không có thông tin tài khoản
            return;
        }

        Integer user_id = user.getId();  // Lấy userId từ đối tượng userModel
        //Lúc này chưa thanh toán, giao hàng nên mặc định là 0
        int payment_id = 0;
        int receive_method =0;
        int status = 0;
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        //Lấy tổng tiền từ trang giỏ hàng
        String total = request.getParameter("totalPrice");
        
        
        //Tạo đơn hàng Order
        Order order = new Order();
        order.setUserId(user_id);
        order.setPaymentId(payment_id);
        order.setReceiveMethod(receive_method);
        order.setStatus(status);
        order.setTotal(Double.parseDouble(total));
        order.setCreatedAt(currentTime);
        order.setUpdatedAt(currentTime);
        
        
        
        try {
            // Kết nối đến cơ sở dữ liệu
            Connection connection = DatabaseConnection.getConnection();
                OrderDAO orderDao = new OrderDAO();
                OrderDetailDAO orderdetailDao = new OrderDetailDAO();
                //Lưu đơn hàng vào csdl và lấy id đơn hàng
                int orderid = orderDao.createOrder(order);
                //Tạo danh sách chi tiết đơn hàng
                for(CartItem item : cart){
                    OrderDetail orderDetail = new OrderDetail();
                    orderDetail.setOrderId(orderid);
                    orderDetail.setProductId((item.getProductId()));
                    orderDetail.setQuantity(item.getProductQuantity());
                    orderDetail.setPrice(item.getProductPrice());
                     
                    //Lưu chi tiết đơn hàng vào csdl
                    orderdetailDao.addOrderDetail(orderDetail);
                    
                }
                 // Sau khi tạo đơn hàng, truyền order_id 
            request.setAttribute("order_id", orderid);  // Lưu order_id vào request
            request.setAttribute("total", total);
                
                

            // Xóa giỏ hàng sau khi đặt hàng
//            session.removeAttribute("cart");

            
                
            
                }catch (SQLException e) {
            throw new ServletException("Lỗi kết nối CSDL: " + e.getMessage(), e);
        }
       
        
            
        
        
        
        
        
       
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/client/pages/receive.jsp"); // Đường dẫn tới JSP hiển thị thông tin sản phẩm
            dispatcher.forward(request, response);
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
