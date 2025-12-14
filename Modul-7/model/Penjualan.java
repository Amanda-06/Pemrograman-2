package model;

import javafx.beans.property.*;

public class Penjualan {
    private int penjualanId;
    private final IntegerProperty jumlah;
    private final DoubleProperty totalHarga;
    private final StringProperty tanggal;
    private final IntegerProperty pelangganId;
    private final IntegerProperty bukuId;
    private final StringProperty namaPelanggan;
    private final StringProperty judulBuku;

    public Penjualan(int id, int jumlah, double totalHarga, String tanggal, int pId, int bId, String namaPelanggan, String judulBuku) {
        this.penjualanId = id;
        this.jumlah = new SimpleIntegerProperty(jumlah);
        this.totalHarga = new SimpleDoubleProperty(totalHarga);
        this.tanggal = new SimpleStringProperty(tanggal);
        this.pelangganId = new SimpleIntegerProperty(pId);
        this.bukuId = new SimpleIntegerProperty(bId);
        this.namaPelanggan = new SimpleStringProperty(namaPelanggan);
        this.judulBuku = new SimpleStringProperty(judulBuku);
    }
    
    public Penjualan(int id, int jumlah, double totalHarga, String tanggal, int pId, int bId) {
        this(id, jumlah, totalHarga, tanggal, pId, bId, "", "");
    }

    public int getPenjualanId() { 
    	return penjualanId; 
    }
    
    public IntegerProperty jumlahProperty() { 
    	return jumlah; 
    }
    
    public int getJumlah() { 
    	return jumlah.get(); 
    }
    
    public DoubleProperty totalHargaProperty() { 
    	return totalHarga; 
    }
    
    public double getTotalHarga() { 
    	return totalHarga.get(); 
    }
    
    public void setTotalHarga(double total) { 
    	this.totalHarga.set(total); 
    }
    
    public StringProperty tanggalProperty() { 
    	return tanggal; 
    }
    
    public String getTanggal() { 
    	return tanggal.get(); 
    }
    
    public IntegerProperty pelangganIdProperty() { 
    	return pelangganId; 
    }
    public int getPelangganId() { 
    	return pelangganId.get(); 
    }
    
    public IntegerProperty bukuIdProperty() { 
    	return bukuId; 
    }
    
    public int getBukuId() { 
    	return bukuId.get(); 
    }

    public StringProperty namaPelangganProperty() { 
    	return namaPelanggan; 
    }
    
    public String getNamaPelanggan() { 
    	return namaPelanggan.get(); 
    }
    
    public StringProperty judulBukuProperty() { 
    	return judulBuku; 
    }
    
    public String getJudulBuku() { 
    	return judulBuku.get(); 
    }
}