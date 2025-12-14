package dao.impl;

import dao.BukuDao;
import model.Buku;
import util.DatabaseHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BukuDaoImpl implements BukuDao {
    @Override
    public void addBuku(Buku b) throws Exception {
        String sql = "INSERT INTO buku (judul, penulis, harga, stok) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, b.getJudul());
            ps.setString(2, b.getPenulis());
            ps.setDouble(3, b.getHarga());
            ps.setInt(4, b.getStok());
            ps.executeUpdate();
        }
    }

    @Override
    public void editBuku(Buku b) throws Exception {
        String sql = "UPDATE buku SET judul=?, penulis=?, harga=?, stok=? WHERE buku_id=?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, b.getJudul());
            ps.setString(2, b.getPenulis());
            ps.setDouble(3, b.getHarga());
            ps.setInt(4, b.getStok());
            ps.setInt(5, b.getBukuId());
            ps.executeUpdate();
        }
    }

    @Override
    public void deleteBuku(int id) throws Exception {
        String sql = "DELETE FROM buku WHERE buku_id=?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public List<Buku> findAllBuku() throws Exception {
        List<Buku> list = new ArrayList<>();
        String sql = "SELECT * FROM buku";
        try (Connection conn = DatabaseHelper.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Buku(rs.getInt("buku_id"), rs.getString("judul"), rs.getString("penulis"), rs.getDouble("harga"), rs.getInt("stok")));
            }
        }
        return list;
    }

    @Override
    public Buku findBukuById(int id) throws Exception {
        String sql = "SELECT * FROM buku WHERE buku_id=?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()) return new Buku(rs.getInt("buku_id"), rs.getString("judul"), rs.getString("penulis"), rs.getDouble("harga"), rs.getInt("stok"));
            }
        }
        return null;
    }
    
    @Override
    public Buku findBukuByJudul(String judul) throws Exception {
        String sql = "SELECT * FROM buku WHERE judul = ?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, judul);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Buku(rs.getInt("buku_id"), rs.getString("judul"), rs.getString("penulis"), rs.getDouble("harga"), rs.getInt("stok"));
                }
            }
        }
        return null;
    }

    @Override
    public void updateStok(int bukuId, int stokBaru) throws Exception {
        String sql = "UPDATE buku SET stok=? WHERE buku_id=?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, stokBaru);
            ps.setInt(2, bukuId);
            ps.executeUpdate();
        }
    }
}