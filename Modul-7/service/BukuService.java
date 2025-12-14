package service;

import dao.BukuDao;
import dao.impl.BukuDaoImpl;
import model.Buku;
import java.util.List;

public class BukuService {
    private final BukuDao dao = new BukuDaoImpl();

    public List<Buku> getAllBuku() throws Exception {
        return dao.findAllBuku();
    }

    public void addBuku(String judul, String penulis, String hargaStr, String stokStr) throws Exception {
        Buku b = validasiDanBuatObjek(0, judul, penulis, hargaStr, stokStr);
        dao.addBuku(b);
    }

    public void editBuku(int id, String judul, String penulis, String hargaStr, String stokStr) throws Exception {
        if(id <= 0) throw new Exception("Gagal Edit : Data tidak ditemukan (Data Invalid)");
        Buku b = validasiDanBuatObjek(id, judul, penulis, hargaStr, stokStr);
        dao.editBuku(b);
    }

    public void deleteBuku(int id) throws Exception {
        if(id <= 0) throw new Exception("Gagal Hapus : ID Invalid.");
        dao.deleteBuku(id);
    }

    private Buku validasiDanBuatObjek(int id, String judul, String penulis, String hargaStr, String stokStr) throws Exception {
        if (judul == null || judul.trim().isEmpty()) throw new Exception("Judul buku wajib diisi!");
        if (penulis == null || penulis.trim().isEmpty()) throw new Exception("Penulis buku wajib diisi!");
        if (hargaStr == null || hargaStr.trim().isEmpty()) throw new Exception("Harga wajib diisi!");
        if (stokStr == null || stokStr.trim().isEmpty()) throw new Exception("Stok wajib diisi!");

        double harga;
        int stok;
        try {
            harga = Double.parseDouble(hargaStr);
        } catch (NumberFormatException e) {
            throw new Exception("Harga harus berupa angka yang valid!");
        }

        try {
            stok = Integer.parseInt(stokStr);
        } catch (NumberFormatException e) {
            throw new Exception("Stok harus berupa angka bulat yang valid!");
        }

        if (harga <= 0) throw new Exception("Harga harus lebih dari 0!");
        if (stok < 0) throw new Exception("Stok tidak boleh negatif!");

        if (id == 0) {
            return new Buku(judul, penulis, harga, stok);
        } else {
            return new Buku(id, judul, penulis, harga, stok);
        }
    }
}