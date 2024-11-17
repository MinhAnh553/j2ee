package com.cellphone.controller.Admin;

import com.cellphone.dao.inventoryTransactionsDAO;
import com.cellphone.dao.productDAO;
import com.cellphone.model.Product;
import com.cellphone.model.inventoryTransactionsModel;
import com.cellphone.model.userModel;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "EditInventoryServlet", urlPatterns = {"/admin/product-inventory/edit"})
public class EditInventoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productDAO productSevices = new productDAO();
        Product product = productSevices.getProductByID(id);
        if(product != null) {
            request.setAttribute("product", product);
            request.getRequestDispatcher("/views/admin/pages/edit_product_inventory.jsp").forward(request, response);
        } else {
           response.sendRedirect(request.getContextPath() + "/admin/product");
        }
        
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        // Nhận data từ form
        int id = Integer.parseInt(request.getParameter("id"));
        int quantity = Integer.parseInt(request.getParameter("value"));
        String note = request.getParameter("note");
        String type = "";
        
        
        productDAO productDAO = new productDAO();
        Product oldProduct = productDAO.getProductByID(id);
        int currentStock = oldProduct.getStock();
        if(request.getParameter("btnNhapHang") != null) {
            oldProduct.setStock(currentStock + quantity);
            type = "IN";
        } else {
            oldProduct.setStock(currentStock - quantity);
            type = "OUT";
        }
        HttpSession session = request.getSession(false);
        userModel user = (userModel) session.getAttribute("account");
        
        inventoryTransactionsModel inventoryTransactionsModel = new inventoryTransactionsModel(id, type, quantity, currentStock, note, user.getId());
        inventoryTransactionsDAO inventoryTransactionsDAO = new inventoryTransactionsDAO();
        inventoryTransactionsDAO.create(inventoryTransactionsModel);
        productDAO.update(oldProduct);

        response.sendRedirect(request.getContextPath() + "/admin/product");
    }

}
