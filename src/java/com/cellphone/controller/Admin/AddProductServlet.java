package com.cellphone.controller.Admin;

import com.cellphone.dao.brandDAO;
import com.cellphone.dao.productDAO;
import com.cellphone.model.brandModel;
import com.cellphone.model.Product;
import com.cellphone.providers.Util;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;

@MultipartConfig
@WebServlet(name = "AddProductServlet", urlPatterns = {"/admin/product/add"})
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        brandDAO brandDAO = new brandDAO();
        List<brandModel> brands = brandDAO.getAllBrand();

        request.setAttribute("brands", brands);
        request.getRequestDispatcher("/views/admin/pages/add_product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        // Nhận data từ form
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

        // Tạo sản phẩm và lưu vào DB
        Product product = new Product(name, brand, price, typeByColor, image, description, slug);
        productDAO productDAO = new productDAO();
        productDAO.create(product);
              
//        Map<String, String> alert = new HashMap<>();
//        alert.put("type", "success");
//        alert.put("msg", "Thêm sản phẩm thành công!");
//        HttpSession session = request.getSession(false);
//        session.setAttribute("alert", alert);
        
        response.sendRedirect(request.getContextPath() + "/admin/product");
    }
}
