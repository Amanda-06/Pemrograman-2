package PRAK202_2410817220022_AmandaArvaSafaraya;

public class Kopi {
	public String namaKopi;
	public String ukuran;
	public double harga;
	private String pembeli;
	private double pajak = 0.11;
	
	public void setPembeli (String pembeli) {
		this.pembeli = pembeli;
	}
	
	public String getPembeli() {
		return pembeli;
	}
	
	public double getPajak() {
		return harga * pajak;
	}
	
	public void info() {
		System.out.println("Nama Kopi: " + namaKopi);
		System.out.println("Ukuran: " + ukuran);
		System.out.println("Harga: Rp. " + harga);
	}
}