package com.cellphone.controller.Admin;

import com.cellphone.middleware.authMiddleware;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "inventory", urlPatterns = {"/admin/inventory"})
public class InventoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Xong hết rồi thêm
//        if(!authMiddleware.isAdmin(request, response)) {
//            return;
//        }
        request.getRequestDispatcher("/views/admin/pages/inventory.jsp").forward(request, response);
    }

    
}
