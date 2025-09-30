package PRAKTIKUM_1;
import java.util.Scanner;
public class PRAK102_2410817220022_AmandaArvaSafaraya {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("");
        int angkaAwal = input.nextInt();
        input.close();

        int i = 0;
        while (i <= 10) {
            int bilangan = angkaAwal + i;
            if (bilangan % 5 == 0) {
                System.out.print((bilangan / 5) - 1);
            } else {
                System.out.print(bilangan);
            }

            if (i < 10) {
                System.out.print(", ");
            }
            i++;
        }
        System.out.println(); 
    }
}