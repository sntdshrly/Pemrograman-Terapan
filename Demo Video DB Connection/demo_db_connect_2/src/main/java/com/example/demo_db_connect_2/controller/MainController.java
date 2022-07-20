package com.example.demo_db_connect_2.controller;

import com.example.demo_db_connect_2.dao.DepartmentDaoImpl;
import com.example.demo_db_connect_2.dao.FacultyDaoImpl;
import com.example.demo_db_connect_2.entity.Department;
import com.example.demo_db_connect_2.entity.Faculty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private TextField txtFacultyName;
    @FXML
    private TableView<Faculty> tableFaculty;
    @FXML
    private TableColumn<Faculty, Integer> facultyCol01;
    @FXML
    private TableColumn<Faculty, String> facultyCol02;
    @FXML
    private TextField txtDepartmentName;
    @FXML
    private ComboBox<Faculty> comboFaculty;
    @FXML
    private TableView<Department> tableDepartment;
    @FXML
    private TableColumn<Department, Integer> departmentCol01;
    @FXML
    private TableColumn<Department, String> departmentCol02;
    @FXML
    private TableColumn<Department, Faculty> departmentCol03;

    // declare var
    private ObservableList<Department> departments;
    private ObservableList<Faculty> faculties;
    private DepartmentDaoImpl departmentDao;
    private FacultyDaoImpl facultyDao;

    public void saveFacultyAction(ActionEvent actionEvent) {
        if(txtFacultyName.getText().trim().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please fill faculty name!");
            alert.showAndWait();
        }
        else{
            Faculty faculty = new Faculty();
            faculty.setName(txtFacultyName.getText().trim());
            // jika return add data satu maka akan kosongin list dan isi dg data baru
            try {
                if(facultyDao.addData(faculty)==1){
                    faculties.clear();
                    faculties.addAll(facultyDao.fetchAll());
                    txtFacultyName.clear();
                }
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void saveDepartmentAction(ActionEvent actionEvent) {
        if(txtDepartmentName.getText().trim().isEmpty() || comboFaculty.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please fill department name and select faculty!");
            alert.showAndWait();
        }
        else{
            Department department = new Department();
            department.setName(txtDepartmentName.getText().trim());
            department.setFaculty(comboFaculty.getValue());
            // jika return add data satu maka akan kosongin list dan isi dg data baru
            try {
                if(departmentDao.addData(department)==1){
                    departments.clear();
                    departments.addAll(departmentDao.fetchAll());
                    txtDepartmentName.clear();
                }
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        facultyDao = new FacultyDaoImpl();
        departmentDao = new DepartmentDaoImpl();
        faculties = FXCollections.observableArrayList();
        departments = FXCollections.observableArrayList();

        try{
            faculties.addAll(facultyDao.fetchAll());
            departments.addAll(departmentDao.fetchAll());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        comboFaculty.setItems(faculties);
        tableFaculty.setItems(faculties);
        facultyCol01.setCellValueFactory(data-> new SimpleIntegerProperty(data.getValue().getId()).asObject());
        facultyCol02.setCellValueFactory(data-> new SimpleStringProperty(data.getValue().getName()));

        tableDepartment.setItems(departments);
        departmentCol01.setCellValueFactory(data-> new SimpleIntegerProperty(data.getValue().getId()).asObject());
        departmentCol02.setCellValueFactory(data-> new SimpleStringProperty(data.getValue().getName()));
        departmentCol03.setCellValueFactory(data-> new SimpleObjectProperty<>(data.getValue().getFaculty()));

    }
}
