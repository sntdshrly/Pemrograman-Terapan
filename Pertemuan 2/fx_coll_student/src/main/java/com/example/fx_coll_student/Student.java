package com.example.fx_coll_student;

public class Student {
    private String nama;
    public String nrp;
    public Student(String nrp, String nama) {
        this.nama = nama;
        this.nrp = nrp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNrp() {
        return nrp;
    }

    public void setNrp(String nrp) {
        this.nrp = nrp;
    }

    public String toString() {
        return "nama:" + nama + "nrp:" + nrp;
    }
}
