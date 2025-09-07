package model;

public class Costumer {
	// File: Costumer.java
	    // Attribute
	    private int id;
	    private String nama;
	    private String alamat;
	    private String nomorHp;

	    // Constructor
	    public Costumer(int id, String nama, String alamat, String nomorHp) {
	        this.id = id;
	        this.nama = nama;
	        this.alamat = alamat;
	        this.nomorHp = nomorHp;
	    }

	    // Getter dan Setter
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getNama() {
	        return nama;
	    }

	    public void setNama(String nama) {
	        this.nama = nama;
	    }

	    public String getAlamat() {
	        return alamat;
	    }

	    public void setAlamat(String alamat) {
	        this.alamat = alamat;
	    }

	    public String getNomorHp() {
	        return nomorHp;
	    }

	    public void setNomorHp(String nomorHp) {
	        this.nomorHp = nomorHp;
	    }

	    // Method untuk menampilkan data costumer
	    public void tampilkanData() {
	        System.out.println("ID       : " + id);
	        System.out.println("Nama     : " + nama);
	        System.out.println("Alamat   : " + alamat);
	        System.out.println("Nomor HP : " + nomorHp);
	        System.out.println("---------------------------");
	    }
	}