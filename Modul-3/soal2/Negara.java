package Modul3.soal2;
import java.util.HashMap;
public class Negara {
    private String nama;
    private String jenisKepemimpinan;
    private String namaPemimpin;
    private int tanggalKemerdekaan;
    private int bulanKemerdekaan;
    private int tahunKemerdekaan;
    
    public Negara(String nama, String jenisKepemimpinan, String namaPemimpin, int tanggal, int bulan, int tahun) {
        this.nama = nama;
        this.jenisKepemimpinan = jenisKepemimpinan;
        this.namaPemimpin = namaPemimpin;
        this.tanggalKemerdekaan = tanggal;
        this.bulanKemerdekaan = bulan;
        this.tahunKemerdekaan = tahun;
    }

    public Negara(String nama, String jenisKepemimpinan, String namaPemimpin) {
        this.nama = nama;
        this.jenisKepemimpinan = jenisKepemimpinan;
        this.namaPemimpin = namaPemimpin;
        this.bulanKemerdekaan = 0; 
    }

    public void displayInfo(HashMap<Integer, String> petaBulan) {
        String sebutanPemimpin;

        if (this.jenisKepemimpinan.equalsIgnoreCase("monarki")) {
            sebutanPemimpin = "Raja";
        } else {
            sebutanPemimpin = this.jenisKepemimpinan.substring(0, 1).toUpperCase() + this.jenisKepemimpinan.substring(1).toLowerCase();
        }
        System.out.println("Negara " + this.nama + " mempunyai " + sebutanPemimpin + " bernama " + this.namaPemimpin);

        if (this.bulanKemerdekaan > 0) {
            String namaBulan = petaBulan.get(this.bulanKemerdekaan);
            System.out.println("Deklarasi Kemerdekaan pada Tanggal " + this.tanggalKemerdekaan + " " + namaBulan + " " + this.tahunKemerdekaan);
        }
    }
}