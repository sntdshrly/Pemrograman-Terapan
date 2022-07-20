module com.example.demo_db_connect_2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.demo_db_connect_2 to javafx.fxml;
    exports com.example.demo_db_connect_2;

    opens com.example.demo_db_connect_2.controller to javafx.fxml;
    exports com.example.demo_db_connect_2.controller;

    opens com.example.demo_db_connect_2.dao to javafx.fxml;
    exports com.example.demo_db_connect_2.dao;

    opens com.example.demo_db_connect_2.entity to javafx.fxml;
    exports com.example.demo_db_connect_2.entity;

    opens com.example.demo_db_connect_2.util to javafx.fxml;
    exports com.example.demo_db_connect_2.util;
}