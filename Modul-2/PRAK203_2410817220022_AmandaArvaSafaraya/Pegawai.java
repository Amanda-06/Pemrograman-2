package PRAK203_2410817220022_AmandaArvaSafaraya;

//Pada baris ini terjadi error karena nama classnya tidak sesuai dengan nama file classnya
//public class Employee {
public class Pegawai {
	public String nama;
	//Pada baris ini terjadi error karena tipe data variabel asal salah yang seharusnya tipe datanya String
	//public char asal;
	public String asal;
	public String jabatan;
	public int umur;
	
	public String getNama() {
		return nama;
	}
	public String getAsal() {
		return asal;
	}
	
	//Pada baris ini terjadi error karena tidak ada parameter pada metode setJabatan
	//public void setJabatan() {
	public void setJabatan(String j) {
		this.jabatan = j;
	}
}