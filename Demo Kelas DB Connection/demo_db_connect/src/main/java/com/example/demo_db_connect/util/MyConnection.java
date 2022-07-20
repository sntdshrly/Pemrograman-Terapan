package com.example.demo_db_connect.util;
import java.sql.Connection; // nanti ada requires java.sql; di module-info
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    // Connection dari java.sql
    public static Connection getConnection(){
    Connection conn;
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/contoh_db",
                "root",
                ""
        );
    }
    catch (ClassNotFoundException | SQLException e){
        throw new RuntimeException(e);
    }
    return conn;
    }

}
