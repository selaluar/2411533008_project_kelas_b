package model;

public class Service {
    private int id;
    private String jenis;
    private double harga;
    private String status;

    // Constructor
    public Service(int id, String jenis, double harga, String status) {
        this.id = id;
        this.jenis = jenis;
        this.harga = harga;
        this.status = status;
    }

    // Getter dan Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Method untuk menampilkan data
    public void tampilkanData() {
        System.out.println("ID Service : " + id);
        System.out.println("Jenis      : " + jenis);
        System.out.println("Harga      : " + harga);
        System.out.println("Status     : " + status);
        System.out.println("-----------------------------");
    }
}