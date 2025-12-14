package service;
import dao.PelangganDao;
import dao.impl.PelangganDaoImpl;
import model.Pelanggan;
import java.util.List;

public class PelangganService {
    private final PelangganDao dao = new PelangganDaoImpl();

    public List<Pelanggan> getAllPelanggan() throws Exception { return dao.findAllPelanggan(); }

    public void addPelanggan(Pelanggan p) throws Exception {
        validasiData(p);
        dao.addPelanggan(p);
    }

    public void editPelanggan(Pelanggan p) throws Exception {
        if(p.getPelangganId() <= 0) throw new Exception("Gagal Edit : Data tidak ditemukan (ID Invalid)");
        validasiData(p);
        dao.editPelanggan(p);
    }

    public void deletePelanggan(int id) throws Exception {
        if(id <= 0) throw new Exception("Gagal Hapus : ID Invalid");
        dao.deletePelanggan(id);
    }

    private void validasiData(Pelanggan p) throws Exception {
        if (p.getNama().isEmpty()) throw new Exception("Nama belum diisi!");
        if (!p.getEmail().contains("@")) throw new Exception("Email belum benar!");
        if (!p.getTelepon().matches("\\d+")) throw new Exception("Nomor telepon belum benar!");
    }
}