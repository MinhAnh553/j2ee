<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    request.setAttribute("pageTitle", "Đăng ký");
    String mainContent = 
        "<main>\n" +
        "    <section class=\"form_login form_register\">\n" +
        "        <form action=\"\" method=\"POST\" class=\"form formRegister\" id=\"form-2\"> \n" +
        "            <h3 class=\"heading\">Đăng ký thành viên</h3>\n" +
        "            <div class=\"spacer\"></div>\n" +
        "            <div class=\"form-group\">\n" +
        "                <label for=\"fullname\" class=\"form-label\">Tên đầy đủ</label>\n" +
        "                <input id=\"fullname\" name=\"fullname\" type=\"text\" placeholder=\"VD: Nguyễn Văn A\" required class=\"form-control\" />\n" +
        "                <span class=\"form-message\"></span>\n" +
        "            </div>\n" +
        "            <div class=\"form-group\">\n" +
        "                <label for=\"email\" class=\"form-label\">Email</label>\n" +
        "                <input id=\"email\" name=\"email\" type=\"email\" placeholder=\"VD: funphone1\" required class=\"form-control\" />\n" +
        "                <span class=\"form-message\"></span>\n" +
        "            </div>\n" +
        "            <div class=\"form-group\">\n" +
        "                <label for=\"password\" class=\"form-label\">Mật khẩu</label>\n" +
        "                <input id=\"password\" name=\"password\" type=\"password\" placeholder=\"Nhập mật khẩu\" required class=\"form-control\" />\n" +
        "                <span class=\"form-message\"></span>\n" +
        "            </div>\n" +
        "            <div class=\"form-group\">\n" +
        "                <label for=\"password_confirmation\" class=\"form-label\">Nhập lại mật khẩu</label>\n" +
        "                <input id=\"password_confirmation\" name=\"password_confirmation\" type=\"password\" required placeholder=\"Nhập lại mật khẩu\" class=\"form-control\" />\n" +
        "                <span class=\"form-message\"></span>\n" +
        "            </div>\n" +
        "            <button class=\"form-submit\">Đăng ký</button>\n" +
        "        </form>\n" +
        "    </section>\n" +
        "</main>";
    request.setAttribute("mainContent", mainContent);
%>

<jsp:include page="../layouts/default.jsp"></jsp:include>


