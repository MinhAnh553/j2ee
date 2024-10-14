/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cellphone.model;

/**
 *
 * @author duylo
 */

public class Product {
    int id;            // ID của sản phẩm
    String name;       // Tên của sản phẩm
    String brand;      // Thương hiệu của sản phẩm
    double price;      // Giá của sản phẩm
    String typeByColor;      // Màu sắc của sản phẩm
    String image;      // Đường dẫn hình ảnh của sản phẩm
    String description;       // Mô tả của sản phẩm
    String slug;

    // Constructor (tùy chọn)
    public Product() {
        this.name="";
    }

    // Getter và Setter cho id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    // Getter và Setter cho name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Getter và Setter cho brand
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Getter và Setter cho price
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    // Getter và Setter cho color
    public String getTypeByColor() {
        return typeByColor;
    }
    public void setColor(String color) {
        this.typeByColor = color;
    }

    // Getter và Setter cho image
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    // Getter và Setter cho desc
    public String getDescription() {
        return description;
    }
    public void setDesc(String desc) {
        this.description = desc;
    }
    public String getSlug() {
        return slug;
    }
    public void setSlug(String slug) {
        this.slug = slug;
    }
}

