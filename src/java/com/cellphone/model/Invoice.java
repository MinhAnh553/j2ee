package com.cellphone.model;

import com.cellphone.model.ProductDetail;
import java.sql.Timestamp;
import java.util.List;

public class Invoice {
    private int orderId;
    private Timestamp timestamp;
    private String cashier;
    private String customer;
    private double totalPrice;
    private int paymentId;
    private int receiveMethod;
    private int status;
    private List<ProductDetail> productDetails;

    // Getters and Setters
    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public Timestamp getTimestamp() { return timestamp; }
    public void setTimestamp(Timestamp timestamp) { this.timestamp = timestamp; }

    public String getCashier() { return cashier; }
    public void setCashier(String cashier) { this.cashier = cashier; }

    public String getCustomer() { return customer; }
    public void setCustomer(String customer) { this.customer = customer; }

    public double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }

    public int getPaymentId() { return paymentId; }
    public void setPaymentId(int paymentId) { this.paymentId = paymentId; }

    public int getReceiveMethod() { return receiveMethod; }
    public void setReceiveMethod(int receiveMethod) { this.receiveMethod = receiveMethod; }

    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }

    public List<ProductDetail> getProductDetails() { return productDetails; }
    public void setProductDetails(List<ProductDetail> productDetails) { this.productDetails = productDetails; }
}
