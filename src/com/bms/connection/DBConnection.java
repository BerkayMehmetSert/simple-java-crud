package com.bms.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    static Connection connection;
    
    public static Connection getConnection() {
        String databaseName = "";
        String url = "jdbc:mysql://localhost:3306/" + databaseName;
        String username = "";
        String password = "";
        try {
            connection = DriverManager.getConnection(url, username, password);
    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    
}

