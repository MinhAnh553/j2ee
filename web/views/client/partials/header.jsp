<%@page import="com.cellphone.model.userModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    userModel account = (userModel) session.getAttribute("account");
%>
<!-- Header PC & Tablet -->
    <header class="header header-pc header-info">
        <div class="container py-3">
            <div class="row header__content">
                <div class="col-lg-3 col-2">
                    <div class="logo">
                        <a href="./">FunPhone</a>
                    </div>
                </div>
                <div class="col-lg-5 col-5">
                    <div class="group">
                        <svg
                            class="icon"
                            aria-hidden="true"
                            viewBox="0 0 24 24"
                        >
                            <g>
                                <path
                                    d="M21.53 20.47l-3.66-3.66C19.195 15.24 20 13.214 20 11c0-4.97-4.03-9-9-9s-9 4.03-9 9 4.03 9 9 9c2.215 0 4.24-.804 5.808-2.13l3.66 3.66c.147.146.34.22.53.22s.385-.073.53-.22c.295-.293.295-.767.002-1.06zM3.5 11c0-4.135 3.365-7.5 7.5-7.5s7.5 3.365 7.5 7.5-3.365 7.5-7.5 7.5-7.5-3.365-7.5-7.5z"
                                ></path>
                            </g>
                        </svg>
                        <input
                            placeholder="Bạn cần tìm gì?"
                            type="search"
                            id="search-product"
                            class="input search-product"
                        />
                    </div>
                </div>
                <div class="col-lg-4 col-5">
                    <div class="row">
                        <div class="col">
                            <a
                                class="row header__item"
                                href="tel:0366634188"
                            >
                                <div class="col-3">
                                    <div class="fs-1 text-light">
                                        <i
                                            class="fa fa-phone header-icon"
                                        ></i>
                                    </div>
                                </div>
                                <div class="col-9">
                                    <strong class="subheader"
                                        >0366634188</strong
                                    >
                                </div>
                            </a>
                        </div>

                        <div class="col">
                            <a class="row header__item" href="cart">
                                <div class="col-3">
                                    <div class="fs-1 text-light">
                                        <i
                                            class="fa fa-shopping-cart header-icon"
                                        ></i>
                                    </div>
                                </div>
                                <div class="col-9">
                                    <strong class="subheader"
                                        >Giỏ hàng</strong
                                    >
                                </div>
                            </a>
                        </div>
                        
                        <div class="col header-check">
                            <% if(account != null) { %>
                                <div class="row header__item">
                                    <div class="col-3">
                                        <div class="fs-1 text-light">
                                            <i
                                                class="fa fa-user header-icon"
                                            ></i>
                                        </div>
                                    </div>
                                    <div class="col-9">
                                        <div class="col-9">
                                            <strong class="subheader"
                                                >Tài khoản</strong
                                            >
                                        </div>
                                    </div>
                                    <ul class="sub-menu">
                                        <li class="sub-menu-admin">
                                            <a href="admin">
                                                <i
                                                    class="fa-solid fa-circle-user"
                                                ></i>
                                                Trang Admin</a
                                            >
                                        </li>
                                        <hr />
                                        <li>
                                            <a href="./logout" >
                                                <i
                                                    class="fa-solid fa-right-from-bracket"
                                                ></i>
                                                Đăng xuất</a
                                            >
                                        </li>
                                    </ul>
                                </div>
                                <%    } else {%>
                                <a class="row header__item" href="login">
                                    <div class="col-3">
                                        <div class="fs-1 text-light">
                                            <i
                                                class="fa fa-user header-icon"
                                            ></i>
                                        </div>
                                    </div>
                                    <div class="col-9">
                                        <div class="col-9">
                                            <strong class="subheader"
                                                >Đăng nhập</strong
                                            >
                                        </div>
                                    </div>
                                </a>
                            <% } %>
                        </div>
                       
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- Header Mobile -->
    <header class="header header-mobile header-info">
        <div class="container py-3">
            <div class="row header__content">
                <div class="col-5">
                    <div class="logo">
                        <a href="#">FunPhone</a>
                    </div>
                </div>
                <div class="col-7">
                    <div class="row">
                        <div class="col-6">
                            <a class="row header__item" href="cart.html">
                                <div class="col-3">
                                    <div class="fs-1 text-light">
                                        <i
                                            class="fa fa-shopping-cart header-icon"
                                        ></i>
                                    </div>
                                </div>
                                <div class="col-9">
                                    <strong class="subheader"
                                        >Giỏ hàng</strong
                                    >
                                </div>
                            </a>
                        </div>

                        <div class="col-6 header-check-mobile">
                            <a class="row header__item" href="login.html">
                                <div class="col-3">
                                    <div class="fs-1 text-light">
                                        <i
                                            class="fa fa-user header-icon"
                                        ></i>
                                    </div>
                                </div>
                                <div class="col-9">
                                    <strong class="subheader"
                                        >Đăng nhập</strong
                                    >
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="group">
                    <svg
                        class="icon"
                        aria-hidden="true"
                        viewBox="0 0 24 24"
                    >
                        <g>
                            <path
                                d="M21.53 20.47l-3.66-3.66C19.195 15.24 20 13.214 20 11c0-4.97-4.03-9-9-9s-9 4.03-9 9 4.03 9 9 9c2.215 0 4.24-.804 5.808-2.13l3.66 3.66c.147.146.34.22.53.22s.385-.073.53-.22c.295-.293.295-.767.002-1.06zM3.5 11c0-4.135 3.365-7.5 7.5-7.5s7.5 3.365 7.5 7.5-3.365 7.5-7.5 7.5-7.5-3.365-7.5-7.5z"
                            ></path>
                        </g>
                    </svg>
                    <input
                        placeholder="Bạn cần tìm gì?"
                        type="search"
                        id="search-product"
                        class="input search-product"
                    />
                </div>
            </div>
        </div>
    </header>