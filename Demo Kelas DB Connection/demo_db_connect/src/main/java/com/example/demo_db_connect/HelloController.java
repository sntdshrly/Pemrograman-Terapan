package com.example.demo_db_connect;

import com.example.demo_db_connect.dao.ContohDao;
import com.example.demo_db_connect.model.Contoh;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class HelloController {
    public ListView listview1;
    @FXML
    private Label welcomeText;
    private ObservableList<Contoh> clist_tampilan;

    public void initialize(){
        ContohDao dao = new ContohDao();
        clist_tampilan = dao.getData();
        listview1.setItems(clist_tampilan);
    }

    @FXML
    protected void onHelloButtonClick() {
    ContohDao dao = new ContohDao();
    dao.addData(new Contoh(-1,"tes"));
    clist_tampilan = dao.getData();
    listview1.setItems(clist_tampilan);
}}