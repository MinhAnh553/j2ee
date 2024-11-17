/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cellphone.dao;

import java.util.ArrayList;
import java.util.List;
import com.cellphone.model.Product;

public class Products {
    private List<Product> productList;

    // Constructor
    public Products() {
        this.productList = new ArrayList<>();
    }

    // Phương thức để thêm sản phẩm
    public void addProduct(Product product) {
        productList.add(product);
    }

    // Phương thức để lấy danh sách sản phẩm
    public List<Product> getProductList() {
        return productList;
    }

    // Phương thức để lấy số lượng sản phẩm
    public int size() {
        return productList.size();
    }
}
