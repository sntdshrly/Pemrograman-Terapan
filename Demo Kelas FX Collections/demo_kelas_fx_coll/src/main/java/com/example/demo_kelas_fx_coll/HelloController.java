package com.example.demo_kelas_fx_coll;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.ItemJualan;

import java.util.ArrayList;
import java.util.Arrays;

public class HelloController {
    @FXML
    private ListView listview1;
    @FXML
    private TableView<ItemJualan> table1;
    @FXML
    private TableColumn<String,ItemJualan> column1;

    private ObservableList<Integer> oList; // begitu data berubah, data di desktopnya berubah
    private ObservableList<ItemJualan> oItem;

    public void initialize(){
        oItem = FXCollections.observableArrayList(
                new ItemJualan(1,"obat nyamuk",2000),
                new ItemJualan(2,"obat gatel",3000),
                new ItemJualan(3,"obat amnesia",4000)
        );

        oItem.add(new ItemJualan(4,"elx",100));
        listview1.setItems(oItem);
        table1.setItems(oItem);
        column1.setText("nama");
        column1.setCellValueFactory(new PropertyValueFactory<String,ItemJualan>("nama"));
    }

    @FXML
    protected void onHelloButtonClick() {
        // ----- array biasa -----
//        int[] arrayint;
//        String[] arrayString;
//
//        arrayint = new int[5];
//        arrayint[0] = 5;
//        arrayint[3] = 7;
//        arrayint[1] = 2;
//        arrayint[4] = 2;
////        arrayint[5]=5; ga bisa soalnya cuman 0-4
//
////        for(int i=0;i<5;i++){
////            arrayint[i] = i*2; //0 2 4 6 8
////            System.out.println(arrayint[i]);
////        }
//
//        for(int a : arrayint){
//            System.out.println(a);
//        }
////         cara ubah array tapi agak repot
//        arrayint = Arrays.copyOf(arrayint,arrayint.length+10);

        // ----- array list -----
//        int[] arrayint;
//
//        ArrayList<Integer> arraylist; //Integer yg object punya properti || wrapper class
//        arrayint = new int[5];
//        arraylist = new ArrayList<Integer>();
//
//        arraylist.add(4);
//        arraylist.add(0,4);
//        arraylist.remove(0);
//        Integer c = arraylist.get(2);
//        arraylist.remove(arraylist.get(0));

        // ----- observable array list -----
//        oList = FXCollections.observableArrayList();
//        oList.add(1);
//        oList.add(2);
//        oList.add(3);
//
//        listview1.setItems(oList);

    }


}