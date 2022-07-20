module com.example.demo_db_connect {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.demo_db_connect to javafx.fxml;
    exports com.example.demo_db_connect;
    exports com.example.demo_db_connect.util;
    exports com.example.demo_db_connect.model;
    exports com.example.demo_db_connect.dao;
}