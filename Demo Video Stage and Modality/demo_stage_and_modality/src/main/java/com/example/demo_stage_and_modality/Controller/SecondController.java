package com.example.demo_stage_and_modality.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SecondController {
    @FXML
    Button button2;
    @FXML
    Label label2;

    public String getIsiLabel(){
        return label2.getText();
    }
    public void isiLabel2(String isi){
        label2.setText(isi);
    }
    public void buttonAction2(ActionEvent ex){
        label2.setText("nilai baru");
        ((Node)ex.getSource()).getScene().getWindow().hide();
        // getSource ambil button, ambil scene, ambil stage, trs hide
    }
}
