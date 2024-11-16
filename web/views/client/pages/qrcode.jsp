<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Mã QR Thanh Toán</title>
    <!-- Thêm CSS nếu cần -->
</head>
<body>

    <h2 class="text-center">Mã QR Thanh Toán</h2>
    <div class="text-center">
        <!-- Lấy URL mã QR từ request -->
        <c:if test="${not empty requestScope.qrCodeUrl}">
            <img src="${requestScope.qrCodeUrl}" alt="QR Code thanh toán" />
        </c:if>
    </div>

    <br />
</body>
</html>
