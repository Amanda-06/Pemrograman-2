package Modul3.soal1;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int jumlahAcakDadu = input.nextInt();

        while (jumlahAcakDadu < 1 || jumlahAcakDadu > 6) {
            System.out.println("Input tidak valid!\nMasukkan jumlah dadu kembali (1-6): ");
            jumlahAcakDadu = input.nextInt();
        }

        List<Dadu> semuaDadu = new LinkedList<>();
        for (int i = 0; i < jumlahAcakDadu; i++) {
            semuaDadu.add(new Dadu());
        }

        int totalNilaiKeseluruhan = 0;
        for (int i = 0; i < semuaDadu.size(); i++) {
            Dadu dadu = semuaDadu.get(i);
            int nilaiDadu = dadu.getNilai();
            System.out.println("Dadu ke-" + (i + 1) + " bernilai " + nilaiDadu);
            totalNilaiKeseluruhan += nilaiDadu;
        }

        System.out.println("Total nilai dadu keseluruhan " + totalNilaiKeseluruhan);
        input.close();
    }
}