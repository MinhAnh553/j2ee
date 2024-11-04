package com.cellphone.providers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Util {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int TOKEN_LENGTH = 32;

    public static String generateToken() {
        SecureRandom random = new SecureRandom();
        StringBuilder token = new StringBuilder(TOKEN_LENGTH);

        for (int i = 0; i < TOKEN_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            token.append(CHARACTERS.charAt(index));
        }

        return token.toString();
    }
    
    // Mã hóa mật khẩu bằng SHA-256
    public static String hashPassword(String password) {
        try {
            // Tạo một đối tượng MessageDigest với thuật toán SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            
            // Chuyển mật khẩu thành mảng byte và băm nó
            byte[] hashedBytes = md.digest(password.getBytes());
            
            // Chuyển mảng byte thành chuỗi hex
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            
            // Trả về mật khẩu đã được mã hóa dưới dạng chuỗi hex
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Lỗi: Thuật toán không tồn tại", e);
        }
    }
    
    public static String generateSlug(String name) {
        // Chuyển thành chữ thường
        String slug = name.toLowerCase();
        
        // Thay thế các ký tự không phải chữ cái hoặc số bằng khoảng trắng
        slug = slug.replaceAll("[^a-z0-9\\s]", "");
        
        // Thay thế khoảng trắng bằng dấu gạch nối
        slug = slug.replaceAll("\\s+", "-");
        
        // Loại bỏ dấu gạch nối ở đầu và cuối
        slug = slug.replaceAll("^-|-$", "");
        
        return slug;
    }
}
