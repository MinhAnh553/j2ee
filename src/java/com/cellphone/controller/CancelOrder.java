/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.cellphone.controller;

import com.cellphone.dao.OrderDAO;
import com.cellphone.model.Order;
import com.cellphone.model.userModel;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;

/**
 *
 * @author duylo
 */
@WebServlet(name = "CancelOrder", urlPatterns = {"/CancelOrder"})
public class CancelOrder extends HttpServlet {

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
            out.println("<title>Servlet cancleOrder</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet cancleOrder at " + request.getContextPath() + "</h1>");
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
                int order_id = Integer.parseInt(request.getParameter("orderId"));
                OrderDAO orderdao = new OrderDAO();
                boolean success = orderdao.cancelOrder(order_id);
                // Lấy thông tin người dùng từ session
                userModel user = (userModel) request.getSession().getAttribute("account");
                if (user == null) {
                    // Nếu người dùng chưa đăng nhập, chuyển hướng đến trang đăng nhập
                    response.sendRedirect("/project_j2ee/login");
                    return;
                }
                int user_id = user.getId();

                // Lấy lại danh sách đơn hàng của người dùng
                List<Order> orders = orderdao.getOrderByUserId(user_id);

                // Truyền danh sách đơn hàng vào request
                request.setAttribute("orders", orders);
                // Thêm thông báo cho người dùng
                if (success) {
                    request.setAttribute("successMessage", "Đơn hàng đã được hủy thành công.");
                } else {
                    request.setAttribute("errorMessage", "Không thể hủy đơn hàng.");
                }

                // Chuyển tiếp request đến orderTracking.jsp để hiển thị thông tin đơn hàng
                RequestDispatcher dispatcher = request.getRequestDispatcher("/views/client/pages/orderTracking.jsp");
                dispatcher.forward(request, response);//        processRequest(request, response);
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
