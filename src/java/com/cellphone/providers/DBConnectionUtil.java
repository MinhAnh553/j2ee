package com.cellphone.providers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {

    private static final String URL = "jdbc:mysql://103.74.101.111:3306/cellphone?useSSL=false";
private static final String USER = "cellphone";
private static final String PASSWORD = "cellphone";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Kết nối đến cơ sở dữ liệu thành công!");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Kết nối đến cơ sở dữ liệu thất bại!");
            throw new SQLException("MySQL Driver not found", e);
        }
    }
}