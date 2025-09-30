package PRAKTIKUM_1;
import java.util.Scanner;
public class PRAK104_2410817220022_AmandaArvaSafaraya {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

        System.out.print("Tangan Abu: ");
        String[] tanganAbu = input.nextLine().split(" ");

        System.out.print("Tangan Bagas: ");
        String[] tanganBagas = input.nextLine().split(" ");

        input.close();

        int skorAbu = 0;
        int skorBagas = 0;

        for (int i = 0; i < 3; i++) {
            String abu = tanganAbu[i];
            String bagas = tanganBagas[i];

            if ((abu.equals("B") && bagas.equals("G")) ||
                (abu.equals("G") && bagas.equals("K")) ||
                (abu.equals("K") && bagas.equals("B"))) {
                skorAbu++;
            } 
            else if ((bagas.equals("B") && abu.equals("G")) ||
                     (bagas.equals("G") && abu.equals("K")) ||
                     (bagas.equals("K") && abu.equals("B"))) {
                skorBagas++;
            }
        }

        if (skorAbu > skorBagas) {
            System.out.println("Abu");
        } else if (skorBagas > skorAbu) {
            System.out.println("Bagas");
        } else {
            System.out.println("Seri");
        }
	}
}