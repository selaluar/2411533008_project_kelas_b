package model;

import java.time.LocalTime;

public class ParkirBuilder {

    private Parkir parkir;

    public ParkirBuilder() {
        parkir = new Parkir();
    }

    public ParkirBuilder plat(String plat) {
        parkir.setPlat(plat);
        return this;
    }

    public ParkirBuilder jenis(String jenis) {
        parkir.setJenis(jenis);
        return this;
    }

    public ParkirBuilder masuk(LocalTime masuk) {
        parkir.setMasuk(masuk);
        return this;
    }

    public ParkirBuilder keluar(LocalTime keluar) {
        parkir.setKeluar(keluar);
        return this;
    }

    public ParkirBuilder tarif(int tarif) {
        parkir.setTarif(tarif);
        return this;
    }

    public Parkir build() {
        return parkir;
    }
}
