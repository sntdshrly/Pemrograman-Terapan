package com.example.stage_and_modality.model;

public class Menu {
    public float after_disc_price;
    public String nama;
    public float original_price;
    public float discount;
    public Menu(String nama, float original_price, float discount, float after_disc_price) {
        this.nama = nama;
        this.original_price = original_price;
        this.discount = discount;
        this.after_disc_price = original_price-(discount*original_price);
    }
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public float getOriginalPrice() {
        return original_price;
    }

    public void setOriginalPrice(float original_price) {
        this.original_price = original_price;
    }

    public float getDiscount() { return discount; }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getAfterDiscPrice() { return after_disc_price; }

    public void setAfterDiscPrice(float after_disc_price) {
        this.after_disc_price = after_disc_price;
    }

    public String toString() {
        if (discount != 0.0) {
            // di sini diskon dikali 100 biar tampilannya bentuk persentase
            return nama + " " + after_disc_price + " (original price:" + original_price + ") discount: " + discount * 100 + "%";
        }
        else {
            return nama + " " + original_price;
        }
        }
}
