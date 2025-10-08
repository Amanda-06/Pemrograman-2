package PRAK201_2410817220022_AmandaArvaSafaraya;

public class Buah {
	String namaBuah;
    double berat;
    double harga;
    double jumlahBeli;
    
    public Buah(String namaBuah, double berat, double harga, double jumlahBeli) {
        this.namaBuah = namaBuah;
        this.berat = berat;
        this.harga = harga;
        this.jumlahBeli = jumlahBeli;
    }
	
	public double hargaSebelumDiskon() {
		return (this.jumlahBeli / this.berat) * this.harga;
	}
	double totalDiskon() {
		return Math.floor(this.jumlahBeli / 4) * (this.harga * 0.08);
	}
	public double hargaSetelahDiskon() {
		return this.hargaSebelumDiskon() - this.totalDiskon();
	}
	
	void tampilInfo() {
		System.out.println("Nama Buah: " + this.namaBuah);
		System.out.println("Berat: " + this.berat);
		System.out.println("Harga: " + this.harga);
        System.out.println("Jumlah Beli: " + this.jumlahBeli + " kg");
        System.out.printf("Harga Sebelum Diskon: Rp%.2f\n", this.hargaSebelumDiskon());
        System.out.printf("Total Diskon: Rp%.2f\n", this.totalDiskon());
        System.out.printf("Harga Setelah Diskon: Rp%.2f\n", this.hargaSetelahDiskon());
        System.out.println();
	}
}