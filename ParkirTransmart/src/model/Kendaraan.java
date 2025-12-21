package model;

public abstract class Kendaraan {
    protected String plat;

    public Kendaraan(String plat) {
        this.plat = plat;
    }

    public String getPlat() {
        return plat;
    }

    public abstract int hitungTarif(int jam);
}
