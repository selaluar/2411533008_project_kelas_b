package service;


import DAO.ParkirDAO;
import DAO.ParkirRepo;
import error.ValidationException;
import model.Parkir;
import model.ParkirBuilder;

import java.time.Duration;
import java.time.LocalTime;

public class ParkirService {

    private final ParkirDAO parkirDAO = new ParkirRepo();
    private Parkir parkirAktif;

    // ================= HITUNG TARIF =================
    public Parkir hitungTarif(
            String plat,
            String jenis,
            LocalTime masuk,
            LocalTime keluar
    ) {

        if (plat == null || plat.isEmpty()) {
            throw new ValidationException("Plat nomor wajib diisi");
        }

        if (masuk == null || keluar == null) {
            throw new ValidationException("Jam masuk & keluar wajib diisi");
        }

        if (keluar.isBefore(masuk)) {
            throw new ValidationException("Jam keluar tidak boleh lebih awal dari jam masuk");
        }

        long jam = Duration.between(masuk, keluar).toHours();
        if (jam <= 0) jam = 1;

        int tarifPerJam;
        if (jenis.equalsIgnoreCase("Mobil")) {
            tarifPerJam = 5000;
        } else if (jenis.equalsIgnoreCase("Motor")) {
            tarifPerJam = 3000;
        } else {
            throw new ValidationException("Jenis kendaraan tidak valid");
        }

        int totalTarif = (int) jam * tarifPerJam;

        parkirAktif = new ParkirBuilder()
                .plat(plat)
                .jenis(jenis)
                .masuk(masuk)
                .keluar(keluar)
                .tarif(totalTarif)
                .build();

        return parkirAktif;
    }

    // ================= SIMPAN =================
    public void simpanParkir() {
        if (parkirAktif == null) {
            throw new ValidationException("Hitung tarif terlebih dahulu");
        }
        parkirDAO.save(parkirAktif);
        parkirAktif = null;
    }
}
