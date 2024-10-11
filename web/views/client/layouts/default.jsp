<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  
    String pageTitle = (String) request.getAttribute("pageTitle");
%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title><%=pageTitle%></title>
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
        
        <script
            type="text/javascript"
            src="https://code.jquery.com/jquery-1.11.0.min.js"
        ></script>
        <script
            type="text/javascript"
            src="https://code.jquery.com/jquery-migrate-1.2.1.min.js"
        ></script>
        <script
            type="text/javascript"
            src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"
        ></script>
        <!-- CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/simple-notify@1.0.4/dist/simple-notify.css" />

        <!-- JS -->
        <script src="https://cdn.jsdelivr.net/npm/simple-notify@1.0.4/dist/simple-notify.min.js"></script>
        
        <!-- CSS -->
        <link rel="stylesheet" href="./assets/css/styles.css" />
        <link rel="stylesheet" href="./assets/css/app.css" />
        <link rel="stylesheet" href="./assets/css/login.css" />
        <link rel="stylesheet" href="./assets/css/responsive.css" />
    </head>

    <body>
        
        <jsp:include page="../partials/header.jsp"></jsp:include>
        
        <% 
            Map<String, String> alert = (Map<String, String>) request.getAttribute("alert");
            if (alert != null) {
        %>
            <script>
                new Notify({
                    title: 'Thông báo!',
                    text: '<%= alert.get("msg") %>',
                    status: '<%= alert.get("type") %>',
                    effect: 'slide',
                    speed: 300,
                    timeout: 3000,
                    customClass: 'notify-error'
                });
            </script>
        <% 
            }
        %>


        <!-- Nội dung của từng trang -->
        <%= request.getAttribute("mainContent") %>
       
        <script src="./assets/js/main.js"></script>
        <script src="./assets/js/app.js"></script>
        <script src="./assets/js/validations.js"></script>
        <script src="./assets/js/search.js"></script>

    </body>

    <jsp:include page="../partials/footer.jsp"></jsp:include>
</html>
