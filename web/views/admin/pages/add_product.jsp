<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Thêm sản phẩm</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
            }
            .container {
                width: 50%;
                margin: 50px auto;
            }
            form {
                background-color: white;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
            label {
                font-weight: bold;
            }
            input[type="text"], input[type="number"] {
                width: 100%;
                padding: 10px;
                margin: 10px 0;
                border: 1px solid #ddd;
                border-radius: 5px;
            }
            .submit-btn {
                background-color: red;
                color: white;
                padding: 10px 15px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }
            .submit-btn:hover {
                background-color: darkred;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <form action="${pageContext.request.contextPath}/admin-product" method="POST">
                <label for="name">Tên sản phẩm:</label>
                <input type="text" name="name" required>

                <label for="brand">Hãng:</label>
                <input type="text" name="brand" required>

                <label for="price">Giá:</label>
                <input type="number" name="price" required>

                <label for="typeByColor">Màu sắc:</label>
                <input type="text" name="typeByColor" required>

                <label for="image">Hình ảnh (URL):</label>
                <input type="text" name="image" required>

                <label for="description">Mô tả:</label>
                <input type="text" name="description" required>
                
                <label for="parameter">Thông số:</label>
                <input type="text" name="parameter" required>

                <button type="submit" class="submit-btn">Thêm sản phẩm</button>
            </form>
        </div>
    </body>
</html>

