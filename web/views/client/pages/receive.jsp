<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="com.cellphone.model.userModel;" %>
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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/responsive.css" />
    </head>

    <body>
        <jsp:include page="../partials/header.jsp"></jsp:include>

            <!-- Main Content -->
            <main class="payment-main py-5">
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-lg-8 col-md-10 col-12">
                            <!-- Card for form -->
                            <div class="card shadow-sm">
                                <div class="card-body">
                                    <h2 class="section__heading text-center mb-4">Chọn hình thức nhận hàng</h2>

                                    <h5 class="mt-3">Sản phẩm:</h5>
                                    <ul class="list-group">
                                        <!-- Assuming you have a cart object to iterate over -->
                                    <c:set var="totalPrice" value="0" />
                                    <c:forEach var="item" items="${sessionScope.cart}">
                                        <li class="list-group-item">
                                            <span>${item.productName}</span> 
                                            <span class="float-end">Số lượng: ${item.productQuantity} - <fmt:formatNumber value="${item.productPrice*item.productQuantity}" type="currency" currencySymbol="VNĐ" maxFractionDigits="0"/></span>
                                        </li>

                                        <c:set var="totalPrice" value = "${totalPrice + item.productPrice*item.productQuantity}" />
                                    </c:forEach>
                                </ul><br>
                                <h5 class="mt-3">Thông tin khách hàng</h5>
                                <input type ="text" value ="${sessionScope.account.fullName}">
                                <input type ="text" value ="${sessionScope.account.email}">
                                <input type ="text" value ="${sessionScope.account.phone}">
                                <form action="${pageContext.request.contextPath}/payments" method="GET">
                                    <!-- Delivery Method: Store Pickup -->
                                    <div class="form-check">
                                        <input type="hidden" name="order_id" value="<%= request.getAttribute("order_id") %>" />
                                        <input type="hidden" name="total" value="<%= request.getAttribute("total") %>" />
                                        <input class="form-check-input" type="radio" name="deliveryMethod" id="storePickup" value="store" checked>
                                        <label class="form-check-label" for="storePickup">Nhận tại cửa hàng</label>
                                    </div>

                                    <!-- Delivery Method: Home Delivery -->
                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" name="deliveryMethod" id="homeDelivery" value="home">
                                        <label class="form-check-label" for="homeDelivery">Giao hàng tận nơi</label>
                                    </div>
                                    <div id="nameSection" class="mt-3" style="display: none;">
                                        <label for="name">Tên người nhận:</label>
                                        <input type="text" class="form-control" id="name" name="name" value="${sessionScope.account.fullName}">
                                    </div>
                                    <div id="phoneSection" class="mt-3" style="display: none;">
                                        <label for="phone">SĐT người nhận:</label>
                                        <input type="text" class="form-control" id="phone" name="phone" value="${sessionScope.account.phone}">
                                    </div>

                                    <!-- Address Section -->
                                    <div id="addressSection" class="mt-3" style="display: none;">
                                        <label for="address">Nhập địa chỉ giao hàng:</label>
                                        <input type="text" class="form-control" id="address" name="address" placeholder="Nhập địa chỉ giao hàng">
                                    </div>

                                    <!-- Order Note Section -->
                                    <div id="orderNoteSection" class="mt-3">
                                        <label for="orderNote">Ghi chú cho đơn hàng:</label>
                                        <textarea class="form-control" id="orderNote" name="orderNote" rows="3" placeholder="Nhập ghi chú cho đơn hàng (nếu có)"></textarea>
                                    </div>

                                    <!-- Hidden input to store the receive method (0 for store, 1 for home delivery) -->
                                    <input type="hidden" id="receiveMethod" name="receiveMethod" value="0">

                                    <!-- Submit Button -->
                                    <div class="text-center mt-4">
                                        <button type="submit" class="btn btn-primary btn-lg">
                                            <i class="fa fa-check-circle"></i> Xác nhận
                                        </button>
                                    </div>
                                </form>


                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>

        <!-- JavaScript to handle the visibility of address input and order note -->
        <script>
            // Lấy các phần tử cần thiết từ DOM
            const homeDelivery = document.getElementById("homeDelivery");
            const storePickup = document.getElementById("storePickup");
            const nameSection = document.getElementById("nameSection");
            const phoneSection = document.getElementById("phoneSection");
            const addressSection = document.getElementById("addressSection");
//            const orderNoteSection = document.getElementById("orderNoteSection");
            const receiveMethodInput = document.getElementById("receiveMethod"); // Input ẩn lưu phương thức giao hàng

            // Xử lý thay đổi phương thức giao hàng
            homeDelivery.addEventListener('change', function () {
                if (homeDelivery.checked) {
                    nameSection.style.display = "block";
                    phoneSection.style.display = "block";
                    addressSection.style.display = "block";  // Hiển thị ô nhập địa chỉ
//                    orderNoteSection.style.display = "block";  // Hiển thị ô ghi chú
                    receiveMethodInput.value = "1";  // Giao tận nơi
                }
            });

            storePickup.addEventListener('change', function () {
                if (storePickup.checked) {
                    nameSection.style.display = "none";
                    phoneSection.style.display = "none";
                    addressSection.style.display = "none";  // Ẩn ô nhập địa chỉ
//                    orderNoteSection.style.display = "none";  // Ẩn ô ghi chú
                    receiveMethodInput.value = "0";  // Nhận tại cửa hàng
                }
            });

            // Cập nhật giá trị mặc định của phương thức giao hàng khi load trang
            document.addEventListener('DOMContentLoaded', function () {
                if (storePickup.checked) {
                    receiveMethodInput.value = "0";  // Mặc định là nhận tại cửa hàng
                } else {
                    receiveMethodInput.value = "1";  // Nếu chọn giao tận nơi
                }
            });

        </script>


        <script src="./assets/js/cart.js"></script>
        <script src="./assets/js/order.js"></script>
        <script src="./assets/js/search.js"></script>
        <script src="./assets/js/user.js"></script>

        <jsp:include page="../partials/footer.jsp"></jsp:include>
    </body>
</html>
