package Modul4.soal1;

public class HewanPeliharaan {
	private String nama;
	private String ras;

    public HewanPeliharaan(String nama, String ras) {
        setNama(nama);
        setRas(ras);
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
		System.out.println("Detail Hewan Peliharaan:");
		System.out.println("Nama hewan peliharaanku adalah : " + getNama());
		System.out.println("Dengan ras: " + getRas());
	}
}