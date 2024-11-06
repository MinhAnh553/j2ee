<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
            href="${pageContext.request.contextPath}"
            target=""
            >
            <img
                src="${pageContext.request.contextPath}/assets/img/87144.png"
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
                    href="${pageContext.request.contextPath}/admin"
                    >
                    <div
                        class="border-radius-md text-center me-2 d-flex align-items-center justify-content-center"
                        >

                    </div>
                    <span class="nav-link-text ms-5">Dashboard</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/admin/product">
                    <div
                        class="border-radius-md text-center me-2 d-flex align-items-center justify-content-center"
                        >

                    </div>
                    <span class="nav-link-text ms-5">Sản phẩm</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/admin/invoice">
                    <div
                        class="border-radius-md text-center me-2 d-flex align-items-center justify-content-center"
                        >

                    </div>
                    <span class="nav-link-text ms-5">Hoá đơn</span>
                </a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/admin/report">
                    <div
                        class="border-radius-md text-center me-2 d-flex align-items-center justify-content-center"
                        >

                    </div>
                    <span class="nav-link-text ms-5">Báo cáo</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/admin/customer">
                    <div
                        class="border-radius-md text-center me-2 d-flex align-items-center justify-content-center"
                        >

                    </div>
                    <span class="nav-link-text ms-5">Khách hàng</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/admin/staff">
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
                src="${pageContext.request.contextPath}/assets/img/user-icon.png"
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
            href="${pageContext.request.contextPath}"
            target=""
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
    
    <% 
        // Kiểm tra xem có thông báo trong session hay không
        if (session.getAttribute("alert") != null) {
            Map<String, String> alertS = (Map<String, String>) session.getAttribute("alert");
    %>
            <script>
                new Notify({
                    title: 'Thông báo!',
                    text: '<%= alertS.get("msg") %>',
                    status: '<%= alertS.get("type") %>',
                    effect: 'slide',
                    speed: 300,
                    timeout: 3000,
                    customClass: 'notify-error'
                });
            </script>
    <%
            // Sau khi hiển thị, xóa thuộc tính alert khỏi session để tránh hiển thị lại lần sau
            session.removeAttribute("alert");
        }
    %>