package com.example.kalkulator_sederhana;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class HelloController {
    @FXML
    private TextField bil1,bil2,hasil;
    @FXML
    private Button buttonTambah,buttonKurang,buttonKali,buttonBagi;

    // Deklarasi variabel
    float bilangan1,bilangan2,hasilFloat;

    @FXML
    protected void onButtonClick(ActionEvent event) {
        try {
            bilangan1 = Float.parseFloat(bil1.getText());
            bilangan2 = Float.parseFloat(bil2.getText());
            if (event.getSource()==buttonTambah){
                hasilFloat = bilangan1+bilangan2;
            }
            else if (event.getSource()==buttonKurang){
                hasilFloat = bilangan1-bilangan2;
            }
            else if (event.getSource()==buttonKali){
                hasilFloat = bilangan1*bilangan2;
            }
            else if (event.getSource()==buttonBagi){
                hasilFloat = bilangan1/bilangan2;
            }
            // Buat cek di command line aja
            System.out.println(bilangan1);
            System.out.println(bilangan2);
            System.out.println(hasilFloat);
            hasil.setText(String.valueOf(hasilFloat));
        } catch (NumberFormatException e) {
            System.out.println("Masukan bilangan saja!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}