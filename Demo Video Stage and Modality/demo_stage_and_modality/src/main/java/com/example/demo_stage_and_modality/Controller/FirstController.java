package com.example.demo_stage_and_modality.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstController {
    @FXML
    TextField text1;
    @FXML
    Label label1;
    @FXML
    Button button1;
    Stage new_stage;
//    Stage new_stage2;


    // dibuat di initialize biar page/stage nya ga muncul berulang" ; jadi cuman scenenya aja yg diganti
    public void initialize(){
        // supaya ketika klik button nampilin window baru
        new_stage = new Stage();
//        new_stage2 = new Stage();
    }

    public void buttonAction(ActionEvent ex) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("View/second.fxml"));
        Parent root = loader.load(); // bisa jadi error makanya pake try-catch atau throws exception
        Scene new_scene = new Scene(root);

//        try {
//            Scene scene = new Scene(loader.load());
//        } catch (IOException e){
        // bakal dicatch kalo ada error, lbh bagus drpd throws
//            System.out.println(e.getMessage());
//        }

//        // contoh buat app modal
//        new_stage.setScene(new_scene);
//        new_stage.setTitle("page 2");
//        new_stage.show();

        new_stage.setScene(new_scene);
        // Modality none -> standard
        // Application modal -> ketika kita punya stage baru maka yg lampau akan didisable
        // Window modal -> kita perlu 1 buah stage baru -> hanya parent stage saja yg tidak aktif
//        new_stage.initModality(Modality.APPLICATION_MODAL);
//        new_stage.initOwner(new_stage2); //parent dr new stage adalah new stage 2, new stage 3 parentnya new stage 2
        new_stage.setTitle("page 2");

        // sblm di show kita pengen load dulu controller
        SecondController sc = loader.getController();
        sc.isiLabel2(text1.getText()); // yg diisi di text 1 akan ditampilkan di label 2

        // perbedaan show dan show and wait adalah kalau show and wait ga akan dijalankan semua baris di bawahnya sampe ditutup si stagenya
        new_stage.showAndWait();

        System.out.println(sc.getIsiLabel()); // dapetin isi labelnya

    }

}
