<%@page import="com.cellphone.providers.Util"%>
<%@page import="com.cellphone.model.Product"%>
<%@page import="com.cellphone.dao.productDAO"%>
<%@ page import="java.sql.*, java.util.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="utf-8" />
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
            />
        <title>Quản lý sản phẩm</title>

        <!--     Fonts and icons     -->
        <link
            href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700"
            rel="stylesheet"
            />
        <!-- Nucleo Icons -->
        <link href="${pageContext.request.contextPath}/assets/css/nucleo-icons.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/assets/css/nucleo-svg.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/assets/css/product_add.css" rel="stylesheet" />
        <!-- CSS Files -->
        <link
            id="pagestyle"
            href="${pageContext.request.contextPath}/assets/css/argon-dashboard.css?v=2.0.4"
            rel="stylesheet"
            />
    </head>

    <body>
        <jsp:include page="../partials/sidebar.jsp"></jsp:include>
        
        <main class="main-content position-relative border-radius-lg">

            <h4 style="color: white; padding-top: 30px; padding-left: 30px">
                QUẢN LÍ SẢN PHẨM
            </h4>
            <div class="container"  >
                <a href="./product/add" class="add-btn mt-3">Thêm sản phẩm</a>
                <table class="product-table">
                    <thead>
                        <tr>
                            <th class="text-center">STT</th>
                            <th class="text-center">Tên sản phẩm</th>
                            <th class="text-center">Hãng</th>
                            <th class="text-center">Giá</th>
                            <th class="text-center">Màu sắc</th>
                            <th class="text-center">Tồn kho</th>
                            <th class="text-center">Hình ảnh</th>
                            <th class="text-center">Thao tác</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            productDAO services = new productDAO();
                            List<Product> productList = services.getAllProduct();
                            if (productList != null && !productList.isEmpty()) {
                                int stt = 0;
                                for (Product product : productList) {
                                    stt++;
                        %>
                        
                            <tr>
                                <td class="text-center"><%= stt%></td>
                                <td><%= product.getName()%></td>
                                <td class="text-center"><%= product.getBrand()%></td>
                                <td class="text-center"><%= Util.FormatPrice(product.getPrice())%>₫</td>
                                <td class="text-center"><%= product.getTypeByColor()%></td>
                                <td class="text-end">
                                    <div style="padding-left: 7px;">
                                        <%= product.getStock()%>
                                        <a href="product-inventory/edit?id=<%= product.getId()%>" class="delete-btn" style="background-color: blueviolet">Sửa</a>
                                    </div>
                                </td>
                                <td><img src="data:image/jpeg;base64,<%= product.getImage() %>" alt="Product Image" width="60" style="border: 2px solid #ccc; border-radius: 5px;"/></td>              
                                <td>
                                    <a href="product/edit?id=<%= product.getId()%>" class="delete-btn" style="background-color: blueviolet">Chỉnh sửa</a>
                                    <a href="product?action=delete&id=<%= product.getId()%>" class="delete-btn" delete-product>Xóa</a>
                                </td>
                            </tr>
                        <%
                                }
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </main>
        <script>
            const deleteBtns = document.querySelectorAll("[delete-product]");

            deleteBtns.forEach((deleteBtn) => {
                deleteBtn.addEventListener("click", (e) => {
                    e.preventDefault(); 

                    if (confirm("Xác nhận xóa sản phẩm này?")) {
                        window.location.href = e.target.href; 
                    }
                });
            });
        </script>
        <!--   Core JS Files   -->
        <script src="${pageContext.request.contextPath}/assets/js/admin.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/core/popper.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/core/bootstrap.min.js"></script>
    </body>
</html>
