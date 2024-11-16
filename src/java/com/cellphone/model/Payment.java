/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cellphone.model;

import java.sql.*;


/**
 *
 * @author duylo
 */
public class Payment {
    private int id;
    private int order_id;
    private double amount;
    private int payment_method;
    private int status;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    
    public Payment(int order_id, double amount, int payment_method, int status){
        this.order_id = order_id;
        this.amount = amount;
        this.payment_method = payment_method;
        this.status = status;
        // Lấy thời gian hiện tại và gán vào createdAt và updatedAt dưới dạng Timestamp
        java.sql.Timestamp currentTime;
        currentTime = new java.sql.Timestamp(System.currentTimeMillis());
        this.createdAt = currentTime;  // Gán thời gian hiện tại
        this.updatedAt = currentTime;  // Gán thời gian hiện tại cho updatedAt (cập nhật ban đầu)
    }

    public Payment(){
        this.order_id = 0;
        this.amount = 0;
        this.payment_method = 0;
        this.status = 0;
        
    }
    
    // Getter và Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return order_id;
    }

    public void setOrderId(int order_id) {
        this.order_id = order_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getPaymentMethod() {
        return payment_method;
    }

    public void setPaymentMethod(int paymentMethod) {
        this.payment_method = paymentMethod;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
