package com.cellphone.controller.Admin;

import com.cellphone.dao.productDAO;
import com.cellphone.model.Product;
import com.cellphone.providers.Util;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@MultipartConfig
@WebServlet("/admin/product/edit")
public class EditProductServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productDAO sevices = new productDAO();
        Product product = sevices.getProductByID(id);
        if(product != null) {
            request.setAttribute("product", product);
            request.getRequestDispatcher("/views/admin/pages/edit_product.jsp").forward(request, response);
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
        String name = request.getParameter("name");
        String brand = request.getParameter("brand");
        int price = Integer.parseInt(request.getParameter("price"));
        String typeByColor = request.getParameter("typeByColor");
        String description = request.getParameter("description");
        String slug = Util.generateSlug(name);
        
        // Lấy file ảnh từ form và chuyển đổi thành chuỗi Base64
        Part filePart = request.getPart("image"); 
        String image = null;

        if (filePart != null && filePart.getSize() > 0) {
            InputStream inputStream = filePart.getInputStream();
            byte[] imageBytes = inputStream.readAllBytes();
            image = Base64.getEncoder().encodeToString(imageBytes);
            inputStream.close();
        }
        
        productDAO productDAO = new productDAO();
        Product oldProduct = productDAO.getProductByID(id);
        oldProduct.setName(name);
        oldProduct.setBrand(brand);
        oldProduct.setPrice(price);
        oldProduct.setColor(typeByColor);
        oldProduct.setDesc(description);
        oldProduct.setSlug(slug);
        if(image != null) {
            oldProduct.setImage(image);
        }
        productDAO.update(oldProduct);
              
//        Map<String, String> alert = new HashMap<>();
//        alert.put("type", "success");
//        alert.put("msg", "Chỉnh sửa sản phẩm thành công!");
//        HttpSession session = request.getSession(false);
//        session.setAttribute("alert", alert);
        
        response.sendRedirect(request.getContextPath() + "/admin/product");
    }
}
