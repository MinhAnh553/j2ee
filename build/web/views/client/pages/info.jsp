<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Thông tin sản phẩm</title>
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
        <!-- CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/simple-notify@1.0.4/dist/simple-notify.css" />

        <!-- JS -->
        <script src="https://cdn.jsdelivr.net/npm/simple-notify@1.0.4/dist/simple-notify.min.js"></script>
        
        <!-- CSS -->
        <link rel="stylesheet" href="./assets/css/styles.css" />
        <link rel="stylesheet" href="./assets/css/infoProduct.css" />
        <link rel="stylesheet" href="./assets/css/responsive.css" />
    </head>

    <body>
        
        <jsp:include page="../partials/header.jsp"></jsp:include>
        
        <!-- Nội dung của từng trang -->
        <main>
            <section
                class="search-result container fix-phone__inner py-3 px-5 d-none"
            >
                <h2 class="col-lg-3 section__heading">KẾT QUẢ TÌM KIẾM</h2>
                <div class="row">
                </div>
            </section>
            <div class="container">
                <form action="/project_j2ee/AddToCart" method="POST">
                    <input type="hidden" name="productId" value="${product.id}" />
                    <input type="hidden" name="productName" value="${product.name}" />
                    <input type="hidden" name="productPrice" value="${product.price}" />
                    <input type="hidden" name="productImage" value="${product.image}" />
                <div class="info info-product">
                    <h1 class="info__heading">
                        Tên sản phẩm: ${product.name}
                    </h1>
                    <div class="info__content row">
                        <div class="info__left col-md-7">
                            <div class="info__left-block">
                                <img class="product-image" src="<c:url value='${product.image}' />" alt="${product.name}">

                            </div>

                            <div class="info__left-list">
                                <h2>THÔNG TIN CHI TIẾT</h2>
                                <ul>
                                    <li>Mã sản phẩm: ${product.id}</li>
                                    <li>Hãng: ${product.brand}</li>
                                    <li>Màu: ${product.typeByColor}</li>
                                    <li>Cam kết chính hãng 100%</li>
                                    <li>Chất liệu cao cấp</li>
                                    <li>Miễn phí đổi trả nếu có lỗi từ nhà sản xuất, nhà cung cấp</li>
                                    
                                   
                                </ul>
                            </div>
                        </div>

                        <div class="info__right col-md-5">
                                <h2 class="info__right-title">GIÁ KHUYẾN MÃI</h2>
                            <div class="info__right-price product__price">
                                <span> <fmt:formatNumber value="${product.price*0.9}" type="currency" currencySymbol="VNĐ" /></span><br/>
                                <span> <fmt:formatNumber value="${product.price}" type="currency" currencySymbol="VNĐ" /></span>
                            </div>
                            <div class="info__right-timing">
                                <h2>
                                    <i
                                        class="fa-regular fa-clock info__right-icon"
                                    >
                                    </i>
                                    Thời gian giao hàng dự kiến: 1 ngày
                                </h2>
                            </div>
                            <div class="info__right-groupbtn row">
                                <button
                                    class="groupbtn__order col-lg-6 col-md-6 col"
                                >
                                    <i class="fa fa-calendar"></i> ĐẶT LỊCH MUA HÀNG
                                </button>
                                <button
                                    type="submit" class="groupbtn__cart col-lg-5 col-md-4 col"
                                >
                                    <i
                                        class="fa fa-shopping-cart"
                                        style="font-size: 3em"
                                    ></i>
                                    <br />Thêm vào giỏ
                                </button>
                            </div>
                            <div class="info__right-promotion">
                                <h2 class="promotion__title">
                                    <i
                                        class="fa-solid fa-gift"
                                        style="color: #f19729"
                                    ></i>
                                    KHUYẾN MÃI
                                </h2>

                                <ul class="promotion__list">
                                    <li>Giảm ngay 5% cho thành viên</li>
                                    <li>Học sinh, sinh viên giảm 10%</li>
                                    <li>Nhiều quà tặng hấp dẫn khác</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <hr />
                    <div class="info__product">
                        <h2 class="info__product-title">Mô tả sản phẩm</h2>
                        <p>
                            ${product.description}
                        </p>
                        <span id="dots">...</span
                        ><span id="more">
                            <h3>Thay kính lưng iPhone là gì?</h3>
                            <p>
                                Trong quá trình sử dụng iPhone, việc va đập hoặc
                                rơi vỡ là chuyện không tránh khỏi. Điều này dẫn
                                đến mặt lưng bị hư hỏng. Hoặc cũng có thể do
                                dùng ốp lưng quá lâu nhưng không vệ sinh khiến
                                mặt lưng máy bị ố gây mất thẩm mỹ. Giải pháp hữu
                                hiệu cho các vấn đề này là mang máy đi thay thế
                                mặt kính lưng bị hỏng bằng kính mới.
                            </p>
                            <img
                                src="./assets/img/product/info1.png"
                                class="center_image"
                            />
                            <h3>
                                Thay kính lưng 14 Pro Max có ảnh hưởng gì không?
                            </h3>
                            <p>
                                iPhone 14 Pro Max được trang bị tính năng chống
                                nước khá tốt. Nó giúp điện thoại hạn chế bị lỗi
                                khi tiếp xúc với nước. Khả năng kháng nước của
                                máy sẽ phụ thuộc vào ron và lớp keo chống nước
                                được kết dính giữa màn hình và sườn vỏ. Về tính
                                năng sạc nhanh, mặt kính lưng với phần cảm biến
                                sạc không dây là hai bộ phận tách biệt. Do đó,
                                khi thay kính lưng iPhone sẽ không ảnh hưởng gì
                                đến chức năng sạc nhanh tích hợp bên trong mặt
                                kính.
                            </p>
                            <img
                                src="./assets/img/product/info2.png"
                                class="center_image"
                            />
                            <p>
                                Thay kính lưng chủ yếu là quá trình thủ công,
                                yêu cầu các kỹ thuật viên phải có tay nghề cao
                                và tỉ mỉ trong lúc sửa. Bên cạnh đó, lựa chọn
                                trung tâm sửa chữa cũng là một yếu tố quan
                                trọng. Có như vậy mới đảm bảo được các chức năng
                                của thiết bị không bị ảnh hưởng.
                            </p>
                        </span>

                        <div class="center">
                            <button
                                onclick="seeMore()"
                                id="myBtn"
                                class="button"
                            >
                                Xem thêm
                            </button>
                        </div>
                    </div>
                    <div class="info__content row">
                        <div
                            class="info__qa col-md-5"
                            style="width: max-content"
                        >
                            <h2
                                style="
                                    font-weight: 700;
                                    color: #d70018;
                                    font-size: 20px;
                                "
                            >
                                <i
                                    class="fa-regular fa-circle-question"
                                    style="color: #f5193a"
                                ></i>
                                HỎI VÀ ĐÁP
                            </h2>
                            <br />
                            <textarea
                                cols="70"
                                rows="7"
                                placeholder="Vui lòng để lại câu hỏi, chúng tôi sẽ cố gắng phản hồi sớm nhất"
                            ></textarea>
                            <br />
                            <button
                                style="
                                    color: white;
                                    background-color: #d70018;
                                    border: none;
                                "
                            >
                                <i class="fa-solid fa-paper-plane"></i> Gửi
                            </button>
                        </div>
                        <div class="rate col-md-5">
                            <h2
                                style="
                                    font-weight: 600;
                                    font-size: 16px;
                                    margin-bottom: 10px;
                                "
                            >
                                ĐÁNH GIÁ VÀ NHẬN XÉT
                            </h2>
                            <div class="rating">
                                <div class="star">1 ⭐</div>
                                <div class="progress-bar"></div>
                                <div class="count">0</div>
                            </div>

                            <div class="rating">
                                <div class="star">2 ⭐</div>
                                <div class="progress-bar"></div>
                                <div class="count">0</div>
                            </div>

                            <div class="rating">
                                <div class="star">3 ⭐</div>
                                <div class="progress-bar"></div>
                                <div class="count">0</div>
                            </div>

                            <div class="rating">
                                <div class="star">4 ⭐</div>
                                <div class="progress-bar"></div>
                                <div class="count">0</div>
                            </div>

                            <div class="rating">
                                <div class="star">5 ⭐</div>
                                <div class="progress-bar"></div>
                                <div class="count">0</div>
                            </div>

                            <p style="margin-bottom: 0">
                                Hiện chưa có nhận xét nào. Hãy là người nhận xét
                                đầu tiên.
                            </p>
                            <div class="center">
                                <button
                                    style="
                                        color: white;
                                        background-color: #d70018;
                                        border: none;
                                    "
                                >
                                    Gửi đánh giá
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            </div>
        </main>

        
        <script src="./assets/js/validations.js"></script>

    </body>

    <jsp:include page="../partials/footer.jsp"></jsp:include>
</html>