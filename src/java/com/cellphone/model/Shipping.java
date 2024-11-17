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
public class Shipping {
    private int id;
    private int order_id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String notes;
    private int status;
    
    
    public Shipping(int order_id, String name, String email, String phone, String address, String notes, int status){
        this.order_id = order_id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.notes = notes;
        this.status = status;
        
    }
    
    public Shipping(){
        this.order_id = 0;
        this.name = "none";
        this.email = "none";
        this.phone = "none";
        this.address = "none";
        this.notes = "none";
        this.status = 0;
        
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return order_id;
    }

    public void setOrderId(int orderId) {
        this.order_id = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    
    
}

