package com.example.kalkulator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField display;
    @FXML
    private Button satu,dua,tiga,empat,lima,enam,tujuh,delapan,sembilan,nol,
            add,sub,mul,div,eq,clear;
    // Deklarasi variabel
    float data1, data2, answer;
    int operation;

    @FXML
    protected void handleAction(ActionEvent event) {
        if (event.getSource()==satu){
            display.setText(display.getText() + "1");
        }
        else if (event.getSource()==dua){
            display.setText(display.getText() + "2");
        }
        else if (event.getSource()==tiga){
            display.setText(display.getText() + "3");
        }
        else if (event.getSource()==empat){
            display.setText(display.getText() + "4");
        }
        else if (event.getSource()==lima){
            display.setText(display.getText() + "5");
        }
        else if (event.getSource()==enam){
            display.setText(display.getText() + "6");
        }
        else if (event.getSource()==tujuh){
            display.setText(display.getText() + "7");
        }
        else if (event.getSource()==delapan){
            display.setText(display.getText() + "8");
        }
        else if (event.getSource()==sembilan){
            display.setText(display.getText() + "9");
        }
        else if (event.getSource()==nol){
            display.setText(display.getText() + "0");
        }
        else if (event.getSource()==clear){
            display.setText("");
        }
        // operasinya
        if (event.getSource() == add){
            data1 = Float.parseFloat(display.getText());
            display.setText("");
            this.operation = 1;
        }
        else if (event.getSource() == sub){
            data1 = Float.parseFloat(display.getText());
            display.setText("");
            this.operation = 2;
        }
        else if (event.getSource() == mul){
            data1 = Float.parseFloat(display.getText());
            display.setText("");
            this.operation = 3;
        }
        else if (event.getSource() == div){
            data1 = Float.parseFloat(display.getText());
            display.setText("");
            this.operation = 4;
        }
        // display!
        if (event.getSource() == eq){
            data2 = Float.parseFloat(display.getText());
            switch (operation) {
                case 1: this.answer = data1 + data2;
                display.setText(String.valueOf(answer));
                break;

                case 2: this.answer = data1 - data2;
                    display.setText(String.valueOf(answer));
                    break;

                case 3: this.answer = data1 * data2;
                    display.setText(String.valueOf(answer));
                    break;
                case 4: this.answer = data1 / data2;
                    display.setText(String.valueOf(answer));
                    break;
            }
        }

    }
}