package model;

import java.time.LocalTime;

public class Parkir {

    private String plat;
    private String jenis;
    private LocalTime masuk;
    private LocalTime keluar;
    private int tarif;

    public String getPlat() {
        return plat;
    }

    public void setPlat(String plat) {
        this.plat = plat;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public LocalTime getMasuk() {
        return masuk;
    }

    public void setMasuk(LocalTime masuk) {
        this.masuk = masuk;
    }

    public LocalTime getKeluar() {
        return keluar;
    }

    public void setKeluar(LocalTime keluar) {
        this.keluar = keluar;
    }

    public int getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }
}
