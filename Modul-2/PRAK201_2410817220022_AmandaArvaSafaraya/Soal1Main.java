package PRAK201_2410817220022_AmandaArvaSafaraya;

public class Soal1Main {

	public static void main(String[] args) {
		Buah apel = new Buah("Apel", 0.4, 7000, 40.0);
        Buah mangga = new Buah("Mangga", 0.2, 3500, 15.0);
        Buah alpukat = new Buah("Alpukat", 0.25, 10000, 12.0);

        apel.tampilInfo();
        mangga.tampilInfo();
        alpukat.tampilInfo();
	}
}