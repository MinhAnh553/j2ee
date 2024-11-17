package com.cellphone.dao;

import com.cellphone.model.DatabaseConnection;
import com.cellphone.model.Invoice;
import com.cellphone.model.ProductDetail;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static com.cellphone.model.ProductDetail.parseJsonArray;

public class InvoiceDAO {

    public List<Invoice> getInvoices() {
        List<Invoice> invoices = new ArrayList<>();
        String query = """
                SELECT o.id, o.created_at, u1.fullName AS cashier, u2.fullName AS customer, 
                       o.total, o.payment_id, o.receive_method, o.status
                FROM `order` o
                JOIN users u1 ON o.cashier_id = u1.id
                JOIN users u2 ON o.user_id = u2.id;
                """;

        String productQuery = """
                SELECT p.name AS productName, p.typeByColor, od.quantity, p.price AS unitPrice
                FROM order_detail od
                JOIN product p ON od.product_id = p.id
                WHERE od.order_id = ?;
                """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // Kiểm tra các giá trị NULL
                if (rs.getTimestamp("created_at") == null || rs.getString("cashier") == null ||
                    rs.getString("customer") == null) {
                    // Bỏ qua dòng này nếu có giá trị NULL
                    continue;
                }

                // Tạo Invoice
                Invoice invoice = new Invoice();
                invoice.setOrderId(rs.getInt("id"));
                invoice.setTimestamp(rs.getTimestamp("created_at"));
                invoice.setCashier(rs.getString("cashier"));
                invoice.setCustomer(rs.getString("customer"));
                invoice.setTotalPrice(rs.getDouble("total"));
                invoice.setPaymentId(rs.getInt("payment_id"));
                invoice.setReceiveMethod(rs.getInt("receive_method"));
                invoice.setStatus(rs.getInt("status"));

                // Lấy danh sách sản phẩm liên quan đến order
                List<ProductDetail> productDetails = new ArrayList<>();
                try (PreparedStatement productStmt = conn.prepareStatement(productQuery)) {
                    productStmt.setInt(1, rs.getInt("id"));
                    try (ResultSet productRs = productStmt.executeQuery()) {
                        while (productRs.next()) {
                            ProductDetail detail = new ProductDetail();
                            detail.setProductName(productRs.getString("productName"));
                            detail.setTypeByColor(productRs.getString("typeByColor"));
                            detail.setQuantity(productRs.getInt("quantity"));
                            detail.setUnitPrice(productRs.getDouble("unitPrice"));
                            productDetails.add(detail);
                        }
                    }
                }
                invoice.setProductDetails(productDetails);

                // Thêm invoice hợp lệ vào danh sách
                invoices.add(invoice);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invoices;
    }


    public boolean updateOrderStatus(int orderId, int status) {
    String query = "UPDATE `order` SET status = ? WHERE id = ?";
    try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setInt(1, status);
        stmt.setInt(2, orderId);
        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

}
