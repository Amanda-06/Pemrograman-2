package dao;
import model.Pelanggan;
import java.util.List;

public interface PelangganDao {
    void addPelanggan(Pelanggan pelanggan) throws Exception;
    void editPelanggan(Pelanggan pelanggan) throws Exception;
    void deletePelanggan(int id) throws Exception;
    List<Pelanggan> findAllPelanggan() throws Exception;
	Pelanggan findPelangganByNama(String nama) throws Exception;
}