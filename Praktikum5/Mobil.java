package Praktikum5;
public final class Mobil extends Kendaraan implements BahanBakar {
    String jenisTransmisi;

    public Mobil(String merk, String model, int tahunProduksi, String jenisTransmisi) {
        super(merk, model, tahunProduksi);
        this.jenisTransmisi = jenisTransmisi;
    }

    @Override
    public void nyalakanMesin() {
        System.out.println("Mobil dinyalakan dengan menekan tombol Start/Stop atau memutar kunci.");
    }

    @Override
    public String jenisBahanBakar() {
        return "Bensin";
    }

    public void fiturMobil() {
        System.out.println("Fitur: AC, Airbag, Sensor Parkir.");
    }
}
