package PRAK203_2410817220022_AmandaArvaSafaraya;

public class Soal3Main {
	public static void main(String[] args) {
		Pegawai p1 = new Pegawai();
		//Pada baris ini terjadi error karena kurangnya titik koma(;)
		//p1.nama = "Roi"
		p1.nama = "Roi";
		p1.asal = "Kingdom of Orvel";
		//Tidak ada ditambahkan atribut umur yang sudah dideklarasikan di kelas Pegawai
		p1.umur = 17;
		p1.setJabatan("Assasin");
		// Pada baris ini terdapat kesalahan karena tidak sesuai output (tidak ada kata Pegawai)
		//System.out.println("Nama Pegawai: " + p1.getNama());
		System.out.println("Nama: " + p1.getNama());
		System.out.println("Asal: " + p1.getAsal());
		System.out.println("Jabatan: " + p1.jabatan);
		//Pada baris ini kekurangan keterangan Tahun di belakang umur
		//System.out.println("Umur: " + p1.umur);
		System.out.println("Umur: " + p1.umur + " Tahun");
	}
}