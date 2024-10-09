<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    
    String mainContent = "<main>\n" +
        "    <section class=\"form_login\">\n" +
        "        <form action=\"\" method=\"POST\" class=\"form\" id=\"form-1\">\n" +
        "            <h3 class=\"heading\">Đăng nhập</h3>\n" +
        "            <div class=\"spacer\"></div>\n" +
        "            <div class=\"form-group\">\n" +
        "                <label for=\"account\" class=\"form-label\">Tài khoản</label>\n" +
        "                <input id=\"account\" name=\"account\" type=\"text\" placeholder=\"Nhập tài khoản\" class=\"form-control\" />\n" +
        "                <span class=\"form-message\"></span>\n" +
        "            </div>\n" +
        "            <div class=\"form-group\">\n" +
        "                <label for=\"password\" class=\"form-label\">Mật khẩu</label>\n" +
        "                <input id=\"password\" name=\"password\" type=\"password\" placeholder=\"Nhập mật khẩu\" class=\"form-control\" />\n" +
        "                <span class=\"form-message\"></span>\n" +
        "            </div>\n" +
        "            <button class=\"form-submit\" onclick=\"showSuccessToast();\">Đăng nhập</button>\n" +
        "            <div class=\"form-group Sign-Up\">\n" +
        "                <p>Bạn chưa có tài khoản? <a href=\"register\">Đăng ký</a></p>\n" +
        "            </div>\n" +
        "        </form>\n" +
        "        <div id=\"notification\" role=\"alert\">\n" +
        "            <span id=\"contentNotification\"> </span>\n" +
        "        </div>\n" +
        "    </section>\n" +
        "</main>";


    request.setAttribute("mainContent", mainContent);
%>

<jsp:include page="../layouts/default.jsp">
    <jsp:param name="pageTitle" value="Trang chủ"/>
</jsp:include>

