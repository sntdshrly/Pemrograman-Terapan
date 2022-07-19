package com.example.sharing_data_fxml.controller;

import com.example.sharing_data_fxml.model.Citizen;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FirstController implements Initializable {
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TableView<Citizen> tabelCitizen;
    @FXML
    private TableColumn<Citizen, String> colId;
    @FXML
    private TableColumn<Citizen, String>  colFName;
    @FXML
    private TableColumn<Citizen, String>  colLName;
    private MainController mainController;
    @FXML
    private void saveAction(ActionEvent actionEvent) {
        Citizen citizen = new Citizen();
        citizen.setId(txtId.getText());
        citizen.setLastName(txtLastName.getText());
        citizen.setFirstname(txtFirstName.getText());
        mainController.getCitizens().add(citizen);
        txtId.clear();
        txtFirstName.clear();
        txtLastName.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colId.setCellValueFactory(data->new SimpleStringProperty(data.getValue().getId()));
        colFName.setCellValueFactory(data->new SimpleStringProperty(data.getValue().getFirstname()));
        colLName.setCellValueFactory(data->new SimpleStringProperty(data.getValue().getLastName()));
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
        tabelCitizen.setItems(mainController.getCitizens());
    }
}