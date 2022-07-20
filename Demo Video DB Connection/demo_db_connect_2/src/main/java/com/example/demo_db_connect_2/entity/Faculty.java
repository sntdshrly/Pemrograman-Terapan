package com.example.demo_db_connect_2.entity;

public class Faculty {
    private int id;
    private String name;


    public Faculty(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Faculty() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
