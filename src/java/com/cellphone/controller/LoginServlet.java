package com.cellphone.controller;


import com.cellphone.model.userModel;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/client/pages/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy thông tin từ form login
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Giả sử bạn kiểm tra mật khẩu đúng bằng cách so sánh với database
        if (userModel.isUserValid(email, password)) {
            response.sendRedirect("./"); // Chuyển hướng tới trang chủ
        } else {
            response.sendRedirect("./login"); // Chuyển hướng về trang đăng nhập với thông báo lỗi
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
