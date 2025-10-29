package Modul4.soal2;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

        System.out.println("Pilih jenis hewan yang ingin diinputkan:");
        System.out.println("1 = Kucing");
        System.out.println("2 = Anjing");
        System.out.print("Masukkan pilihan: ");
        int pilihan = input.nextInt();
        input.nextLine(); 

        if (pilihan == 1) {
            System.out.print("\nNama hewan peliharaan: ");
            String n = input.nextLine();
            System.out.print("Ras: ");
            String r = input.nextLine();
            System.out.print("Warna Bulu: ");
            String w = input.nextLine();
            
            Kucing kucing = new Kucing(n, r, w);
            kucing.displayDetailKucing();

        } else if (pilihan == 2) {
            System.out.print("\nNama hewan peliharaan: ");
            String n = input.nextLine();
            System.out.print("Ras: ");
            String r = input.nextLine();
            System.out.print("Warna Bulu: ");
            String w = input.nextLine();
            System.out.print("Kemampuan : ");
            String[] k = input.nextLine().split("[,]");

            Anjing anjing = new Anjing(n, r, w, k);
            anjing.displayDetailAnjing();
            
        } else {
            System.out.println("Pilihan tidak valid.");
        }
        input.close();
    }
}