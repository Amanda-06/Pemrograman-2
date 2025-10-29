package Modul4.soal2;

public class HewanPeliharaan {
	private String nama;
	private String ras;

    public HewanPeliharaan(String r, String n) {
        setNama(n);
        setRas(r);
    }
    
	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getRas() {
		return ras;
	}

	public void setRas(String ras) {
		this.ras = ras;
	}

	public void display(){
		System.out.println("\nDetail Hewan Peliharaan:");
		System.out.println("Nama hewan peliharaanku adalah : " + getNama());
		System.out.println("Dengan ras: " + getRas());
	}
}