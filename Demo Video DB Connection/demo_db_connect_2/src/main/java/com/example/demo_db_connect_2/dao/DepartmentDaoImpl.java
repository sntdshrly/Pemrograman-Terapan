package com.example.demo_db_connect_2.dao;

import com.example.demo_db_connect_2.entity.Department;
import com.example.demo_db_connect_2.entity.Faculty;
import com.example.demo_db_connect_2.util.DaoService;
import com.example.demo_db_connect_2.util.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImpl implements DaoService<Department> {

    @Override
    public List<Department> fetchAll() throws SQLException, ClassNotFoundException {
        List<Department> departments = new ArrayList<>();
        Connection connection = MySQLConnection.createConnection();
        String query = "SELECT d.id, d.name, d.faculty_id, f.name AS faculty_name FROM department d JOIN faculty f ON d.faculty_id = f.id";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        // gunain looping utk masukin data dr result set ke dalam list yg udah dibuat
        while(rs.next()){
            Faculty faculty = new Faculty();
            faculty.setId(rs.getInt("faculty_id"));
            faculty.setName(rs.getString("faculty_name"));

            Department department = new Department();
            department.setId(rs.getInt("id"));
            department.setName(rs.getString("name"));
            department.setFaculty(faculty);
            departments.add(department);
        }
        rs.close();
        ps.close();
        connection.close();
        return departments;
    }

    @Override
    public int addData(Department object) throws SQLException, ClassNotFoundException {
        int result = 0;
        Connection connection = MySQLConnection.createConnection();
        String query = "INSERT INTO department(name, faculty_id) VALUES(?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1,object.getName());
        ps.setInt(2,object.getFaculty().getId());
        if (ps.executeUpdate() != 0){
            connection.commit();
            result = 1;
        }
        else {
            connection.rollback();
        }
        ps.close();
        connection.close();
        return result;
    }
    }

