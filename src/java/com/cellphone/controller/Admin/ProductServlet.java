package com.cellphone.controller.Admin;

import com.cellphone.dao.productDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/product")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            try {
                productDAO sevices = new productDAO();
                sevices.delete(id);
                response.sendRedirect("./product");
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("./product");
            }
        } else {
            request.getRequestDispatcher("/views/admin/pages/product.jsp").forward(request, response);
        }
    }
}

