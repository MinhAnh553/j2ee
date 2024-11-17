<%@page import="com.cellphone.model.userModel"%>
<%@page import="com.cellphone.dao.userDAO"%>
<%@page import="com.cellphone.model.Product"%>
<%@page import="com.cellphone.dao.productDAO"%>
<%@page import="com.cellphone.model.inventoryTransactionsModel"%>
<%@page import="java.util.List"%>
<%@page import="com.cellphone.dao.inventoryTransactionsDAO"%>
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
        
        <style>
            .in-transaction { color: blue!important; }
            .out-transaction { color: red!important; }

            .table th, .table td {
                white-space: nowrap; 
            }

        </style>
    </head>

    <body>
        <jsp:include page="../partials/sidebar.jsp"></jsp:include>
        
        <main class="main-content position-relative border-radius-lg">

            <h4 style="color: white; padding-top: 30px; padding-left: 30px">
                Lịch sử Xuất Nhập Kho
            </h4>
            <div class="table-responsive" style="margin-top: 50px;padding-left: 15px;width: 99%;">
                <table class="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th>STT</th>
                            <th>Tên Sản Phẩm</th>
                            <th>Loại Giao Dịch</th>                            
                            <th>Tồn Kho Trước Thay Đổi</th>
                            <th>Số Lượng Thay Đổi</th>
                            <th>Tồn Kho Hiện Tại</th>
                            <th>Ngày Giao Dịch</th>
                            <th>Ghi Chú</th>
                            <th>Người Tạo</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            inventoryTransactionsDAO transactionDAO = new inventoryTransactionsDAO();
                            List<inventoryTransactionsModel> transactions = transactionDAO.getAllTransactions();
                            
                            productDAO productDAO = new productDAO();
                            userDAO userDAO = new userDAO();
                            int stt = 0;
                             
                            for (inventoryTransactionsModel transaction : transactions) {
                            stt++;
                        %>
                        <tr>
                            <% 
                                Product product = productDAO.getProductByID(transaction.getProductId());
                                userModel user = userDAO.getUserById(transaction.getCreatedBy());
                                System.out.println("className.methodName()" + transaction.getTransactionType() == "IN");
                            %>
                            <td class="text-center"><%= stt %></td>
                            <td>
                                <a href="${pageContext.request.contextPath}/admin/product/edit?id=<%= product.getId()%>" target="_blank">
                                    <%= product.getName()%>
                                </a>
                            </td>
                            <td class="text-center <%= transaction.getTransactionType().equals("IN") ? "in-transaction" : "out-transaction" %>">
                                <%= transaction.getTransactionType().equals("IN") ? "Nhập Kho" : "Xuất Kho" %>
                            </td>
                            <td class="text-center"><%= transaction.getCurrentStock() %></td>
                            <td class="text-center"><%= transaction.getQuantity() %></td>
                            <td class="text-center"><%= product.getStock()%></td>
                            <td class="text-center"><%= transaction.getTransactionDate() %></td>
                            
                            <td><%= transaction.getNote() %></td>
                            <td><%= user.getFullName()%></td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </div>

        </main>
        
        <!--   Core JS Files   -->
        <script src="${pageContext.request.contextPath}/assets/js/admin.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/core/popper.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/core/bootstrap.min.js"></script>
    </body>
</html>
