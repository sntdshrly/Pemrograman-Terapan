module com.example.stage_and_modality {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.stage_and_modality to javafx.fxml;
    exports com.example.stage_and_modality;
    exports com.example.stage_and_modality.controller;
    opens com.example.stage_and_modality.controller to javafx.fxml;
}