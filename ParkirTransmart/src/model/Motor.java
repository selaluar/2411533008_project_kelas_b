package model;

public class Motor extends Kendaraan {
    public Motor(String plat) {
        super(plat);
    }

    @Override
    public int hitungTarif(int jam) {
        return jam * 3000;
    }
}
