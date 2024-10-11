package com.cellphone.controller;

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

@WebServlet(name = "logout", urlPatterns = {"/logout"})
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        session.removeAttribute("account");
        
        Cookie accessToken = new Cookie("accessToken", null); 
        accessToken.setMaxAge(0);
        response.addCookie(accessToken);
        
        Map<String, String> alert = new HashMap<>();
        alert.put("type", "success");
        alert.put("msg", "Đăng xuất thành công!");
        request.setAttribute("alert", alert);
        
        request.getRequestDispatcher("./").forward(request, response);   
    }
}
