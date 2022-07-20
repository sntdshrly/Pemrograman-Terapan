package com.example.demo_db_connect.model;

public class Contoh {

    // sesuai dengan kolom di db
    private int id;
    private String nama;

    @Override
    public String toString() {
        return "Contoh{" +
                "id=" + id +
                ", nama='" + nama + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Contoh(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }
}
