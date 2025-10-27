package Praktikum5;
public class Main {
    public static void main(String[] args) {
        Mobil mobil = new Mobil("Toyota", "Avanza", 2022, "Automatic");
        Bus bus = new Bus("Mercedes-Benz", "OH 1526", 2020, "Eksekutif");
        Pesawat pesawat = new Pesawat("Boeing", "737 Max", 2019, "Jet", "Garuda Indonesia");

        System.out.println("=== Informasi Mobil ===");
        mobil.tampilkanInfo();
        mobil.nyalakanMesin();
        System.out.println("Bahan Bakar: " + mobil.jenisBahanBakar());
        mobil.fiturMobil();
        mobil.infoKonsumsi();

        System.out.println("\n=== Informasi Bus ===");
        bus.tampilkanInfo();
        bus.nyalakanMesin();
        System.out.println("Bahan Bakar: " + bus.jenisBahanBakar());
        System.out.println("Kapasitas: " + bus.kapasitasPenumpang() + " Penumpang");
        bus.fiturBus();
        bus.infoKonsumsi();

        Bus.JadwalPerjalanan jadwal = bus.new JadwalPerjalanan("Padang - Pekanbaru", "08:00");
        jadwal.tampilkanJadwal();

        System.out.println("\n=== Informasi Pesawat ===");
        pesawat.tampilkanInfo();
        pesawat.nyalakanMesin();
        System.out.println("Bahan Bakar: " + pesawat.jenisBahanBakar());
        pesawat.jenisPenerbangan();
        System.out.println("Maskapai: " + pesawat.namaMaskapai());
        pesawat.infoKonsumsi();
    }
}
