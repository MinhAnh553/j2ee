package com.cellphone.middleware;

import com.cellphone.model.userModel;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class authMiddleware {
    public static boolean isAuthorized(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        userModel user = (userModel) session.getAttribute("account");
        try {
            if(user == null) {
                response.sendRedirect("./login");
                return false;
            }
            
            return true;
        } catch(Exception e) {
            System.out.println("com.cellphone.middleware.authMiddleware.isAuthorized()" + e);
            return false;
        }  
    }
    
    public static boolean isAdmin(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        try {
            if(session != null) {
                userModel user = (userModel) session.getAttribute("account");
                if(user != null) {
                    if(user.getRole() != 0) {
                        Map<String, String> alert = new HashMap<>();
                        alert.put("type", "error");
                        alert.put("msg", "Bạn phải là Admin!");
                        request.setAttribute("alert", alert);
                        session.setAttribute("alert", alert);
                        response.sendRedirect("./");
                        return false;
                    }
                } else {
                    response.sendRedirect("./");
                    return false;
                }
            } else {
                response.sendRedirect("./");
                return false;
            }
            
            return true;
        } catch(Exception e) {
            System.out.println("com.cellphone.middleware.authMiddleware.isAdmin()" + e);
            return false;
        }
        
        
        
    }
}
