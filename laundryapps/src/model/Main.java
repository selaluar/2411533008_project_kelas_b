package model;

public class Main {
	// File: Main.java
	
	    public static void main(String[] args) {
	        // Membuat object Costumer
	        Costumer c1 = new Costumer(1, "Budi", "Jakarta", "08123456789");
	        Costumer c2 = new Costumer(2, "Siti", "Bandung", "08234567890");

	        // Menampilkan data costumer
	        c1.tampilkanData();
	        c2.tampilkanData();

	        // Menggunakan setter untuk ubah data
	        c1.setNama("Budi Santoso");
	        c1.setAlamat("Surabaya");

	        // Menampilkan data setelah diubah
	        System.out.println("Setelah update data:");
	        c1.tampilkanData();
	    }
	}


	