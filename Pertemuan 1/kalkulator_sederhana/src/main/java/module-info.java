module com.example.kalkulator_sederhana {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kalkulator_sederhana to javafx.fxml;
    exports com.example.kalkulator_sederhana;
}