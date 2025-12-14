package dao;
import model.Penjualan;
import java.util.List;

public interface PenjualanDao {
    void addPenjualan(Penjualan penjualan) throws Exception;
    void editPenjualan(Penjualan penjualan) throws Exception;
    void deletePenjualan(int id) throws Exception;
    List<Penjualan> findAllPenjualan() throws Exception;
    Penjualan findPenjualanById(int id) throws Exception;
}