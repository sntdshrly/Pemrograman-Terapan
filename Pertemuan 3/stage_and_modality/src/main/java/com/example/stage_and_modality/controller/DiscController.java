package com.example.stage_and_modality.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;

import java.io.IOException;

public class DiscController {
    @FXML
    public TextField txtNewDisc;

    //declare
    private float newDisc;
    @FXML
    protected void onActionAddDisc(ActionEvent e) throws IOException {
        // di sini get buat diset
        newDisc = Float.parseFloat(txtNewDisc.getText());
        ((Node)e.getSource()).getScene().getWindow().hide();
    }
    // getter
    public float getNewDisc(){
        return newDisc;
    }
}
