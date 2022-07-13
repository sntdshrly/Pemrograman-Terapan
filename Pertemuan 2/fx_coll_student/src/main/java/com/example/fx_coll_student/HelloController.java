package com.example.fx_coll_student;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {
    @FXML
    private TextField txtNrp;
    @FXML
    private TextField txtNama;
    @FXML
    private TextField txtNrpHapus;
    @FXML
    private TextField txtNrpCari;
    @FXML
    private Button btnTambah;
    @FXML
    private Button btnHapus;
    @FXML
    private Button btnCari;
    @FXML
    private TableView<Student> table1;
    @FXML
    private TableColumn<String, Student> column1;
    @FXML
    private TableColumn<String, Student> column2;


    // declare variable
    private ObservableList<Student> sList;
    // alert
    Alert a = new Alert(Alert.AlertType.NONE);

    @FXML
    public void btnActionTambah(ActionEvent e) {
        String sListnrp = txtNrp.getText();
        String sListnama = txtNama.getText();
        sList.add(new Student(sListnrp, sListnama));
    }

    @FXML
    public void btnActionHapus(ActionEvent e) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to delete this data?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();

        String sListnrphapus = txtNrpHapus.getText();
        if (alert.getResult() == ButtonType.YES) {
            // cara ke-1
            // sList.removeIf(slist -> slist.getNrp().equals(sListnrphapus));

            // cara ke-2
            for (Student nrpSt: sList) {
                if (nrpSt.getNrp().equals(sListnrphapus)) {
                    sList.remove(nrpSt);
                    break;
                }
                else {
                    a.setAlertType(Alert.AlertType.ERROR);
                    // set content text
                    a.setContentText("NRP tidak ditemukan!");
                    // show the dialog
                    a.show();
                }
            }
        }


    }

    @FXML
    public void btnActionCari(ActionEvent e) {
        String sListnrpcari = txtNrpCari.getText();
        table1.setItems(sList.filtered(nrpSt -> nrpSt.getNrp().equals(sListnrpcari)));
        System.out.println(sList.filtered(nrpSt -> nrpSt.getNrp().equals(sListnrpcari)));
    }

    public void initialize() {
        sList = FXCollections.observableArrayList(
                new Student("01", "dummy data nama1"),
                new Student("02", "dummy data nama2")
        );
        // tampilin tabel
        column1.setText("NRP");
        column2.setText("Nama");
        table1.setItems(sList);
        column1.setCellValueFactory(new PropertyValueFactory<String, Student>("nrp"));
        column2.setCellValueFactory(new PropertyValueFactory<String, Student>("nama"));
    }
}