package dao.impl;

import dao.PenjualanDao;
import model.Penjualan;
import util.DatabaseHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PenjualanDaoImpl implements PenjualanDao {

    @Override
    public void addPenjualan(Penjualan p) throws Exception {
        String sql = "INSERT INTO penjualan (jumlah, total_harga, tanggal, pelanggan_id, buku_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, p.getJumlah());
            ps.setDouble(2, p.getTotalHarga());
            ps.setString(3, p.getTanggal()); 
            ps.setInt(4, p.getPelangganId());
            ps.setInt(5, p.getBukuId());
            ps.executeUpdate();
        }
    }

    @Override
    public void editPenjualan(Penjualan p) throws Exception {
        String sql = "UPDATE penjualan SET jumlah=?, total_harga=?, tanggal=?, pelanggan_id=?, buku_id=? WHERE penjualan_id=?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, p.getJumlah());
            ps.setDouble(2, p.getTotalHarga());
            ps.setString(3, p.getTanggal());
            ps.setInt(4, p.getPelangganId());
            ps.setInt(5, p.getBukuId());
            ps.setInt(6, p.getPenjualanId());
            ps.executeUpdate();
        }
    }

    @Override
    public void deletePenjualan(int id) throws Exception {
        String sql = "DELETE FROM penjualan WHERE penjualan_id=?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public List<Penjualan> findAllPenjualan() throws Exception {
        List<Penjualan> list = new ArrayList<>();
        String sql = "SELECT p.*, pl.nama, b.judul " +
                     "FROM penjualan p " +
                     "JOIN pelanggan pl ON p.pelanggan_id = pl.pelanggan_id " +
                     "JOIN buku b ON p.buku_id = b.buku_id " +
                     "ORDER BY p.penjualan_id DESC";
                     
        try (Connection conn = DatabaseHelper.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Penjualan(
                    rs.getInt("penjualan_id"),
                    rs.getInt("jumlah"),
                    rs.getDouble("total_harga"),
                    rs.getString("tanggal"),
                    rs.getInt("pelanggan_id"),
                    rs.getInt("buku_id"),
                    rs.getString("nama"),  
                    rs.getString("judul")  
                ));
            }
        }
        return list;
    }

    @Override
    public Penjualan findPenjualanById(int id) throws Exception {
        String sql = "SELECT * FROM penjualan WHERE penjualan_id=?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Penjualan(rs.getInt("penjualan_id"), rs.getInt("jumlah"), rs.getDouble("total_harga"), rs.getString("tanggal"), rs.getInt("pelanggan_id"), rs.getInt("buku_id"));
                }
            }
        }
        return null;
    }
}