// Kiểm tra trong local storage products chưa, nếu chưa có thì thêm vào
var products = JSON.parse(localStorage.getItem("products")) || [];
if (products.length === 0) {
    products = [
        {
            name: "Màn hình chính hãng GX thay cho iPhone Xs Max",
            slug: "man-hinh-xs-max",
            price: "3500000",
            promotion: "29",
            image: "./assets/img/product/mangx.png",
        },
        {
            name: "Thay màn hình Samsung Galaxy Note 20 Ultra",
            slug: "man-hinh-note-20",
            price: "4900000",
            promotion: "20",
            image: "./assets/img/product/thay-man-hinh-samsung-galaxy-note-20-ultra.png",
        },
        {
            name: "Thay màn hình Samsung Galaxy A71",
            slug: "man-hinh-a71",
            price: "1700000",
            promotion: "10",
            image: "./assets/img/product/mansamsunga71.png",
        },
        {
            name: "Pin chính hãng Pisen thay cho iPhone 12 Pro Max",
            slug: "man-hinh-12-pro-max",
            price: "1300000",
            promotion: "10",
            image: "./assets/img/product/pin12promax.png",
        },
        {
            name: "Pin siêu cao chính hãng Pisen thay cho iPhone 7 Plus",
            slug: "man-hinh-iphone-7-max",
            price: "1080000",
            promotion: "31",
            image: "./assets/img/product/piniphone7plus.png",
        },
        {
            name: "Pin siêu cao chính hãng Pisen thay cho iPhone X",
            slug: "man-hinh-iphone-x",
            price: "1430000",
            promotion: "41",
            image: "./assets/img/product/piniphonex.png",
        }
    ];
    localStorage.setItem("products", JSON.stringify(products));
}

var products = JSON.parse(localStorage.getItem("products")) || [];

renderProducts(products);

function renderProducts(products) {
    // cho điện thoại
    var smartphoneListBlock = document.querySelector("#smartphones-list");

    var smartphone = products.map(function (product) {
        var priceSale = new Intl.NumberFormat("de-DE", {
            style: "currency",
            currency: "VND",
        }).format(product.price - (product.promotion / 100) * product.price);
        return `
            <div class="col-lg product__item">
                <a href="${product.slug}">
                    <div class="product__media">
                        <img
                            src="${product.image}"
                            alt=""
                            class="product__media-img"
                        />
                        <span class="product__media-note">
                            <p>BẢO HÀNH 6 THÁNG</p>
                            <p>Sửa 1 giờ</p>
                        </span>
                        <div class="product__media-promotion">-${
                            product.promotion
                        }%</div>
                    </div>
                    <div class="product__info">
                        <h3>${product.name}</h3>
                        <div class="product__price">
                        <span>${priceSale}</span>
                        <span>${new Intl.NumberFormat("de-DE", {
                            style: "currency",
                            currency: "VND",
                        }).format(product.price)}</span>
                        </div>
                        <p class="product__desc">
                            <strong>Tặng áo mưa khi thay pin, màn hình Pisen</strong>, số lượng có hạn
                        </p>
                    </div>
                </a>
            </div>
        `;
    });
    smartphoneListBlock.innerHTML += smartphone.join("");

}

// Click chuyển đến trang info

//var productItem = document.querySelectorAll(".product__item");
//var productItemLength = productItem.length;
//
//for (let i = 0; i < productItemLength; i++) {
//    productItem[i].addEventListener("click", function () {
//        console.log(productItem[i]);
//        // lấy ra tên, hình ảnh sản phẩm
//
//        var productName =
//            productItem[i].querySelector(".product__info h3").innerText;
//        var productImage = productItem[i].querySelector(
//            ".product__media-img"
//        ).src;
//
//        var productPrice = productItem[i].querySelector(
//            ".product__price span:first-child"
//        ).innerHTML;
//        // định dạng như vầy 989&nbsp;₫ tách productPrice để lấy số:
//        var productPrice2 = productPrice.slice(0, productPrice.indexOf("₫"));
//        if (productPrice2.includes("&")) {
//            productPrice2 = productPrice2.replace("&nbsp;", "");
//        }
//
//        localStorage.setItem("productName", productName);
//        localStorage.setItem("productImage", productImage);
//        localStorage.setItem("productPrice", productPrice2);
//
//        window.location.href = "info.o";
//    });
//}
