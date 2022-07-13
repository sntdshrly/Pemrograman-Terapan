module com.example.demo_kelas_fx_coll {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demo_kelas_fx_coll to javafx.fxml;
    exports com.example.demo_kelas_fx_coll;
    exports model;
    opens model to javafx.fxml;
}