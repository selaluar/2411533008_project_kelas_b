package model;

import java.util.Date;

public class Order {
    private int id;
    private int id_costumer;
    private int id_service;
    private int id_user;
    private double total;
    private Date tanggal;
    private Date tanggal_selesai;
    private String status;
    private String status_pembayaran;

    // Constructor
    public Order(int id, int id_costumer, int id_service, int id_user, double total,
                 Date tanggal, Date tanggal_selesai, String status, String status_pembayaran) {
        this.id = id;
        this.id_costumer = id_costumer;
        this.id_service = id_service;
        this.id_user = id_user;
        this.total = total;
        this.tanggal = tanggal;
        this.tanggal_selesai = tanggal_selesai;
        this.status = status;
        this.status_pembayaran = status_pembayaran;
    }

    // Getter dan Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_costumer() {
        return id_costumer;
    }

    public void setId_costumer(int id_costumer) {
        this.id_costumer = id_costumer;
    }

    public int getId_service() {
        return id_service;
    }

    public void setId_service(int id_service) {
        this.id_service = id_service;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Date getTanggal_selesai() {
        return tanggal_selesai;
    }

    public void setTanggal_selesai(Date tanggal_selesai) {
        this.tanggal_selesai = tanggal_selesai;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus_pembayaran() {
        return status_pembayaran;
    }

    public void setStatus_pembayaran(String status_pembayaran) {
        this.status_pembayaran = status_pembayaran;
    }

    // Method untuk menampilkan data
    public void tampilkanData() {
        System.out.println("ID Order           : " + id);
        System.out.println("ID Costumer        : " + id_costumer);
        System.out.println("ID Service         : " + id_service);
        System.out.println("ID User            : " + id_user);
        System.out.println("Total              : " + total);
        System.out.println("Tanggal            : " + tanggal);
        System.out.println("Tanggal Selesai    : " + tanggal_selesai);
        System.out.println("Status             : " + status);
        System.out.println("Status Pembayaran  : " + status_pembayaran);
        System.out.println("----------------------------------");
    }
}