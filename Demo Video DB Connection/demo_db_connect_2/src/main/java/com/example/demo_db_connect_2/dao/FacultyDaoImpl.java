package com.example.demo_db_connect_2.dao;

import com.example.demo_db_connect_2.entity.Faculty;
import com.example.demo_db_connect_2.util.DaoService;
import com.example.demo_db_connect_2.util.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacultyDaoImpl implements DaoService<Faculty> {

    @Override
    public List<Faculty> fetchAll() throws SQLException, ClassNotFoundException {
        List<Faculty> faculties = new ArrayList<>();
        Connection connection = MySQLConnection.createConnection();
        String query = "SELECT id,name FROM faculty";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        // gunain looping utk masukin data dr result set ke dalam list yg udah dibuat
        while(rs.next()){
            Faculty faculty = new Faculty();
            faculty.setId(rs.getInt("id"));
            faculty.setName(rs.getString("name"));
            faculties.add(faculty);
        }
        rs.close();
        ps.close();
        connection.close();
        return faculties;
    }

    @Override
    public int addData(Faculty object) throws SQLException, ClassNotFoundException {
        int result = 0;
        Connection connection = MySQLConnection.createConnection();
        String query = "INSERT INTO faculty(name) VALUES(?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1,object.getName());
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
