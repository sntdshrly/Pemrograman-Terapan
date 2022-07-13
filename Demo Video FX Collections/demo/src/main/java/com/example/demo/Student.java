package com.example.demo;

public class Student {
    private String nama;
    public Student(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String n) {
        this.nama = n;
    }

    public String toString() {
        return "nama:" + nama;
    }

}