package PRAKTIKUM_1;
import java.util.Scanner;
public class PRAK105_2410817220022_AmandaArvaSafaraya {

	private static final double PHI = 3.14;

	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jari-jari: ");
        double jariJari = input.nextDouble();

        System.out.print("Masukkan tinggi: ");
        double tinggi = input.nextDouble();

        input.close();

        double volume = PHI * jariJari * jariJari * tinggi;

        System.out.printf("Volume tabung dengan jari-jari %.1f cm dan tinggi %.1f cm adalah %.3f m3\n", jariJari, tinggi, volume);
	}
}