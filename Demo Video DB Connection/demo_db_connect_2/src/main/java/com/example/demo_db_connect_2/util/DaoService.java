package com.example.demo_db_connect_2.util;

import java.sql.SQLException;
import java.util.List;

public interface DaoService<T> {
    // method
    List<T> fetchAll() throws SQLException,ClassNotFoundException;
    int addData(T object) throws SQLException,ClassNotFoundException;
}
