package com.example.demo_db_connect.dao;

import javafx.collections.ObservableList;

public interface DaoInterface<T> {
    ObservableList<T> getData();
    void addData(T data);
    void delData(T data);
}
