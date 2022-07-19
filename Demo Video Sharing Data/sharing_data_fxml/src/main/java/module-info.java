module com.example.sharing_data_fxml {
    requires javafx.controls;
    requires javafx.fxml;


    // diexport com.example.xxx
    opens com.example.sharing_data_fxml to javafx.fxml;
    exports com.example.sharing_data_fxml;

    // diexport modelnya
    opens com.example.sharing_data_fxml.model to javafx.fxml;
    exports com.example.sharing_data_fxml.model;

    // diexport controllerya
    exports com.example.sharing_data_fxml.controller;
    opens com.example.sharing_data_fxml.controller to javafx.fxml;

}