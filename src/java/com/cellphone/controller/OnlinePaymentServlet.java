/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.cellphone.controller;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author duylo
 */
@WebServlet(name = "OnlinePaymentServlet", urlPatterns = {"/OnlinePaymentServlet"})
public class OnlinePaymentServlet extends HttpServlet {

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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/client/pages/qrcode.jsp"); // Đường dẫn tới JSP hiển thị thông tin sản phẩm
            dispatcher.forward(request, response);
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OnlinePaymentServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet at " + request.getContextPath() + "</h1>");
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
        // Lấy thông tin từ request (ví dụ: order_id, total, name, phone, ...)
        String orderId = request.getParameter("order_id");
        String total = request.getParameter("total");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String deliveryMethod = request.getParameter("deliveryMethod");
        String receiveMethod = request.getParameter("receiveMethod");
        String address = request.getParameter("address");
        String orderNote = request.getParameter("orderNote");

        // Tạo thông tin để xây dựng URL mã QR (thí dụ amount, addInfo, accountName)
        String amount = total; // Ví dụ sử dụng tổng giá trị làm số tiền thanh toán
        String addInfo = "HOADON_" + orderId; // Mã hóa thông tin đơn hàng (có thể thêm thông tin khác nếu cần)
        String accountName = name; // Sử dụng tên khách hàng

        // Tạo URL mã QR
        String qrCodeUrl = "https://img.vietqr.io/image/970416-6611691-vietqr.jpg?amount=" + amount + 
                           "&addInfo=" + addInfo + 
                           "&accountName=" + accountName;

        // Lưu URL mã QR vào request attributes để gửi sang JSP
        request.setAttribute("qrCodeUrl", qrCodeUrl);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/client/pages/qrcode.jsp");
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
