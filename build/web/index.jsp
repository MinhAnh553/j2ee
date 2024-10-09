<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    
    String mainContent = "<main>\n" +
        "    <section class=\"search-result container fix-phone__inner py-3 px-5 d-none\">\n" +
        "        <h2 class=\"col-lg-3 section__heading\">KẾT QUẢ TÌM KIẾM</h2>\n" +
        "        <div class=\"row\">\n" +
        "            <!-- <div class=\"row search-result__product col-3\" id=\"smartphones-list\">\n" +
        "                <div class=\"col-lg product__item col-md-4 col-6 my-3\">\n" +
        "                    <div class=\"product__media\">\n" +
        "                        <img src=\"./assets/img/man_hinh_iphone7plus.jpg\" alt=\"\" class=\"product__media-img\" />\n" +
        "                        <span class=\"product__media-note\">\n" +
        "                            <p>BẢO HÀNH 6 THÁNG</p>\n" +
        "                            <p>Sửa 1 giờ</p>\n" +
        "                        </span>\n" +
        "                        <div class=\"product__media-promotion\">-10%</div>\n" +
        "                    </div>\n" +
        "                    <div class=\"product__info\">\n" +
        "                        <h3>Thay màn hình iPhone 7 Plus chính hãng Pisen V3</h3>\n" +
        "                        <div class=\"product__price\">\n" +
        "                            <span>1350000</span><span class=\"line-through\">1500000</span>\n" +
        "                        </div>\n" +
        "                        <p class=\"product__desc\">\n" +
        "                            <strong>Tặng áo mưa khi thay pin, màn hình Pisen số lượng có hạn</strong>\n" +
        "                        </p>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "            </div> -->\n" +
        "        </div>\n" +
        "    </section>\n" +
        "    <!-- Sửa điện thoại -->\n" +
        "    <section class=\"fix-phone\">\n" +
        "        <div class=\"container fix-phone__inner\">\n" +
        "            <div class=\"row py-3 px-5\">\n" +
        "                <h2 class=\"col-lg-3 section__heading col-12\">ĐIỆN THOẠI NỔI BẬT</h2>\n" +
        "                <div class=\"col-lg-8 offset-1 col-12 offset-0 mobile-none\">\n" +
        "                    <a href=\"apple\"><button class=\"btn btn-primary btn-sm fix-phone__btn\">Apple</button></a>\n" +
        "                    <a href=\"samsung\"><button class=\"btn btn-primary btn-sm fix-phone__btn\">Samsung</button></a>\n" +
        "                    <a href=\"xiaomi\"><button class=\"btn btn-primary btn-sm fix-phone__btn\">Xiaomi</button></a>\n" +
        "                    <a href=\"oppo\"><button class=\"btn btn-primary btn-sm fix-phone__btn\">OPPO</button></a>\n" +
        "                    <a href=\"vivo\"><button class=\"btn btn-primary btn-sm fix-phone__btn\">ViVo</button></a>\n" +
        "                    <a href=\"realme\"><button class=\"btn btn-primary btn-sm fix-phone__btn\">realme</button></a>\n" +
        "                    <a href=\"techno\"><button class=\"btn btn-primary btn-sm fix-phone__btn\">TECHNO</button></a>\n" +
        "                    <a href=\"nokia\"><button class=\"btn btn-primary btn-sm fix-phone__btn\">Nokia</button></a>\n" +
        "                    <a href=\"mobile\"><button class=\"btn btn-primary btn-sm fix-phone__btn\">Xem tất cả</button></a>\n" +
                             
        "                </div>\n" +
        "            </div>\n" +
        "            <div class=\"row product__list\" id=\"smartphones-list\"></div>\n" +
        "        </div>\n" +
        "    </section>\n" +
        "    <!-- Features -->\n" +
        "    <section class=\"features\">\n" +
        "        <div class=\"container py-3 px-5 bg-light\">\n" +
        "            <div class=\"row\">\n" +
        "                <h2 class=\"section__heading\">TẠI SAO NÊN CHỌN ĐIỆN THOẠI VUI</h2>\n" +
        "            </div>\n" +
        "            <div class=\"row features__list\">\n" +
        "                <div class=\"col-lg-3 col-3 features__item\">\n" +
        "                    <img src=\"./assets/img/dich-vu.png\" alt=\"\" class=\"features__img\" />\n" +
        "                    <h4 class=\"features__title\">DỊCH VỤ CHUYÊN NGHIỆP</h4>\n" +
        "                    <p class=\"features__desc\">FunPhone là hệ thống cửa hàng sửa chữa rộng khắp cả nước với nhiều năm kinh nhiệm nhận sửa chữa thiết bị công nghệ : điện thoại, laptop,…</p>\n" +
        "                </div>\n" +
        "                <div class=\"col-lg-3 col-3 features__item\">\n" +
        "                    <img src=\"./assets/img/cam-ket.png\" alt=\"\" class=\"features__img\" />\n" +
        "                    <h4 class=\"features__title\">CAM KẾT FunPhone</h4>\n" +
        "                    <p class=\"features__desc\">Thời gian bảo hành 6 – 12 tháng, hoàn 100% tiền nếu khách hàng không hài lòng, tổng đài miễn phí 1800.2064 giải đáp thắc mắc nhanh chóng.</p>\n" +
        "                </div>\n" +
        "                <div class=\"col-lg-3 col-3 features__item\">\n" +
        "                    <img src=\"./assets/img/tiet-kiem.png\" alt=\"\" class=\"features__img\" />\n" +
        "                    <h4 class=\"features__title\">TIẾT KIỆM, TỐI ƯU</h4>\n" +
        "                    <p class=\"features__desc\">Kiểm tra lỗi chính xác và đưa giải pháp khắc phục cụ thể mang lại dịch vụ sửa chữa, thay thế nhanh chóng với chi phí thấp cho khách hàng.</p>\n" +
        "                </div>\n" +
        "                <div class=\"col-lg-3 col-3 features__item\">\n" +
        "                    <img src=\"./assets/img/toan-quoc.png\" alt=\"\" class=\"features__img\" />\n" +
        "                    <h4 class=\"features__title\">DỊCH VỤ TOÀN QUỐC</h4>\n" +
        "                    <p class=\"features__desc\">Dịch vụ sửa chữa – bảo hành toàn quốc, tiếp nhận bảo hành và sửa chữa qua đường chuyển phát nhanh với đối tác vận chuyển uy tín.</p>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "        </div>\n" +
        "    </section>\n" +
        "</main>";

    request.setAttribute("mainContent", mainContent);
%>

<jsp:include page="./views/client/layouts/default.jsp">
    <jsp:param name="pageTitle" value="Trang chủ"/>
</jsp:include>

