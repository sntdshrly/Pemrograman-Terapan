package model;

public class ItemJualan {
    private int id;
    private String nama;
    private float harga;

    public ItemJualan(int id, String nama, float harga) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
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

    public float getHarga() {
        return harga;
    }

    public void setHarga(float harga) {
        this.harga = harga;
    }

    @Override
    public String toString() {
        return  "nama='" + nama + '\'' +
                ", harga=" + harga;
    }
}
