package com.example.stage_and_modality.controller;
import com.example.stage_and_modality.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;

public class AddController {
    @FXML
    private ComboBox<Float> comboDis;
    @FXML
    public TextField txtNama;
    @FXML
    public TextField txtHarga;
    // declare variable
    private ObservableList<Float> disList;
    private String newNama;
    private Float newHarga;
    private Float newDisc;
    private Float newAfterDisc;
    Stage new_stage;

    public void initialize() {
        new_stage = new Stage();
        disList = FXCollections.observableArrayList(
                0.0f, 0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f
        );
        // tampilin list
        comboDis.setItems(disList);
        comboDis.getSelectionModel().select(0);

    }

    // di sini function untuk setting custom discount, kebetulan dia bikin window baru
    @FXML
    protected void onActionDiscount(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("disc-view.fxml")); // open window disc-view.fxml
        Parent root = loader.load(); // bisa jadi error makanya pake try-catch atau throws exception
        Scene new_scene = new Scene(root);
        new_stage.setScene(new_scene);
        DiscController addDiscCont = loader.getController();
        new_stage.showAndWait();
        disList.add(addDiscCont.getNewDisc());
    }
    @FXML
    protected void onActionAddMenu(ActionEvent e) throws IOException {
        // di sini get buat diset
        newNama = txtNama.getText();
        newHarga = Float.parseFloat(txtHarga.getText());
        newDisc = Float.parseFloat(String.valueOf(comboDis.getSelectionModel().getSelectedItem()));
        newAfterDisc = newHarga - (newDisc*newHarga);
        ((Node)e.getSource()).getScene().getWindow().hide();
    }

    // getter
    public String getNama(){
        return newNama;
    }
    public Float getHarga(){
        return newHarga;
    }
    public Float getDisc(){
        return newDisc;
    }
    public Float getNewAfterDisc(){
        return newDisc;
    }
}

