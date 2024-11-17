package com.cellphone.model;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class ProductDetail {
    private String productName;
    private String typeByColor;
    private int quantity;
    private double unitPrice;

    // Getters and Setters
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTypeByColor() {
        return typeByColor;
    }

    public void setTypeByColor(String typeByColor) {
        this.typeByColor = typeByColor;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Parse JSON array string into a list of ProductDetail objects.
     *
     * @param json JSON string representing an array of product details
     * @return List of ProductDetail objects
     */
    public static List<ProductDetail> parseJsonArray(String json) {
        List<ProductDetail> productDetails = new ArrayList<>();

        // Return empty list if JSON is null or empty
        if (json == null || json.isEmpty()) {
            System.err.println("JSON đầu vào trống hoặc null.");
            return productDetails;
        }

        try {
            // Parse JSON array
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);

                // Create ProductDetail object
                ProductDetail detail = new ProductDetail();
                detail.setProductName(obj.optString("productName", "Unknown Product"));
                detail.setTypeByColor(obj.optString("typeByColor", "Default Color"));
                detail.setQuantity(obj.optInt("quantity", 0));
                detail.setUnitPrice(obj.optDouble("unitPrice", 0.0));

                // Add to the list
                productDetails.add(detail);
            }
        } catch (Exception e) {
            // Print stack trace for debugging
            e.printStackTrace();
            System.err.println("Lỗi khi phân tích JSON: " + e.getMessage());
        }

        return productDetails;
    }
}
