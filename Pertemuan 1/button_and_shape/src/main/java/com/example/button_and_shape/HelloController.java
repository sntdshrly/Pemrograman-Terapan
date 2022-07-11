package com.example.button_and_shape;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HelloController {
    @FXML
    private Button b1,b2,b3,b4,b5,b6;

    @FXML
    protected void onClick(ActionEvent event) {
        if (event.getSource()==b1) {
            b1.setText("Clicked!");
        }
        else if (event.getSource()==b2) {
            b2.setText("Clicked!");
        }
        else if (event.getSource()==b3) {
            b3.setText("Clicked!");
        }
        else if (event.getSource()==b4) {
            b4.setText("Clicked!");
        }
        else if (event.getSource()==b5) {
            b5.setText("Clicked!");
        }
        else if (event.getSource()==b6) {
            b6.setText("Clicked!");
        }
    }
}