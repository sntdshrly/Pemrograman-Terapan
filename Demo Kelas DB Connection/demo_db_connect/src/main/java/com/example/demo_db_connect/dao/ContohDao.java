package com.example.demo_db_connect.dao;

import com.example.demo_db_connect.model.Contoh;
import com.example.demo_db_connect.util.MyConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContohDao implements DaoInterface<Contoh>{

    @Override
    public ObservableList<Contoh> getData() {
        ObservableList<Contoh> cList;
        cList = FXCollections.observableArrayList();
        Connection conn = MyConnection.getConnection();
        String query = "select * from contoh";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ResultSet hasil = ps.executeQuery();
            while(hasil.next()){
                int id = hasil.getInt("id");
                String nama = hasil.getString("nama");
                Contoh c = new Contoh(id, nama);
                cList.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    return cList;
    }

    @Override
    public void addData(Contoh data) {
        Connection conn = MyConnection.getConnection();
        String query = "insert into contoh(nama) values (?)";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, data.getNama());
            int hasil = ps.executeUpdate();

            if (hasil>0){
                System.out.println("berhasil masukin data");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delData(Contoh data) {

    }
}
