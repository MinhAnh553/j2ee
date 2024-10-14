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

@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Check session
        HttpSession session = request.getSession(false);
        if(session != null) {
            userModel user = (userModel) session.getAttribute("account");
            if(user != null) {
                // Check tiếp cookie
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
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
        
        // Chưa đăng nhập nên đưa vào trang đăng nhập
        request.getRequestDispatcher("/views/client/pages/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy thông tin từ form login
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        // Mã hóa password
        password = Util.hashPassword(password);
        
        userDAO service = new userDAO();
        userModel user = service.getUserByEmail(email);
        Map<String, String> alert = new HashMap<>();
        if(user == null) {
           alert.put("type", "error");
           alert.put("msg", "Email không tồn tại trong hệ thống!");
           request.setAttribute("alert", alert);
           HttpSession session = request.getSession(false);
           session.setAttribute("alert", alert);
           request.getRequestDispatcher("/views/client/pages/login.jsp").forward(request, response);
           return;
        }
        
        if(!password.equals(user.getPassword())) {
           alert.put("type", "error");
           alert.put("msg", "Mật khẩu không chính xác!");
           request.setAttribute("alert", alert);
           HttpSession session = request.getSession(false);
           session.setAttribute("alert", alert);
           request.getRequestDispatcher("/views/client/pages/login.jsp").forward(request, response);
           return;
        }
        
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
        alert.put("msg", "Đăng nhập thành công!");
        request.setAttribute("alert", alert);
        session.setAttribute("alert", alert);
//        request.getRequestDispatcher("/views/client/pages/home.jsp").forward(request, response); 
        response.sendRedirect("./");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
