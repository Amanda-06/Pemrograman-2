package service;

import dao.BukuDao;
import dao.PelangganDao;
import dao.PenjualanDao;
import dao.impl.BukuDaoImpl;
import dao.impl.PelangganDaoImpl;
import dao.impl.PenjualanDaoImpl;
import model.Buku;
import model.Pelanggan;
import model.Penjualan;
import java.util.List;

public class PenjualanService {
    private final PenjualanDao penjualanDao = new PenjualanDaoImpl();
    private final BukuDao bukuDao = new BukuDaoImpl();
    private final PelangganDao pelangganDao = new PelangganDaoImpl();

    public List<Penjualan> getAllPenjualan() throws Exception {
        return penjualanDao.findAllPenjualan();
    }

    public void addPenjualan(String namaPelanggan, String judulBuku, String jumlahStr, String tanggal) throws Exception {
        int jumlah = validasiInputDasar(namaPelanggan, judulBuku, jumlahStr, tanggal);

        Pelanggan pelanggan = cekKeberadaanPelanggan(namaPelanggan);
        Buku buku = cekKeberadaanBuku(judulBuku);

        validasiStokCukup(buku, jumlah);

        double totalHarga = buku.getHarga() * jumlah;
        
        bukuDao.updateStok(buku.getBukuId(), buku.getStok() - jumlah);

        Penjualan penjualanBaru = new Penjualan(0, jumlah, totalHarga, tanggal, pelanggan.getPelangganId(), buku.getBukuId());
        penjualanDao.addPenjualan(penjualanBaru);
    }

    public void editPenjualan(int penjualanId, String namaPelanggan, String judulBuku, String jumlahStr, String tanggal) throws Exception {
        if (penjualanId <= 0) throw new Exception("Gagal Edit : Data tidak ditemukan (ID Invalid)");

        int jumlahBaru = validasiInputDasar(namaPelanggan, judulBuku, jumlahStr, tanggal);

        Penjualan pLama = penjualanDao.findPenjualanById(penjualanId);
        if (pLama == null) throw new Exception("Data transaksi tidak ditemukan");

        Pelanggan pelangganBaru = cekKeberadaanPelanggan(namaPelanggan);
        Buku bukuBaru = cekKeberadaanBuku(judulBuku);

        int stokTersedia = bukuBaru.getStok();
        if (pLama.getBukuId() == bukuBaru.getBukuId()) {
            stokTersedia += pLama.getJumlah();
        }

        if (stokTersedia < jumlahBaru) {
            throw new Exception("Stok buku '" + judulBuku + "' tidak mencukupi untuk update ini! (Tersedia: " + stokTersedia + ")");
        }

        Buku bukuLama = bukuDao.findBukuById(pLama.getBukuId());
        if (bukuLama != null) {
            bukuDao.updateStok(bukuLama.getBukuId(), bukuLama.getStok() + pLama.getJumlah());
        }
        
        bukuBaru = bukuDao.findBukuById(bukuBaru.getBukuId()); 
        bukuDao.updateStok(bukuBaru.getBukuId(), bukuBaru.getStok() - jumlahBaru);

        double totalBaru = bukuBaru.getHarga() * jumlahBaru;
        Penjualan pUpdate = new Penjualan(penjualanId, jumlahBaru, totalBaru, tanggal, pelangganBaru.getPelangganId(), bukuBaru.getBukuId());
        
        penjualanDao.editPenjualan(pUpdate);
    }

    public void deletePenjualan(Penjualan p) throws Exception {
        if (p == null) throw new Exception("Gagal Hapus : ID Invalid");

        Penjualan pDb = penjualanDao.findPenjualanById(p.getPenjualanId());
        if (pDb == null) throw new Exception("Data transaksi sudah tidak ada.");

        Buku buku = bukuDao.findBukuById(pDb.getBukuId());
        if (buku != null) {
            bukuDao.updateStok(buku.getBukuId(), buku.getStok() + pDb.getJumlah());
        }

        penjualanDao.deletePenjualan(p.getPenjualanId());
    }

    private int validasiInputDasar(String nama, String judul, String jumlahStr, String tanggal) throws Exception {
        if (nama == null || nama.trim().isEmpty()) throw new Exception("Nama Pelanggan wajib diisi!");
        if (judul == null || judul.trim().isEmpty()) throw new Exception("Judul Buku wajib diisi!");
        
        validasiFormatTanggal(tanggal);
        
        try {
            int jumlah = Integer.parseInt(jumlahStr);
            if (jumlah <= 0) throw new Exception("Jumlah beli harus lebih dari 0!");
            return jumlah;
        } catch (NumberFormatException e) {
            throw new Exception("Jumlah harus berupa angka bulat!");
        }
    }

    private void validasiFormatTanggal(String tanggal) throws Exception {
        if (tanggal == null || tanggal.trim().isEmpty()) {
            throw new Exception("Tanggal wajib diisi dengan format YYYY-MM-DD!");
        }
        
        if (!tanggal.matches("\\d{4}-\\d{2}-\\d{2}")) {
            throw new Exception("Format tanggal salah! Gunakan format: YYYY-MM-DD (Contoh: 2024-05-20)");
        }

        String[] parts = tanggal.split("-");
        int tahun = Integer.parseInt(parts[0]);
        int bulan = Integer.parseInt(parts[1]);
        int hari = Integer.parseInt(parts[2]);

        if (tahun <= 0 || tahun > 2025) {
            throw new Exception("Tahun tidak valid! Harus antara tahun 1 sampai 2025.");
        }

        if (bulan < 1 || bulan > 12) {
            throw new Exception("Bulan tidak valid! Harus antara 01 sampai 12.");
        }

        int maxHari = 31;
        if (bulan == 4 || bulan == 6 || bulan == 9 || bulan == 11) {
            maxHari = 30;
        } 
        else if (bulan == 2) {
            if ((tahun % 4 == 0 && tahun % 100 != 0) || (tahun % 400 == 0)) {
                maxHari = 29;
            } else {
                maxHari = 28;
            }
        }

        if (hari < 1 || hari > maxHari) {
            throw new Exception("Tanggal tidak valid! Bulan " + bulan + " tahun " + tahun + " hanya memiliki " + maxHari + " hari.");
        }
    }

    private Pelanggan cekKeberadaanPelanggan(String nama) throws Exception {
        Pelanggan p = pelangganDao.findPelangganByNama(nama);
        if (p == null) {
            throw new Exception("Pelanggan dengan nama '" + nama + "' tidak ditemukan!");
        }
        return p;
    }

    private Buku cekKeberadaanBuku(String judul) throws Exception {
        Buku b = bukuDao.findBukuByJudul(judul);
        if (b == null) {
            throw new Exception("Buku dengan judul '" + judul + "' tidak ditemukan!");
        }
        return b;
    }

    private void validasiStokCukup(Buku buku, int jumlahMinta) throws Exception {
        if (buku.getStok() < jumlahMinta) {
            throw new Exception("Stok buku '" + buku.getJudul() + "' tidak cukup! (Sisa: " + buku.getStok() + ")");
        }
    }
}