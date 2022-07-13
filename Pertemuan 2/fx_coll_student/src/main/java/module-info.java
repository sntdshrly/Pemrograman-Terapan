module com.example.fx_coll_student {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fx_coll_student to javafx.fxml;
    exports com.example.fx_coll_student;
}