package com.example.sharing_data_fxml.controller;

import com.example.sharing_data_fxml.Main;
import com.example.sharing_data_fxml.model.Citizen;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private ObservableList<Citizen> citizens;
    @FXML
    private void closeAction(ActionEvent actionEvent) {
    }
    @FXML
    private void openFirstAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("first-layout.fxml"));
        Parent root = loader.load();
        FirstController controller = loader.getController();
        controller.setMainController(this);
        Stage firstStage = new Stage();
        firstStage.setTitle("Java FX Data Sharing");
        firstStage.setScene(new Scene(root));
        firstStage.show();
    }
    @FXML
    private void openSecondAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("second-layout.fxml"));
        Parent root = loader.load();
        SecondController controller = loader.getController();
        controller.setMainController(this);
        Stage secondStage = new Stage();
        secondStage.setTitle("Java FX Data Sharing");
        secondStage.setScene(new Scene(root));
        secondStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        citizens = FXCollections.observableArrayList();
    }
    public ObservableList<Citizen> getCitizens(){
        return citizens;
    }

}