package model;
import javafx.beans.property.*;

public class Buku {
    private int bukuId;
    private final StringProperty judul;
    private final StringProperty penulis;
    private final DoubleProperty harga;
    private final IntegerProperty stok;

    public Buku(int id, String judul, String penulis, double harga, int stok) {
        this.bukuId = id;
        this.judul = new SimpleStringProperty(judul);
        this.penulis = new SimpleStringProperty(penulis);
        this.harga = new SimpleDoubleProperty(harga);
        this.stok = new SimpleIntegerProperty(stok);
    }

    public Buku(String judul, String penulis, double harga, int stok) {
        this(0, judul, penulis, harga, stok);
    }

    public int getBukuId() { 
    	return bukuId; 	
    }
    
    public void setBukuId(int id) { 
    	this.bukuId = id; 
    }

    public StringProperty judulProperty() { 
    	return judul; 
    }
    
    public String getJudul() { 
    	return judul.get();
    }

    public StringProperty penulisProperty() { 
    	return penulis; 
    }
    
    public String getPenulis() { 
    	return penulis.get();
    }

    public DoubleProperty hargaProperty() { 
    	return harga; 
    }
    
    public double getHarga() { 
    	return harga.get(); 
    }

    public IntegerProperty stokProperty() { 
    	return stok; 
    }
    
    public int getStok() { 
    	return stok.get(); 
    }
    
    public void setStok(int stok) { 
    	this.stok.set(stok); 
    }
}