<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>Quản Lý Hoá Đơn</title>

        <!-- Fonts and icons -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/assets/css/nucleo-icons.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/assets/css/nucleo-svg.css" rel="stylesheet" />
        <link id="pagestyle" href="${pageContext.request.contextPath}/assets/css/argon-dashboard.css?v=2.0.4" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/assets/css/invoice.css" rel="stylesheet" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

<!--        <style>
           
            .invoice-table th, .invoice-table td {
                padding-bottom: 0px;
                text-align: center;
                border: 1px solid #ddd;
            }
        </style>-->
    </head>
    <body>
        <jsp:include page="../partials/sidebar.jsp"></jsp:include>
            <main class="main-content position-relative">
                <h4 style="color: white;
                    padding-top: 30px;
                    padding-left: 30px;
                    padding-bottom: 45px;
                    font-weight: bold;">
                    QUẢN LÍ HOÁ ĐƠN
                </h4>
                <div class="container">
                    <table class="invoice-table">
                        <thead style="padding: 10px">
                            <tr>
                                <th>Mã hoá đơn</th>
                                <th>Thời gian</th>
                                <th>Thu ngân</th>
                                <th>Khách hàng</th>
                                <th>Chi tiết hoá đơn</th>
                                <th>Tổng tiền</th>
                                <th>Phương thức thanh toán</th>
                                <th>Hình thức nhận hàng</th>
                                <th>Trạng thái</th>
                                <th>Huỷ</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="invoice" items="${invoices}">
                            <tr>
                                <td>${invoice.orderId}</td>
                                <td>${invoice.timestamp}</td>
                                <td>${invoice.cashier}</td>
                                <td>${invoice.customer}</td>
                                <td>
                                    <ul>
                                        <c:forEach var="product" items="${invoice.productDetails}">
                                            <li>${product.productName} - ${product.typeByColor}: 
                                                <fmt:formatNumber value="${product.unitPrice}" type="currency" currencySymbol="₫" groupingUsed="true" minFractionDigits="0" maxFractionDigits="0" /> x ${product.quantity}
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </td>
                                <td><fmt:formatNumber value="${invoice.totalPrice}" type="currency" currencySymbol="₫" groupingUsed="true" minFractionDigits="0" maxFractionDigits="0" /></td>
                                <td>
                                    <c:choose>
                                        <c:when test="${invoice.paymentId == 0}">Tiền mặt</c:when>
                                        <c:otherwise>Chuyển khoản</c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <c:choose>
                                        <c:when test="${invoice.receiveMethod == 0}">Nhận tại cửa hàng</c:when>
                                        <c:otherwise>Giao hàng tận nơi</c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <c:choose>
                                        <c:when test="${invoice.status == 0}">
                                            <button class="status-button status-waiting" id="status-btn-${invoice.orderId}" onclick="handleStatusUpdate(${invoice.orderId}, ${invoice.status}, ${invoice.receiveMethod})">Chờ xác nhận</button>
                                        </c:when>
                                        <c:when test="${invoice.status == 1}">
                                            <button class="status-button status-preparing" id="status-btn-${invoice.orderId}" onclick="handleStatusUpdate(${invoice.orderId}, ${invoice.status}, ${invoice.receiveMethod})">Đang chuẩn bị hàng</button>
                                        </c:when>
                                        <c:when test="${invoice.status == 2}">
                                            <button class="status-button status-ready" id="status-btn-${invoice.orderId}" onclick="handleStatusUpdate(${invoice.orderId}, ${invoice.status}, ${invoice.receiveMethod})">Sẵn sàng bàn giao</button>
                                        </c:when>
                                        <c:when test="${invoice.status == 3}">
                                            <button class="status-button status-shipped" id="status-btn-${invoice.orderId}" disabled>Đã bàn giao đơn vị vận chuyển</button>
                                        </c:when>
                                        <c:when test="${invoice.status == 4}">
                                            <button class="status-button status-completed" id="status-btn-${invoice.orderId}" disabled>Hoàn thành</button>
                                        </c:when>
                                        <c:when test="${invoice.status == 5}">
                                            <button class="status-button status-cancelled" id="status-btn-${invoice.orderId}" disabled>Đã hủy</button>
                                        </c:when>
                                    </c:choose>
                                </td>
                                <td>
                                    <c:choose>
                                        <c:when test="${invoice.status < 2}">
                                            <button class="cancel-button" id="cancel-btn-${invoice.orderId}" onclick="confirmCancel(${invoice.orderId})"><i class="fa-solid fa-xmark fa-l" style="color: #e63c1e;"></i></button>
                                            </c:when>
                                            <c:otherwise>
                                            <button class="cancel-button disabled" disabled><i class="fa-solid fa-xmark fa-l" style="color: #dcdbdb;"></i></button>
                                            </c:otherwise>
                                        </c:choose>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </main>
        <script src="${pageContext.request.contextPath}/assets/js/invoice.js"></script>
    </body>
</html>
