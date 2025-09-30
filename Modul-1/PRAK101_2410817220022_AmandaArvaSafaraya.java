package PRAKTIKUM_1;

import java.util.Scanner;

public class PRAK101_2410817220022_AMANDAARVASAFARAYA {

	public static void main(String[] args) {
		String namaLengkap, tempatLahir;
	    int tanggalLahir, bulanLahir, tahunLahir, tinggiBadan;
	    double beratBadan;

	    Scanner input = new Scanner(System.in);

	    System.out.print("Masukkan Nama Lengkap: ");
	    namaLengkap = input.nextLine();
	    System.out.print("Masukkan Tempat Lahir: ");
	    tempatLahir = input.nextLine();

	    do {
	        System.out.print("Masukkan Tanggal Lahir: ");
	        tanggalLahir = input.nextInt();
	        if (tanggalLahir <= 0) {
	            System.out.println("Tanggal tidak boleh nol atau negatif. Silakan coba lagi.");
	        }
	    } while (tanggalLahir <= 0);

	    do {
	        System.out.print("Masukkan Bulan Lahir: ");
	        bulanLahir = input.nextInt();
	        if (bulanLahir <= 0 || bulanLahir > 12) {
	            System.out.println("Bulan harus antara 1 dan 12. Silakan coba lagi.");
	        }
	    } while (bulanLahir <= 0 || bulanLahir > 12);

        do {
	        System.out.print("Masukkan Tahun Lahir: ");
	        tahunLahir = input.nextInt();
	        if (tahunLahir <= 0) {
	            System.out.println("Tahun tidak boleh nol atau negatif. Silakan coba lagi.");
	        }
        } while (tahunLahir <= 0);

        do {
            System.out.print("Masukkan Tinggi Badan: ");
            tinggiBadan = input.nextInt();	            if (tinggiBadan <= 0) {
                System.out.println("Tinggi badan tidak boleh nol atau negatif. Silakan coba lagi.");
            }
        } while (tinggiBadan <= 0);

        do {
            System.out.print("Masukkan Berat Badan: ");
            beratBadan = input.nextDouble();
            if (beratBadan <= 0) {
                System.out.println("Berat badan tidak boleh nol atau negatif. Silakan coba lagi.");
            }
        } while (beratBadan <= 0);
	        input.close();

        String[] namaBulanArray = {
            "", "Januari", "Februari", "Maret", "April", "Mei", "Juni",
            "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        };
        String namaBulan = namaBulanArray[bulanLahir];

        System.out.println("Nama Lengkap " + namaLengkap + ", Lahir di " + tempatLahir + " pada Tanggal " + tanggalLahir + " " + namaBulan + " " + tahunLahir);
        System.out.println("Tinggi Badan " + tinggiBadan + " cm dan Berat Badan " + beratBadan + " kilogram");
    }
}