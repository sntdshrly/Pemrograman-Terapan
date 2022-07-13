package com.example.demo;

import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {
    @FXML
    private ComboBox<Student> combo1;
    @FXML
    private ListView<Student> list1;
    @FXML
    private TableView<Student> table1;
    @FXML
    private Button button1;
    @FXML
    private TableColumn<String,Student> column1;

    private ObservableList<Student> sList; // supaya bisa pisahkan arraynya jadi taruh di atas sbg sebuah field

    public void buttonAction(ActionEvent e) {
    sList.add(new Student("contoh"));
    }

    public void initialize() {
        //list->array || map-> key and value || set-> array tp tdk berulang
        // contoh map
        ObservableMap<String, Student> mapStudent;
        mapStudent = FXCollections.observableHashMap();
        mapStudent.put("student1",new Student("amira"));
        mapStudent.put("student2",new Student("emira"));
        mapStudent.put("student3",new Student("umira"));
        // ambil studentnya dari map
        Student s = mapStudent.get("student3");

        // contoh set
        ObservableSet<Student> setStudent;
        setStudent = FXCollections.observableSet();
        setStudent.add(new Student("set joni"));
        setStudent.add(new Student("set joni"));
        // ambilnya ga bisa pake get tp coba pake iterator
        for (Student st : setStudent) {
            System.out.println(st.getNama());
        }

        // contoh list
        sList = FXCollections.observableArrayList(
                new Student("amir"),
                new Student("george"),
                new Student("samira")
        );
        // pakai observable list supaya bisa ada seperti addlistener
        sList.addListener(new ListChangeListener<Student>() {
            @Override
            public void onChanged(Change<? extends Student> change) {
                System.out.println("data berubah"); // kalau terjadi suatu perubahan di sList, tlg print data berubah
            }
        });

        sList.add(new Student("jesi"));
        list1.setItems(sList);
        combo1.setItems(sList);
        combo1.getSelectionModel().select(0);

        // buat isi tabelnya
        table1.setItems(sList);
        column1.setCellValueFactory(new PropertyValueFactory<String,Student>("nama"));
    }
}