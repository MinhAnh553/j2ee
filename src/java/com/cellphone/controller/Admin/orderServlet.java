package com.cellphone.controller.Admin;

import com.cellphone.dao.InvoiceDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/admin/orderServlet")
public class orderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Thiết lập kiểu dữ liệu phản hồi
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Khởi tạo DAO
        InvoiceDAO invoiceDAO = new InvoiceDAO();

        try (PrintWriter out = response.getWriter()) {
            // Lấy tham số từ yêu cầu
            String action = request.getParameter("action");
            int orderId = Integer.parseInt(request.getParameter("id")); // ID của đơn hàng

            if ("updateStatus".equals(action)) {
                // Lấy trạng thái hiện tại từ yêu cầu
                int currentStatus = Integer.parseInt(request.getParameter("currentStatus"));
                int receiveMethod = Integer.parseInt(request.getParameter("receiveMethod")); // Phương thức nhận hàng

                // Xác định trạng thái kế tiếp
                int nextStatus;
                if (currentStatus == 2 && receiveMethod == 0) {
                    nextStatus = 4; // Nhận tại cửa hàng
                } else if (currentStatus == 2 && receiveMethod == 1) {
                    nextStatus = 3; // Giao hàng tận nơi
                } else {
                    nextStatus = currentStatus + 1;
                }

                // Cập nhật trạng thái trong CSDL
                boolean isUpdated = invoiceDAO.updateOrderStatus(orderId, nextStatus);

                // Gửi phản hồi JSON
                if (isUpdated) {
                    out.write("{\"success\": true, \"message\": \"Cập nhật trạng thái thành công!\"}");
                } else {
                    out.write("{\"success\": false, \"message\": \"Cập nhật trạng thái thất bại!\"}");
                }

            } else if ("cancelOrder".equals(action)) {
                // Cập nhật trạng thái thành 5 để hủy đơn hàng
                boolean isCancelled = invoiceDAO.updateOrderStatus(orderId, 5);

                // Gửi phản hồi JSON
                if (isCancelled) {
                    out.write("{\"success\": true, \"message\": \"Đơn hàng đã được hủy!\"}");
                } else {
                    out.write("{\"success\": false, \"message\": \"Hủy đơn hàng thất bại!\"}");
                }

            } else {
                // Hành động không hợp lệ
                out.write("{\"success\": false, \"message\": \"Hành động không hợp lệ!\"}");
            }
        } catch (NumberFormatException e) {
            // Lỗi do dữ liệu không đúng định dạng
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"success\": false, \"message\": \"Dữ liệu không hợp lệ!\"}");
        } catch (Exception e) {
            // Lỗi khác
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"success\": false, \"message\": \"Có lỗi xảy ra!\"}");
        }
    }
}
