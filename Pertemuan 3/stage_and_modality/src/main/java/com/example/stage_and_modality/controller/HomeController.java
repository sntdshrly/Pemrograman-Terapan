package com.example.stage_and_modality.controller;

import com.example.stage_and_modality.Main;
import javafx.collections.FXCollections;
import com.example.stage_and_modality.model.Menu;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;


public class HomeController {
    @FXML
    private ListView<Menu> listView;

    // declare variable
    private ObservableList<Menu> menuList;
    Stage new_stage;

    public void initialize() {
        new_stage = new Stage();
        menuList = FXCollections.observableArrayList(
                // di sini after_disc_price nya gpp manual nanti dia ketimpa sama constructor
                new Menu("dummy data",10000, 0.1f,9000),
                new Menu("dummy data",10000,0.2f,8000),
                new Menu("dummy data",20000,0.0f,20000)
        );
        // tampilin list
        listView.setItems(menuList);


    }

    // di sini function untuk setting custom discount, kebetulan dia bikin window baru
    @FXML
    protected void onActionAddTo(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("add-view.fxml")); // open window add-view.fxml
        Parent root = loader.load(); // bisa jadi error makanya pake try-catch atau throws exception
        Scene new_scene = new Scene(root);
        new_stage.setScene(new_scene);
        AddController addCont = loader.getController();

        new_stage.showAndWait();

        // harus di bawah show and wait supaya pas di close bisa dapetin valuenya
        menuList.add(new Menu(addCont.getNama(), addCont.getHarga(), addCont.getDisc(), addCont.getNewAfterDisc()));
    }
}