<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>QR Code Payment</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
        }
        .qr-payment-container {
            background: #ffffff;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            padding: 20px;
            text-align: center;
            max-width: 400px;
            width: 90%;
        }
        .qr-payment-container h1 {
            font-size: 24px;
            margin-bottom: 20px;
            color: #333333;
        }
        .qr-code {
            margin-bottom: 20px;
        }
        .qr-code img {
            max-width: 100%;
            height: auto;
            border-radius: 8px;
            border: 2px solid #e0e0e0;
        }
        .instruction {
            font-size: 16px;
            color: #555555;
        }
        .button-container {
            margin-top: 20px;
        }
        .button-container a {
            display: inline-block;
            background-color: #007bff;
            color: #ffffff;
            text-decoration: none;
            padding: 10px 20px;
            border-radius: 4px;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }
        .button-container a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="qr-payment-container">
        <h1>Thanh Toán QR</h1>
        <div class="qr-code">
            <c:if test="${not empty requestScope.qrCodeUrl}">
                <img src="${requestScope.qrCodeUrl}" alt="QR Code thanh toán">
            </c:if>
        </div>
        <p class="instruction">Quét mã QR bằng ứng dụng ngân hàng hoặc ví điện tử của bạn để hoàn tất thanh toán.</p>
        <div class="button-container">
            <a href="javascript:history.back()">Quay về</a>
        </div>
    </div>
</body>
</html>

