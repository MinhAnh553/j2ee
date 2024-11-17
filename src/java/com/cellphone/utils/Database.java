package com.cellphone.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    // Phương thức để kết nối cơ sở dữ liệu
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://103.74.101.111:3306/cellphone?useSSL=false";
        String user = "cellphone";
        String password = "cellphone";

        return DriverManager.getConnection(url, user, password);
    }
}
