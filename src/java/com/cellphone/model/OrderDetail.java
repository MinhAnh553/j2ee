/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cellphone.model;

/**
 *
 * @author duylo
 */
public class OrderDetail {
    private int id;
    private int order_id;
    private int product_id;
    private int quantity;
    private double price;
    
    //Cấu trúc
    public OrderDetail(int order_id, int product_id, int quantity, double price){
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderDetail() {
        this.order_id = 0;
        this.product_id =0;
        this.quantity = 0;
        this.price = 0;
    }
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getOrderId(){
        return order_id;
    }
    public void setOrderId(int order_id){
        this.order_id = order_id;
    }
    public int getProductId(){
        return product_id;
    }
    public void setProductId(int product_id){
        this.product_id = product_id;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
}
