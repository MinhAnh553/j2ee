/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cellphone.providers;

import java.io.*;
import java.net.*;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author duylo
 */
public class PayOSClient {
    // Thay YOUR_API_KEY và YOUR_SECRET_KEY bằng thông tin bạn lấy từ tài khoản PayOS
    private static final String API_URL = "https://api.payos.com/v1/transaction";
    private static final String API_KEY = "fb98a6e5-49b9-4c43-9bab-0b649d7e5225";
    private static final String SECRET_KEY = "94b8083aab6940aefe9422975b15517870cdac85850d3f9bb650526a2cb5f878";

    // Tạo giao dịch thanh toán với PayOS
    public String createTransaction(double amount, String currency) throws IOException {
        // URL của API PayOS
        URL url = new URL(API_URL);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        
        // Cấu hình kết nối
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("API-Key", API_KEY);
        connection.setRequestProperty("API-Secret", SECRET_KEY);
        connection.setDoOutput(true); // Cho phép gửi dữ liệu trong phần thân yêu cầu

        // Tạo dữ liệu JSON gửi trong yêu cầu POST
        String jsonBody = String.format("{\"amount\": %f, \"currency\": \"%s\"}", amount, currency);
        
        // Gửi dữ liệu
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonBody.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        // Đọc phản hồi từ PayOS
        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            return response.toString();  // Trả về kết quả JSON từ PayOS
        }
    }

    public static void main(String[] args) {
        try {
            PayOSClient client = new PayOSClient();
            // Giả sử bạn muốn tạo một giao dịch với 100 USD
            String response = client.createTransaction(100.0, "USD");
            System.out.println("Response from PayOS: " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}