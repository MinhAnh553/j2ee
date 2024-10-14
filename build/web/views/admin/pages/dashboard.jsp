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
                            class="nav-link active"
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
                        <a class="nav-link" href="./admin-product">
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
                    href="index.jsp"
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
            <h5 style="color: white">
                Welcome back<br />Have a good day, Admin!
            </h5>
        </main>
        <!--   Core JS Files   -->
        <script src="./assets/js/core/popper.min.js"></script>
        <script src="./assets/js/core/bootstrap.min.js"></script>
        <script src="./assets/js/argon-dashboard.min.js?v=2.0.4"></script>
    </body>
</html>
