package dao;
import model.Buku;
import java.util.List;

public interface BukuDao {
    void addBuku(Buku buku) throws Exception;
    void editBuku(Buku buku) throws Exception;
    void deleteBuku(int id) throws Exception;
    List<Buku> findAllBuku() throws Exception;
    Buku findBukuById(int id) throws Exception;
    Buku findBukuByJudul(String judul) throws Exception;
    void updateStok(int bukuId, int stokBaru) throws Exception;
}