<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.cellphone.model.brandModel" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Thêm sản phẩm</title>
        <!-- Bootstrap -->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
            crossorigin="anonymous"
            />
        <!-- CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/simple-notify@1.0.4/dist/simple-notify.css" />

        <!-- JS -->
        <script src="https://cdn.jsdelivr.net/npm/simple-notify@1.0.4/dist/simple-notify.min.js"></script>
        <!-- CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin.css"/>
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
        <script src="https://cdn.tiny.cloud/1/4q7adju40hir2jzg02ht5qegte2fy1n8262er9mhdtl5sf52/tinymce/6/tinymce.min.js" referrerpolicy="origin"></script>
        <script>
            tinymce.init({
                selector: '#mytextarea'
            });
        </script>
    </head>
    <body>
        
        <div class="container">
            <a href="${pageContext.request.contextPath}/admin/product" class="btn btn-primary add-btn mb-3">Quay lại</a>
            <form action="${pageContext.request.contextPath}/admin/product/add" method="POST" enctype="multipart/form-data" id="form-add-product">
                <label for="name">Tên sản phẩm:</label>
                <input type="text" name="name" required>

                <label for="brand" class="mb-3">Hãng:</label>
                <%
                    List<brandModel> brandList = (List<brandModel>) request.getAttribute("brands");
                    if (brandList != null && !brandList.isEmpty()) {
                %>
                <select name="brand" id="brand" class="form-select form-select-sm mb-3" required>
                    <option value="" disabled selected >--- Chọn thương hiệu ---</option>
                    <%
                        for (brandModel brand : brandList) {
                    %>
                        <option value="<%= brand.getName()%>"><%= brand.getName()%></option>
                    <%
                        }
                    %>
                </select>
                <%
                    }
                %>

                <label for="price">Giá:</label>
                <input type="number" name="price" required>

                <label for="typeByColor">Màu sắc:</label>
                <input type="text" name="typeByColor" required>

                <div class="form-group mb-3">
                    <label for="description">Mô tả:</label>
                    <textarea id="mytextarea" class="form-control tinymce" type="text" name="description" rows="3"></textarea>
                </div>
                <div class="form-group mb-3" upload-image="upload-image">
                  <label for="image">Ảnh</label>
                  <input class="form-control" type="file" id="image" name="image" accept="image/*" upload-image-input="upload-image-input"/>
                  <image class="image-preview" src="" upload-image-preview="upload-image-preview"></image>
                </div> 

                <button type="submit" class="submit-btn">Thêm sản phẩm</button>
            </form>
        </div>
              
        <script src="${pageContext.request.contextPath}/assets/js/admin.js"></script>
    </body>
</html>

