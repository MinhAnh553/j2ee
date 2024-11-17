package com.cellphone.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.cellphone.model.Invoice;
import com.cellphone.model.ProductDetail;
import static com.cellphone.model.ProductDetail.parseJsonArray;

public class InvoiceDAO {

    private static final String DB_URL = "jdbc:mysql://103.74.101.111:3306/cellphone?useSSL=false";
    private static final String DB_USER = "cellphone";
    private static final String DB_PASSWORD = "cellphone";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public List<Invoice> getInvoices() {
        List<Invoice> invoices = new ArrayList<>();
        String query = """
                SELECT o.id, o.created_at, u1.fullName AS cashier, u2.fullName AS customer, 
                                                   o.total, o.payment_id, o.receive_method, o.status,
                                                   (SELECT JSON_ARRAYAGG(
                                                           JSON_OBJECT(
                                                               'productName', p.name, 
                                                               'typeByColor', p.typeByColor, 
                                                               'quantity', od.quantity, 
                                                               'unitPrice', p.price
                                                           )
                                                       )
                                                    FROM order_detail od 
                                                    JOIN product p ON od.product_id = p.id 
                                                    WHERE od.order_id = o.id
                                                   ) AS productDetails
                                            FROM `order` o
                                            JOIN users u1 ON o.cashier_id = u1.id
                                            JOIN users u2 ON o.user_id = u2.id;
                """;

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // Kiểm tra các giá trị NULL
                if (rs.getTimestamp("created_at") == null || rs.getString("cashier") == null ||
                    rs.getString("customer") == null || rs.getString("productDetails") == null) {
                    // Bỏ qua dòng này nếu có giá trị NULL
                    continue;
                }

                Invoice invoice = new Invoice();
                invoice.setOrderId(rs.getInt("id"));
                invoice.setTimestamp(rs.getTimestamp("created_at"));
                invoice.setCashier(rs.getString("cashier"));
                invoice.setCustomer(rs.getString("customer"));
                invoice.setTotalPrice(rs.getDouble("total"));
                invoice.setPaymentId(rs.getInt("payment_id"));
                invoice.setReceiveMethod(rs.getInt("receive_method"));
                invoice.setStatus(rs.getInt("status"));

                // Parse JSON productDetails thành danh sách sản phẩm
                String productDetailsJson = rs.getString("productDetails");
                List<ProductDetail> productDetails = parseJsonArray(productDetailsJson);
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
    try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setInt(1, status);
        stmt.setInt(2, orderId);
        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

}
