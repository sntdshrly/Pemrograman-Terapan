package com.example.sharing_data_fxml.controller;

import com.example.sharing_data_fxml.Main;
import com.example.sharing_data_fxml.model.Citizen;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class SecondController implements Initializable {
    @FXML
    private TableView<Citizen> tableCitizen;
    @FXML
    private TableColumn<Citizen,String> colId;
    @FXML
    private TableColumn<Citizen,String>  colName;
    private MainController mainController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    colName.setCellValueFactory(data->new SimpleStringProperty(data.getValue().getFirstname() + " " + data.getValue().getLastName()));
    colId.setCellValueFactory(data->new SimpleStringProperty(data.getValue().getId()));
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
        tableCitizen.setItems(mainController.getCitizens());
    }
}