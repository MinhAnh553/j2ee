<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.cellphone.model.userModel" %>
<%@ page import="java.util.*, java.text.*, java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>FunPhone - Chọn hình thức nhận hàng</title>
        <link
            rel="shortcut icon"
            href="./assets/img/favicon.png"
            type="image/x-icon"
        />
        <!-- Font -->
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link
            href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500&display=swap"
            rel="stylesheet"
        />

        <!-- Bootstrap CSS -->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
            crossorigin="anonymous"
        />

        <!-- Font Awesome -->
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
            integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
        />

        <!-- Custom CSS -->
        <link rel="stylesheet" href="./assets/css/styles.css" />
    </head>

    <body>
        <jsp:include page="../partials/header.jsp"></jsp:include>
        
        <!-- Main Content -->
        <!-- Main Content -->
        <main class="payment-main py-5">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-8 col-md-10 col-12">
                    <!-- Card for form -->
                    <div class="card shadow-sm">
                        <div class="card-body">
                            <h2 class="section__heading text-center mb-4">Thông tin thanh toán</h2>
                            <h5 class="mt-3">Sản phẩm:</h5>
                                    <ul class="list-group">
                                        <!-- Assuming you have a cart object to iterate over -->
                                    <c:set var="totalPrice" value="0" />
                                    <c:forEach var="item" items="${sessionScope.cart}">
                                        <li class="list-group-item">
                                            <span>${item.productName}</span> 
                                            <span class="float-end">Số lượng: ${item.productQuantity} - <fmt:formatNumber value="${item.productPrice*item.productQuantity}" type="currency" currencySymbol="VNĐ" /></span>
                                        </li>

                                        <c:set var="totalPrice" value = "${totalPrice + item.productPrice*item.productQuantity}" />
                                    </c:forEach>
                                </ul>
                                <h5 class="price-total">Tổng thanh toán: <fmt:formatNumber value="${totalPrice}" type="currency" currencySymbol="VNĐ" />
                            </h5><br>

                            <h5 class="mt-3">Thông tin nhận hàng:</h5>
                            <ul class="list-group">
                                <li class="list-group-item">Khách hàng: ${sessionScope.account.fullName}</li>
                                <li class="list-group-item">Số điện thoại: ${sessionScope.account.phone}</li>
                                <li class="list-group-item">Email: ${sessionScope.account.email}</li>
                                <li class="list-group-item">Phương thức giao hàng: ${param.deliveryMethod}</li>
                                <c:if test="${param.receiveMethod == '1'}">
                                    <li class="list-group-item">Nhận hàng tại: ${param.address}</li>
                                </c:if>
                                <c:if test="${param.receiveMethod == '1'}">
                                    <li class="list-group-item">Người nhận: ${param.name} - ${param.phone}</li>
                                </c:if>
                                <li class="list-group-item">Ghi chú: ${param.orderNote}</li>
                            </ul>
                            <h5 class="mt-3">Chọn phương thức thanh toán:</h5>
                            <form action="/project_j2ee/ConfirmPaymentServlet" method="POST" id="codForm">
                                <!-- Phương thức thanh toán khi nhận hàng -->
                                <div class="form-check">
                                    <input class="form-check-input" type="hidden" name="paymentMethod" value="cashOnDelivery" checked>
                                    <label class="form-check-label" for="cashOnDelivery">Thanh toán khi nhận hàng</label>
                                </div>

                                <!-- Các thông tin đơn hàng khác -->
                                <input type="hidden" name="order_id" value="${param.order_id}">
                                <input type="hidden" name="total" value="${param.total}">
                                <input type="hidden" name="name" value="${param.name}">
                                <input type="hidden" name="phone" value="${param.phone}">
                                <input type="hidden" name="deliveryMethod" value="${param.deliveryMethod}">
                                <input type="hidden" name="receiveMethod" value="${param.receiveMethod}">
                                <input type="hidden" name="address" value="${param.address}">
                                <input type="hidden" name="orderNote" value="${param.orderNote}">

                                <button type="submit" class="btn btn-primary btn-lg">
                                    <i class="fa fa-check-circle"></i> Xác nhận thanh toán
                                </button>
                            </form>
                            <form action="/project_j2ee/OnlinePaymentServlet" method="POST" id="onlineForm">
                                <!-- Phương thức thanh toán online -->
                                <div class="form-check">
                                    <input class="form-check-input" type="hidden" name="paymentMethod" value="creditCard">
                                    <label class="form-check-label" for="creditCard">Thanh toán online</label>
                                </div>

                                <!-- Các thông tin đơn hàng khác -->
                                <input type="hidden" name="order_id" value="${param.order_id}">
                                <input type="hidden" name="total" value="${param.total}">
                                <input type="hidden" name="name" value="${param.name}">
                                <input type="hidden" name="phone" value="${param.phone}">
                                <input type="hidden" name="deliveryMethod" value="${param.deliveryMethod}">
                                <input type="hidden" name="receiveMethod" value="${param.receiveMethod}">
                                <input type="hidden" name="address" value="${param.address}">
                                <input type="hidden" name="orderNote" value="${param.orderNote}">

                                <button type="submit" class="btn btn-primary btn-lg">
                                    <i class="fa fa-check-circle"></i> Xác nhận thanh toán
                                </button>
                            </form>                         
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>

        <script src="./assets/js/cart.js"></script>
        <script src="./assets/js/order.js"></script>
        <script src="./assets/js/search.js"></script>
        <script src="./assets/js/user.js"></script>
    </body>
    <jsp:include page="../partials/footer.jsp"></jsp:include>
</html>