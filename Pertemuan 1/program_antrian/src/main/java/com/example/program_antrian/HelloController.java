package com.example.program_antrian;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Button addButton,resetButton;
    @FXML
    private TextField display;
    // Declare Var.
    int hitung=0;
    @FXML
    protected void onClickEvent(ActionEvent event) {
        if (event.getSource()==addButton){
            hitung = hitung + 1;
            display.setText(String.valueOf(hitung));
        }
        else if (event.getSource()==resetButton){
            display.setText("");
            hitung = 0;
        }
    }
}