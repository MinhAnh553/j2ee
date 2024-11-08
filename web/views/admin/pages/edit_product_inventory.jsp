<%@page import="com.cellphone.dao.brandDAO"%>
<%@page import="com.cellphone.model.Product"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.cellphone.model.brandModel" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cập nhật tồn kho</title>
    <!-- Bootstrap -->
    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
        crossorigin="anonymous"
    />
    <!-- CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/simple-notify@1.0.4/dist/simple-notify.css" />
    <style>
        .card-header-ct {
            background-color: #28a745; /* Màu xanh cho phần header Cộng Tiền */
            color: white;
        }

        .card-header-tt {
            background-color: #dc3545; /* Màu đỏ cho phần header Trừ Tiền */
            color: white;
        }

        .btn-confirm {
            background-color: #007bff; /* Màu xanh của nút Xác nhận */
            color: white;
            width: 100%;
        }

        .form-group label {
            font-weight: bold;
        }
        
        .center-container {
            display: flex;
            flex-direction: column;
            align-items: center;
            min-height: 100vh;
            gap: 20px;
        }

        .product-info {
            max-width: 600px;
            width: 100%;
            margin-bottom: 20px;
        }

        .actions-row {
            display: flex;
            justify-content: center;
            gap: 20px;
            width: 100%;
            max-width: 1000px;
        }

        .back-button {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <%
        Product product = (Product) request.getAttribute("product");
    %>
    <div class="container center-container">
        <!-- Nút quay lại -->
        <div class="back-button mt-3">
            <a href="javascript:history.back()" class="btn btn-secondary">Quay lại</a>
        </div>

        <!-- Thông tin sản phẩm -->
        <div class="card product-info">
            <div class="card-header">
                Thông Tin Sản Phẩm
            </div>
            <div class="card-body">
                <p><strong>Tên sản phẩm:</strong> <%= product.getName() %></p>
                <p><strong>Hãng:</strong> <%= product.getBrand() %></p>
                <p><strong>Giá:</strong> <%= product.getPrice() %>₫</p>
                <p><strong>Màu sắc:</strong> <%= product.getTypeByColor() %></p>
            </div>
        </div>

        <!-- Cộng trừ số lượng -->
        <div class="actions-row">
            <div class="card col-md-5">
                <div class="card-header card-header-ct">
                    NHẬP HÀNG
                </div>
                <div class="card-body">
                    <form method="POST">
                        <div class="form-group">
                            <label for="amount-add">Số lượng</label>
                            <input type="number" class="form-control" id="amount-add" name="value" placeholder="">
                        </div>
                        <div class="form-group my-3">
                            <label for="note-add">Ghi chú</label>
                            <textarea class="form-control" id="note-add" name="note" rows="3" placeholder="Nhập ghi chú nếu có"></textarea>
                        </div>
                        <button type="submit" name="btnNhapHang" class="btn btn-confirm">XÁC NHẬN</button>
                    </form>
                </div>
            </div>

            <div class="card col-md-5">
                <div class="card-header card-header-tt">
                    XUẤT HÀNG
                </div>
                
                <div class="card-body">
                    <form method="POST">
                        <div class="form-group">
                            <label for="amount-subtract">Số lượng</label>
                            <input type="number" class="form-control" id="amount-subtract" name="value" placeholder="">
                        </div>
                        <div class="form-group my-3">
                            <label for="note-subtract">Ghi chú</label>
                            <textarea class="form-control" id="note-subtract" name="note" rows="3" placeholder="Nhập ghi chú nếu có"></textarea>
                        </div>
                        <button type="submit" name="btnXuatHang" class="btn btn-confirm">XÁC NHẬN</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- JS -->
    <script src="https://cdn.jsdelivr.net/npm/simple-notify@1.0.4/dist/simple-notify.min.js"></script>
</body>
</html>


