package Modul3.soal1;
import java.util.Random;
public class Dadu {
	private int nilai;

    public Dadu() {
        acakNilai();
    }
    
    public void acakNilai() {
        this.nilai = new Random().nextInt(6) + 1;
    }

    public int getNilai() {
        return this.nilai;
    }
}