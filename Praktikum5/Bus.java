package Praktikum5;
public class Bus extends Kendaraan implements TransportasiUmum {
    String kelasBus;

    public Bus(String merk, String model, int tahunProduksi, String kelasBus) {
        super(merk, model, tahunProduksi);
        this.kelasBus = kelasBus;
    }

    @Override
    public void nyalakanMesin() {
        System.out.println("Bus dinyalakan menggunakan sistem starter diesel.");
    }

    @Override
    public String jenisBahanBakar() {
        return "Solar";
    }

    @Override
    public int kapasitasPenumpang() {
        return 50;
    }

    public void fiturBus() {
        System.out.println("Fitur: Toilet, Kursi Reclining, Wi-Fi.");
    }

    public class JadwalPerjalanan {
        String rute;
        String waktuBerangkat;

        public JadwalPerjalanan(String rute, String waktuBerangkat) {
            this.rute = rute;
            this.waktuBerangkat = waktuBerangkat;
        }

        public void tampilkanJadwal() {
            System.out.println("Rute: " + rute);
            System.out.println("Waktu Berangkat: " + waktuBerangkat);
        }
    }
}
