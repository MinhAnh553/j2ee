package com.cellphone.model;

public class Product {
    int id;            // ID của sản phẩm
    String name;       // Tên của sản phẩm
    String brand;      // Thương hiệu của sản phẩm
    int price;      // Giá của sản phẩm
    String typeByColor;      // Màu sắc của sản phẩm
    int stock;
    String image;      // Đường dẫn hình ảnh của sản phẩm
    String description;       // Mô tả của sản phẩm
    String slug;

    // Constructor (tùy chọn)
    public Product() {
        this.name="";
    }
    
    public Product(String name, String brand, int price, String typeByColor, String image, String description, String slug) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.typeByColor = typeByColor;
        this.image = image;
        this.description = description;
        this.slug = slug;
    }
    
    public Product(int id, String name, String brand, int price, String typeByColor, String image, String description, int stock) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.typeByColor = typeByColor;
        this.image = image;
        this.description = description;
        this.stock = stock;
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
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
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

