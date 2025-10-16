package Modul3.soal2;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.List;

public class Main {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        HashMap<Integer, String> petaBulan = new HashMap<>();
        petaBulan.put(1, "Januari"); petaBulan.put(2, "Februari"); petaBulan.put(3, "Maret");
        petaBulan.put(4, "April"); petaBulan.put(5, "Mei"); petaBulan.put(6, "Juni");
        petaBulan.put(7, "Juli"); petaBulan.put(8, "Agustus"); petaBulan.put(9, "September");
        petaBulan.put(10, "Oktober"); petaBulan.put(11, "November"); petaBulan.put(12, "Desember");

        List<Negara> daftarNegara = new LinkedList<>();
        int jumlahNegara = Integer.parseInt(input.nextLine());

        for (int i = 0; i < jumlahNegara; i++) {
            String nama = input.nextLine();
            String jenis = input.nextLine();
            String pemimpin = input.nextLine();

            if (jenis.equalsIgnoreCase("monarki")) {
                daftarNegara.add(new Negara(nama, jenis, pemimpin));
            } else {
                while (true) {
                    int tanggal = Integer.parseInt(input.nextLine());
                    int bulan = Integer.parseInt(input.nextLine());
                    int tahun = Integer.parseInt(input.nextLine());
                    
                    if (validasiSemua(tanggal, bulan, tahun)) {
                        daftarNegara.add(new Negara(nama, jenis, pemimpin, tanggal, bulan, tahun));
                        break; 
                    } else {
                        System.out.println("Tanggal tidak valid, silakan masukkan ulang data kemerdekaan.");
                    }
                }
            }
        }

        System.out.println();
        for (int i = 0; i < daftarNegara.size(); i++) {
            daftarNegara.get(i).displayInfo(petaBulan);
            if (i < daftarNegara.size() - 1) {
                System.out.println();
            }
        }
        input.close();
    }

    private static boolean validasiSemua(int tanggal, int bulan, int tahun) {
        if (tahun <= 0 || tahun > 2025) {
            System.out.println("Error: Tahun harus lebih dari 0 dan tidak lebih dari 2025.");
            return false;
        }
        
        if (bulan < 1 || bulan > 12) {
            System.out.println("Error: Bulan harus antara 1 sampai 12.");
            return false;
        }

        int maksTanggal;
        if (bulan == 2) { 
            boolean isKabisat = (tahun % 4 == 0 && tahun % 100 != 0) || (tahun % 400 == 0);
            maksTanggal = isKabisat ? 29 : 28;
        } else if (bulan == 4 || bulan == 6 || bulan == 9 || bulan == 11) {
            maksTanggal = 30;
        } else {
            maksTanggal = 31;
        }

        if (tanggal < 1 || tanggal > maksTanggal) {
            System.out.println("Error: Untuk bulan dan tahun tersebut, tanggal harus antara 1 sampai " + maksTanggal + ".");
            return false;
        }
        return true;
    }
}