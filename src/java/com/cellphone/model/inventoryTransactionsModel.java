package com.cellphone.model;

public class inventoryTransactionsModel {
    private int id;
    private int productId;
    private String transactionType; 
    private int quantity;
    private String transactionDate;
    private int currentStock;
    private String note;
    private int created_by;

    public inventoryTransactionsModel() {
        this.quantity = 0;
        this.currentStock = 0;
    }

    public inventoryTransactionsModel(int product_id, String transaction_type, int quantity, int current_stock, String note, int created_by) {
        this.productId = product_id;
        this.transactionType = transaction_type;
        this.quantity = quantity;
        this.currentStock = current_stock;
        this.note = note;
        this.created_by = created_by;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getTransactionType() {
        return transactionType;
    }
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTransactionDate() {
        return transactionDate;
    }
    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getCurrentStock() {
        return currentStock;
    }
    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    
    public int getCreatedBy() {
        return created_by;
    }
    public void setCreatedBy(int id) {
        this.created_by = id;
    }
}
