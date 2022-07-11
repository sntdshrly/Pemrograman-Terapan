module com.example.button_and_shape {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.button_and_shape to javafx.fxml;
    exports com.example.button_and_shape;
}