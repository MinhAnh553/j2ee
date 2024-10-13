<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>FunPhone</title>
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
        <!-- CSS -->
        <link rel="stylesheet" href="./assets/css/styles.css" />
        <link rel="stylesheet" href="./assets/css/app.css" />
        <link rel="stylesheet" href="./assets/css/responsive.css" />
    </head>
    <body>
        
        <jsp:include page="views/client/partials/header.jsp"></jsp:include>

        <main>
            <section class="search-result container fix-phone__inner py-3 px-5 d-none">
                <h2 class="col-lg-3 section__heading">KẾT QUẢ TÌM KIẾM</h2>
                <div class="row">
                    <!-- <div class="row search-result__product col-3" id="smartphones-list">
                        <div class="col-lg product__item col-md-4 col-6 my-3">
                            <div class="product__media">
                                <img src="./assets/img/man_hinh_iphone7plus.jpg" alt="" class="product__media-img" />
                                <span class="product__media-note">
                                    <p>BẢO HÀNH 6 THÁNG</p>
                                    <p>Sửa 1 giờ</p>
                                </span>
                                <div class="product__media-promotion">-10%</div>
                            </div>
                            <div class="product__info">
                                <h3>Thay màn hình iPhone 7 Plus chính hãng Pisen V3</h3>
                                <div class="product__price">
                                    <span>1350000</span><span class="line-through">1500000</span>
                                </div>
                                <p class="product__desc">
                                    <strong>Tặng áo mưa khi thay pin, màn hình Pisen số lượng có hạn</strong>
                                </p>
                            </div>
                        </div>
                    </div> -->
                </div>
            </section>
            <!-- Sửa điện thoại -->
            <section class="fix-phone">
                <div class="container fix-phone__inner">
                    <div class="row py-3 px-5">
                        <h2 class="col-lg-3 section__heading col-12">ĐIỆN THOẠI NỔI BẬT</h2>
                        <div class="col-lg-8 offset-1 col-12 offset-0 mobile-none">
                            <a href="apple"><button class="btn btn-primary btn-sm fix-phone__btn">Apple</button></a>
                            <a href="samsung"><button class="btn btn-primary btn-sm fix-phone__btn">Samsung</button></a>
                            <a href="xiaomi"><button class="btn btn-primary btn-sm fix-phone__btn">Xiaomi</button></a>
                            <a href="oppo"><button class="btn btn-primary btn-sm fix-phone__btn">OPPO</button></a>
                            <a href="vivo"><button class="btn btn-primary btn-sm fix-phone__btn">ViVo</button></a>
                            <a href="realme"><button class="btn btn-primary btn-sm fix-phone__btn">realme</button></a>
                            <a href="techno"><button class="btn btn-primary btn-sm fix-phone__btn">TECHNO</button></a>
                            <a href="nokia"><button class="btn btn-primary btn-sm fix-phone__btn">Nokia</button></a>
                            <a href="mobile"><button class="btn btn-primary btn-sm fix-phone__btn">Xem tất cả</button></a>
                        </div>
                    </div>
                    <div class="row product__list" id="smartphones-list"></div>
                </div>
            </section>

            <!-- Features -->
            <section class="features">
                <div class="container py-3 px-5 bg-light">
                    <div class="row">
                        <h2 class="section__heading">
                            TẠI SAO NÊN CHỌN ĐIỆN THOẠI VUI
                        </h2>
                    </div>
                    <div class="row features__list">
                        <div class="col-lg-3 col-3 features__item">
                            <img
                                src="./assets/img/dich-vu.png"
                                alt=""
                                class="features__img"
                            />
                            <h4 class="features__title">
                                DỊCH VỤ CHUYÊN NGHIỆP
                            </h4>
                            <p class="features__desc">
                                FunPhone là hệ thống cửa hàng sửa chữa rộng khắp
                                cả nước với nhiều năm kinh nhiệm nhận sửa chữa
                                thiết bị công nghệ : điện thoại, laptop,…
                            </p>
                        </div>
                        <div class="col-lg-3 col-3 features__item">
                            <img
                                src="./assets/img/cam-ket.png"
                                alt=""
                                class="features__img"
                            />
                            <h4 class="features__title">CAM KẾT FunPhone</h4>
                            <p class="features__desc">
                                Thời gian bảo hành 6 – 12 tháng, hoàn 100% tiền
                                nếu khách hàng không hài lòng, tổng đài miễn phí
                                1800.2064 giải đáp thắc mắc nhanh chóng.
                            </p>
                        </div>
                        <div class="col-lg-3 col-3 features__item">
                            <img
                                src="./assets/img/tiet-kiem.png"
                                alt=""
                                class="features__img"
                            />
                            <h4 class="features__title">TIẾT KIỆM, TỐI ƯU</h4>
                            <p class="features__desc">
                                Kiểm tra lỗi chính xác và đưa giải pháp khắc
                                phục cụ thể mang lại dịch vụ sửa chữa, thay thế
                                nhanh chóng với chi phí thấp cho khách hàng.
                            </p>
                        </div>
                        <div class="col-lg-3 col-3 features__item">
                            <img
                                src="./assets/img/toan-quoc.png"
                                alt=""
                                class="features__img"
                            />
                            <h4 class="features__title">DỊCH VỤ TOÀN QUỐC</h4>
                            <p class="features__desc">
                                Dịch vụ sửa chữa – bảo hành toàn quốc, tiếp nhận
                                bảo hành và sửa chữa qua đường chuyển phát nhanh
                                với đối tác vận chuyển uy tín.
                            </p>
                        </div>
                    </div>
                </div>
            </section>
        </main>
        
        <jsp:include page="views/client/partials/footer.jsp"></jsp:include>

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

        <script src="./assets/js/main.js"></script>
        <script src="./assets/js/app.js"></script>
        <script src="./assets/js/search.js"></script>
        <script src="./assets/js/user.js"></script>
    </body>
</html>
