module com.example.program_antrian {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.program_antrian to javafx.fxml;
    exports com.example.program_antrian;
}