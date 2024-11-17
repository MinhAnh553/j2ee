<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>FunPhone</title>
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

        <!-- Rest CSS -->
        <link rel="stylesheet" href="./assets/css/reset.css" />
        <!-- Bootstrap -->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
            crossorigin="anonymous"
        />
        <!-- Slick Slider -->
        <link
            rel="stylesheet"
            type="text/css"
            href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"
        />
        <!-- Font Awesome -->
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
            integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
        />
        <!-- CSS -->
        <link rel="stylesheet" href="./assets/css/styles.css" />
        <link rel="stylesheet" href="./assets/css/infoProduct.css" />
        <link rel="stylesheet" href="./assets/css/cart.css" />
        <link rel="stylesheet" href="./assets/css/responsive.css" />
        <!-- JS -->
        <script src="./assets/js/main.js"></script>
    </head>
    <body>
        <jsp:include page="../partials/header.jsp"></jsp:include>
        <main class="cart-main">
            <form action="/project_j2ee/OrderServlet" method="POST">
            <div class="cart-container container">
                <div class="cart__list container mt-4">
                    <h2 class="section__heading ms-3 my-2">Giỏ hàng</h2>
                    <table class="table table-hover table-sm mt-3">
                        <thead>
                            <tr>
                                <th>Ảnh</th>
                                <th>Tên sản phẩm</th>
                                <th>Giá</th>
                                <th>Số lượng</th>
                                <th>Thành tiền</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody class="cart__content">
                            <!-- Duyệt qua danh sách sản phẩm trong giỏ và hiển thị -->
                        <c:set var="totalPrice" value="0" />
                            <c:forEach var="item" items="${sessionScope.cart}">
                                <tr>
                                    <td>
                                        <img src="${item.productImage}" alt="${item.productName}" width="50" />
                                    </td>
                                    <td>${item.productName}</td>
                                    <td><fmt:formatNumber value="${item.productPrice}" type="currency" currencySymbol="VNĐ" /></td>
                                    <td>
                                        <input type="number" value="${item.productQuantity}" min="1" class="form-control" data-product-id="${item.productId}" />
                                    </td>
                                    <td>
                                        <fmt:formatNumber value="${item.productPrice*item.productQuantity}" type="currency" currencySymbol="VNĐ" />
                                    </td>
                                    <td>
                                        <button class="btn btn-danger remove-item" data-product-id="${item.productId}">Xóa</button>
                                    </td>
                                </tr>
                                <c:set var="totalPrice" value = "${totalPrice + item.productPrice*item.productQuantity}" />
                            </c:forEach>
                        </tbody>
                        
                    </table>
                    <div
                        class="info__right-groupbtn row d-flex justify-content-around align-items-center my-5 me-1"
                    >
                        <div class="total-cost money">
                            <input type="hidden" name="totalPrice" value="${totalPrice}" />
                            <h2 class="price-total">Tổng thanh toán: <fmt:formatNumber value="${totalPrice}" type="currency" currencySymbol="VNĐ" />
                            </h2>
                            <button
                                class="groupbtn__order col-lg-6 col-md-6 col py-3 order-product"
                                
                            >
                                <i class="fa fa-calendar"></i> ĐẶT HÀNG
                            </button>
                        </div>
                    </div>
                </div>
            </div>
            </form>
        </main>

        <script src="./assets/js/cart.js"></script>
        <script src="./assets/js/order.js"></script>
        <script src="./assets/js/search.js"></script>
        <script src="./assets/js/user.js"></script>
    </body>
    <jsp:include page="../partials/footer.jsp"></jsp:include>
</html>
