package com.cellphone.controller.Admin;

import com.cellphone.middleware.authMiddleware;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "admin", urlPatterns = {"/admin"})
public class DashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Xong hết rồi thêm
//        if(!authMiddleware.isAdmin(request, response)) {
//            return;
//        }
        request.getRequestDispatcher("/views/admin/pages/dashboard.jsp").forward(request, response);
    }

    
}
