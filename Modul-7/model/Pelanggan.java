package model;
import javafx.beans.property.*;

public class Pelanggan {
    private int pelangganId;
    private final StringProperty nama;
    private final StringProperty email;
    private final StringProperty telepon;

    public Pelanggan(int id, String nama, String email, String telepon) {
        this.pelangganId = id;
        this.nama = new SimpleStringProperty(nama);
        this.email = new SimpleStringProperty(email);
        this.telepon = new SimpleStringProperty(telepon);
    }

    public Pelanggan(String nama, String email, String telepon) {
        this(0, nama, email, telepon);
    }

    public int getPelangganId() { 
    	return pelangganId; 
    }
    
    public void setPelangganId(int id) { 
    	this.pelangganId = id; 
    }
    
    public StringProperty namaProperty() { 
    	return nama; 
    }
    
    public String getNama() { 
    	return nama.get(); 
    }
    
    public StringProperty emailProperty() { 
    	return email; 
    }
    
    public String getEmail() { 
    	return email.get(); 
    }
    
    public StringProperty teleponProperty() { 
    	return telepon; 
    }
    
    public String getTelepon() { 
    	return telepon.get(); 
    }
}