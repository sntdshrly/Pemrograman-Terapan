package com.example.demo_stage_and_modality.Model;

import java.time.Instant;
import java.util.Date;

public class Pesan {
    private Date tgl;
    private String pesan;

    public Pesan(String pesan){
        this.pesan = pesan;
        this.tgl = Date.from(Instant.now());
    }

    @Override
    public String toString(){
        return "Pesan{" + "tgl=" + tgl + ", pesan='" + pesan + '\'' + '}';
    }

    public void setPesan(String pesan){
        this.pesan = pesan;
    }
    public Date getTgl(){
        return tgl;
    }
    public String getPesan(){
        return pesan;
    }
}
