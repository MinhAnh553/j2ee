package com.cellphone.controller.Admin;

import com.cellphone.dao.InvoiceDAO;
import com.cellphone.model.Invoice;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/invoice")
public class InvoiceServlet extends HttpServlet {

    private InvoiceDAO invoiceDAO;

    @Override
    public void init() throws ServletException {
        invoiceDAO = new InvoiceDAO(); // Khởi tạo DAO
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Lấy danh sách hóa đơn từ DAO
            InvoiceDAO invoiceDAO = new InvoiceDAO();
            List<Invoice> invoices = invoiceDAO.getInvoices();

            // Gắn danh sách hóa đơn vào request để truyền đến JSP
            request.setAttribute("invoices", invoices);

            // Chuyển hướng đến trang JSP
            request.getRequestDispatcher("/views/admin/pages/invoice.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Có lỗi xảy ra khi xử lý yêu cầu hóa đơn!", e);
        }
    }

}
