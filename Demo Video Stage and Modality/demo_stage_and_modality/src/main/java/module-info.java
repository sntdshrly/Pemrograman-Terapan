module com.example.demo_stage_and_modality {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.demo_stage_and_modality to javafx.fxml;
    exports com.example.demo_stage_and_modality;
    exports com.example.demo_stage_and_modality.Controller;
    opens com.example.demo_stage_and_modality.Controller to javafx.fxml;
    exports com.example.demo_stage_and_modality.Model;
    opens com.example.demo_stage_and_modality.Model to javafx.fxml;
}