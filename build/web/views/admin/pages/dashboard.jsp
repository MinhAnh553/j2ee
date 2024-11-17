<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
            />
        <title>Trang quản trị</title>
        <!--     Fonts and icons     -->
        <link
            href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700"
            rel="stylesheet"
            />
        <!-- Nucleo Icons -->
        <link href="./assets/css/nucleo-icons.css" rel="stylesheet" />
        <link href="./assets/css/nucleo-svg.css" rel="stylesheet" />
        <!-- CSS Files -->
        <link
            id="pagestyle"
            href="./assets/css/argon-dashboard.css?v=2.0.4"
            rel="stylesheet"
            />
    </head>

    <body>
        <jsp:include page="../partials/sidebar.jsp"></jsp:include>
        
        <main class="main-content position-relative border-radius-lg">
            <h5 style="color: white">
                Welcome back<br />Have a good day, Admin!
            </h5>
        </main>
        
        <!--   Core JS Files   -->
        <script src="${pageContext.request.contextPath}/assets/js/admin.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/core/popper.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/core/bootstrap.min.js"></script>
    </body>
</html>
