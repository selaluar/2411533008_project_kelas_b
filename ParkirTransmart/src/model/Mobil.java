package model;

public class Mobil extends Kendaraan {
    public Mobil(String plat) {
        super(plat);
    }

    @Override
    public int hitungTarif(int jam) {
        return jam * 5000;
    }
}
