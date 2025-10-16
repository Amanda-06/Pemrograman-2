package Modul3.soal3;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

	    public static void main(String[] args) {
	        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
	        Scanner input = new Scanner(System.in);

	        while (true) {
	            tampilkanMenu();
	            System.out.print("Pilihan: ");
	            String pilihan = input.nextLine();

	            switch (pilihan) {
	                case "1":
	                    tambahMahasiswa(daftarMahasiswa, input);
	                    break;
	                case "2":
	                    hapusMahasiswa(daftarMahasiswa, input);
	                    break;
	                case "3":
	                    cariMahasiswa(daftarMahasiswa, input);
	                    break;
	                case "4":
	                    tampilkanDaftarMahasiswa(daftarMahasiswa);
	                    break;
	                case "0":
	                    System.out.println("Terima kasih!");
	                    input.close();
	                    return; 
	                default:
	                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
	                    break;
	            }
	        }
	    }

	    public static void tampilkanMenu() {
	        System.out.println("\nMenu:");
	        System.out.println("1. Tambah Mahasiswa");
	        System.out.println("2. Hapus Mahasiswa berdasarkan NIM");
	        System.out.println("3. Cari Mahasiswa berdasarkan NIM");
	        System.out.println("4. Tampilkan Daftar Mahasiswa");
	        System.out.println("0. Keluar");
	    }
	    
	    public static void tambahMahasiswa(ArrayList<Mahasiswa> daftar, Scanner input) {
	        System.out.print("Masukkan Nama Mahasiswa: ");
	        String nama = input.nextLine();
	        System.out.print("Masukkan NIM Mahasiswa (harus unik): ");
	        String nim = input.nextLine();

	        for (Mahasiswa mhs : daftar) {
	            if (mhs.getNim().equals(nim)) {
	                System.out.println("Mahasiswa dengan NIM " + nim + " sudah ada.");
	                return;
	            }
	        }

	        daftar.add(new Mahasiswa(nama, nim));
	        System.out.println("Mahasiswa " + nama + " ditambahkan.");
	    }
	    
	    public static void hapusMahasiswa(ArrayList<Mahasiswa> daftar, Scanner input) {
	        System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
	        String nim = input.nextLine();

	        Mahasiswa mhsDihapus = null;
	        for (Mahasiswa mhs : daftar) {
	            if (mhs.getNim().equals(nim)) {
	                mhsDihapus = mhs;
	                break;
	            }
	        }

	        if (mhsDihapus != null) {
	            daftar.remove(mhsDihapus);
	            System.out.println("Mahasiswa dengan NIM " + nim + " dihapus.");
	        } else {
	            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
	        }
	    }

	    public static void cariMahasiswa(ArrayList<Mahasiswa> daftar, Scanner input) {
	        System.out.print("Masukkan NIM Mahasiswa yang akan dicari: ");
	        String nim = input.nextLine();

	        for (Mahasiswa mhs : daftar) {
	            if (mhs.getNim().equals(nim)) {
	                System.out.println("Data Ditemukan:");
	                System.out.println("NIM: " + mhs.getNim() + ", Nama: " + mhs.getNama());
	                return;
	            }
	        }
	        System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
	    }
	    
	    public static void tampilkanDaftarMahasiswa(ArrayList<Mahasiswa> daftar) {
	        if (daftar.isEmpty()) {
	            System.out.println("Belum ada data mahasiswa.");
	        } else {
	            System.out.println("Daftar Mahasiswa:");
	            for (Mahasiswa mhs : daftar) {
	                System.out.println("NIM: " + mhs.getNim() + ", Nama: " + mhs.getNama());
	            }
	        }
	    }
	}