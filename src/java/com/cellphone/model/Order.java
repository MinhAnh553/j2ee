/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cellphone.model;

import java.sql.Timestamp;

/**
 *
 * @author duylo
 */
public class Order {
    private int id;
    private int user_id;
    private int payment_id;
    private int receive_method;
    private double total;
    private int status;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    
    //Cấu trúc
    public Order(int user_id, int payment_id, int receive_method, double total, int status){
        this.user_id = user_id;
        this.payment_id = payment_id;
        this.receive_method = receive_method;
        this.total = total;
        this.status = status;
        // Lấy thời gian hiện tại và gán vào createdAt và updatedAt dưới dạng Timestamp
        Timestamp currentTime;
        currentTime = new Timestamp(System.currentTimeMillis());
        this.createdAt = currentTime;  // Gán thời gian hiện tại
        this.updatedAt = currentTime;  // Gán thời gian hiện tại cho updatedAt (cập nhật ban đầu)
    }

    public Order() {
        this.user_id=0;
        this.payment_id=0;
        this.receive_method=0;
        this.total=0;
        this.status=0;
        Timestamp currentTime;
        currentTime = new Timestamp(System.currentTimeMillis());
        this.createdAt = currentTime;  
        this.updatedAt = currentTime;
        
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getUserId(){
        return user_id;
    }
    public void setUserId(int user_id){
        this.user_id = user_id;
    }
    public int getPaymentId(){
        return payment_id;
    }
    public void setPaymentId(int payment_id){
        this.payment_id = payment_id;
    }
    public int getReceiveMethod(){
        return receive_method;
    }
    public void setReceiveMethod(int receive_method){
        this.receive_method = receive_method;
    }
    public double getTotal(){
        return total;
    }
    public void setTotal(double total){
        this.total = total;
    }
    public int getStatus(){
        return status;
    }
    public void setStatus(int status){
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
