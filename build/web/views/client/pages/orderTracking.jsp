<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="com.cellphone.model.Order" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>FunPhone - Lịch sử Đơn hàng</title>

        <!-- Thêm Bootstrap và FontAwesome để tạo giao diện đẹp và dễ sử dụng -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">

        <style>
            body {
                font-family: 'Arial', sans-serif;
                background-color: #f4f7fa;
                padding-top: 30px;
            }

            .container {
                max-width: 900px;
                margin: 0 auto;
            }

            .order-item {
                background-color: #fff;
                border: 1px solid #ddd;
                padding: 20px;
                margin-bottom: 20px;
                border-radius: 10px;
                box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
                transition: transform 0.3s ease;
            }

            .order-item:hover {
                transform: scale(1.03);
                box-shadow: 0 4px 16px rgba(0, 0, 0, 0.2);
            }

            .order-item h5 {
                margin-bottom: 10px;
                font-size: 1.25em;
                color: #333;
            }

            .order-item p {
                font-size: 1.1em;
                color: #555;
            }

            .order-status {
                padding: 8px 12px;
                border-radius: 20px;
                font-weight: bold;
                display: inline-block;
            }

            .status-pending {
                background-color: #f8d7da;
                color: #721c24;
            }

            .status-paid {
                background-color: #d4edda;
                color: #155724;
            }

            .status-shipped {
                background-color: #cce5ff;
                color: #004085;
            }

            .alert-info {
                background-color: #d1ecf1;
                border-color: #bee5eb;
                padding: 20px;
                text-align: center;
                font-size: 1.1em;
            }

            .navbar {
                background-color: #007bff;
            }

            .navbar .navbar-brand {
                color: #fff;
            }
        </style>
    </head>

    <body>
        <!-- Thanh điều hướng -->

        <div class="container">
            <h2 class="text-center mb-5">Lịch sử Đơn hàng của bạn</h2>

            <%-- Lấy giá trị orders từ request --%>
            <%
                List<Order> orders = (List<Order>) request.getAttribute("orders");
                if (orders != null && !orders.isEmpty()) {
                    for (Order order : orders) {
            %>
                        <div class="order-item">
                            <h5><i class="fas fa-box"></i> Đơn hàng #<%= order.getId() %></h5>
                            <p><strong>Ngày đặt:</strong> <%= order.getCreatedAt() %></p>
                            <p><strong>Trạng thái đơn hàng:</strong>
                                <span class="order-status 
                                      <%= (order.getStatus() == 0) ? "status-pending" : (order.getStatus() == 1) ? "status-paid" : "status-canceled" %>">
                                    <%= (order.getStatus() == 0) ? "Đang chờ xử lí" : (order.getStatus() == 1) ? "Đã xử lí" : "Đã bị hủy" %>
                                </span>
                            </p>
                            <p><strong>Phương thức nhận hàng:</strong>
                                <%= (order.getReceiveMethod() == 0) ? "Nhận tại cửa hàng" : "Giao hàng tận nơi" %>
                            </p>
                            <p><strong>Tổng tiền:</strong> <%= order.getTotal() %> VNĐ</p>
                            <%-- Thêm nút hủy đơn khi đơn hàng chưa bị hủy --%>
                            <% if (order.getStatus() == 0) { %> <!-- Kiểm tra nếu đơn hàng đang chờ xử lý -->
                                <form action="/project_j2ee/CancelOrder" method="POST">
                                    <input type="hidden" name="orderId" value="<%= order.getId() %>">
                                    <button type="submit" class="btn btn-danger">
                                        <i class="fas fa-times"></i> Hủy đơn
                                    </button>
                                </form>
                            <% } %>
                            
                        </div>
            <%
                    }
                } else {
            %>
                    <div class="alert alert-info mt-4">
                        Bạn chưa có đơn hàng nào để theo dõi.
                    </div>
            <%
                }
            %>
        </div>

        <!-- Thêm Bootstrap và FontAwesome JS -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    </body>
</html>
