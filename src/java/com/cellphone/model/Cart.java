/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cellphone.model;

/**
 *
 * @author duylo
 */
public class Cart {
    private int id;
    private int user_id;
    private int product_id;
    
    //Cấu trúc
    public Cart(int user_id, int product_id){
    this.user_id = user_id;
    this.product_id = product_id;
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
    public int getProductId(){
        return product_id;
    }
    public void setProductId(int product_id){
        this.product_id = product_id;
    }
    
}
