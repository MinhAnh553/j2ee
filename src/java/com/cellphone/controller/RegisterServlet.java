package com.cellphone.controller;

import com.cellphone.dao.userDAO;
import com.cellphone.model.userModel;
import com.cellphone.providers.Util;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "register", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Check session
        HttpSession session = request.getSession(false);
        if(session != null) {
            userModel user = (userModel) session.getAttribute("account");
            if(user != null) {
                // Check tiếp cookie
                Cookie []cookies = request.getCookies();
                if(cookies != null) {
                    for(Cookie cookie : cookies) {
                        if (cookie.getName().equals("accessToken")) {
                            String token = cookie.getValue();
                            userDAO service = new userDAO();
                            if(service.checkToken(token)) {
                                response.sendRedirect("./");
                                return;
                            }
                        }  
                    }
                }
            }
        }
        
        // Chưa đăng nhập, đăng ký thì đưa vào trang đăng ký
        request.getRequestDispatcher("/views/client/pages/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        // Lấy thông tin từ form
        String fullName = request.getParameter("fullname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        // Mã hóa password
        password = Util.hashPassword(password);
        
        userDAO service = new userDAO();
        Boolean checkMail = service.checkExistEmail(email);
        Map<String, String> alert = new HashMap<>();
        if(checkMail) {
            // Trả về thông báo đã tồn tại
            alert.put("type", "error");
            alert.put("msg", "Email đã tồn tại trong hệ thống!");
            request.setAttribute("alert", alert);
            request.getRequestDispatcher("/views/client/pages/register.jsp").forward(request, response);
            return;
        }
        
        // Tạo tài khoản
        userModel user = service.create(new userModel(email, password, fullName));
        // Tạo session
        HttpSession session = request.getSession(true);
        session.setAttribute("account", user);
        // Tạo cookie
        Cookie accessToken = new Cookie("accessToken", user.getToken());
        accessToken.setHttpOnly(true);
        accessToken.setMaxAge(60 * 60 * 24 * 15);
        response.addCookie(accessToken);
        // Trả về thông báo thành công
        alert.put("type", "success");
        alert.put("msg", "Tạo tài khoản thành công!");
        request.setAttribute("alert", alert);
        session.setAttribute("alert", alert); 
//        request.getRequestDispatcher("/index.jsp").forward(request, response);
        response.sendRedirect("./");
    }
  
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
