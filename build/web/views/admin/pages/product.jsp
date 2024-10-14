<%@ page import="java.sql.*, java.util.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
            />
        <title>Trang quản trị</title>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <script>
            //SweetAlert
            function showAlert(type, message) {
                if (type === 'success') {
                    swal("Thành công!", message, "success");
                } else if (type === 'error') {
                    swal("Lỗi!", message, "error");
                }
            }

            // showAlert
            window.onload = function () {
                const message = '<%= request.getParameter("message")%>';
                if (message === 'error') {
                    showAlert('error', 'Không thể thêm sản phẩm, vui lòng kiểm tra lại!');
                } else if (message === 'success') {
                    showAlert('success', 'Thêm sản phẩm thành công!');
                }
            };
        </script>

        <!--     Fonts and icons     -->
        <link
            href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700"
            rel="stylesheet"
            />
        <!-- Nucleo Icons -->
        <link href="./assets/css/nucleo-icons.css" rel="stylesheet" />
        <link href="./assets/css/nucleo-svg.css" rel="stylesheet" />
        <link href="./assets/css/product_add.css" rel="stylesheet" />
        <!-- CSS Files -->
        <link
            id="pagestyle"
            href="./assets/css/argon-dashboard.css?v=2.0.4"
            rel="stylesheet"
            />
    </head>

    <body>
        <div class="min-height-80 bg-primary position-absolute w-100"></div>
        <aside
            class="sidenav bg-white navbar navbar-vertical navbar-expand-xs border-0 border-radius-xl my-3 fixed-start ms-4"
            id="sidenav-main"
            >
            <div class="sidenav-header">
                <i
                    class="fas fa-times p-3 cursor-pointer text-secondary opacity-5 position-absolute end-0 top-0 d-none d-xl-none"
                    aria-hidden="true"
                    id="iconSidenav"
                    ></i>
                <a
                    class="navbar-brand m-0"
                    href=""
                    target="_blank"
                    >
                    <img
                        src="./assets/img/87144.png"
                        class="navbar-brand-img h-100"
                        alt="main_logo"
                        />
                    <span
                        class="ms-1 font-weight-bolder"
                        style="font-size: medium"
                        >CELLPHONE</span
                    >
                </a>
            </div>
            <hr class="horizontal dark mt-0" />
            <div
                class="collapse navbar-collapse w-auto"
                id="sidenav-collapse-main"
                >
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a
                            class="nav-link"
                            href="./admin"
                            >
                            <div
                                class="border-radius-md text-center me-2 d-flex align-items-center justify-content-center"
                                >

                            </div>
                            <span class="nav-link-text ms-5">Dashboard</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="./admin-product">
                            <div
                                class="border-radius-md text-center me-2 d-flex align-items-center justify-content-center"
                                >

                            </div>
                            <span class="nav-link-text ms-5">Sản phẩm</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="./admin_invoice">
                            <div
                                class="border-radius-md text-center me-2 d-flex align-items-center justify-content-center"
                                >

                            </div>
                            <span class="nav-link-text ms-5">Hoá đơn</span>
                        </a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="./admin_report">
                            <div
                                class="border-radius-md text-center me-2 d-flex align-items-center justify-content-center"
                                >

                            </div>
                            <span class="nav-link-text ms-5">Báo cáo</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="./admin_customer">
                            <div
                                class="border-radius-md text-center me-2 d-flex align-items-center justify-content-center"
                                >

                            </div>
                            <span class="nav-link-text ms-5">Khách hàng</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="./admin_staff">
                            <div
                                class="border-radius-md text-center me-2 d-flex align-items-center justify-content-center"
                                >

                            </div>
                            <span class="nav-link-text ms-5">Nhân viên</span>
                        </a>
                    </li>
                </ul>
            </div>
            <div class="sidenav-footer mx-3">
                <div class="card card-plain shadow-none" id="sidenavCard">
                    <img
                        class="w-50 mx-auto"
                        src="./assets/img/user-icon.png"
                        alt="sidebar_illustration"
                        />
                    <div class="card-body text-center p-3 w-100 pt-0">
                        <div class="docs-info">
                            <h6 class="mb-0">Administrator</h6>
                            <p class="text-xs font-weight-bold mb-0">CT224</p>
                        </div>
                    </div>
                </div>
                <a
                    href=""
                    target="_blank"
                    class="btn btn-primary btn-sm mb-3 w-100"
                    >Trang chủ</a
                >
                <a
                    class="btn btn-primary btn-sm mb-0 w-100"
                    href=""
                    type="button"
                    >Yêu cầu trợ giúp</a
                >
            </div>
        </aside>
        <main class="main-content position-relative border-radius-lg">

            <h4 style="color: white; padding-top: 30px; padding-left: 30px">
                QUẢN LÍ SẢN PHẨM
            </h4>
            <div class="container"  >
                <a href="./views/admin/pages/add_product.jsp" class="add-btn">Thêm sản phẩm</a>
                <table class="product-table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Tên sản phẩm</th>
                            <th>Hãng</th>
                            <th>Giá</th>
                            <th>Màu sắc</th>
                            <th>Hình ảnh</th>
                            <th>Mô tả</th>
                            <th>Thao tác</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            String dbURL = "jdbc:mysql://localhost:3306/cellphone";
                            String user = "root";
                            String password = ""; // 
                            try {
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                Connection conn = DriverManager.getConnection(dbURL, user, password);
                                String sql = "SELECT * FROM product";
                                PreparedStatement stmt = conn.prepareStatement(sql);
                                ResultSet rs = stmt.executeQuery();

                                while (rs.next()) {
                                    int id = rs.getInt("id");
                                    String name = rs.getString("name");
                                    String brand = rs.getString("brand");
                                    float price = rs.getFloat("price");
                                    String color = rs.getString("typeByColor");
                                    String image = rs.getString("image");
                                    String description = rs.getString("description");
                        %>
                        <tr>
                            <td><%= id%></td>
                            <td><%= name%></td>
                            <td><%= brand%></td>
                            <td><%= price%></td>
                            <td><%= color%></td>
                            <td><img src="<%= image%>" alt="Hình ảnh" width="50"></td>
                            <td><%= description%></td>
                            <td>
                                <a href="admin-product?action=delete&id=<%= id%>" class="delete-btn">Xóa</a>
                            </td>
                        </tr>
                        <%
                                }
                                conn.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </main>
        <!--   Core JS Files   -->
        <script src="./assets/js/core/popper.min.js"></script>
        <script src="./assets/js/core/bootstrap.min.js"></script>
        <script src="./assets/js/argon-dashboard.min.js?v=2.0.4"></script>
    </body>
</html>
