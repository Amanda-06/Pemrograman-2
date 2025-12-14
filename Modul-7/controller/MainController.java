package controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;
import service.*;

public class MainController {

    // TAB PELANGGAN
    @FXML private TextField txtNama, txtEmail, txtTelepon;
    @FXML private TableView<Pelanggan> tblPelanggan;
    @FXML private TableColumn<Pelanggan, String> colNama, colEmail, colTelepon;
    
    // TAB BUKU
    @FXML private TextField txtJudul, txtPenulis, txtHarga, txtStok;
    @FXML private TableView<Buku> tblBuku;
    @FXML private TableColumn<Buku, String> colJudul, colPenulis;
    @FXML private TableColumn<Buku, Number> colHarga, colStok;

    // TAB PENJUALAN
    @FXML private TextField txtJualNamaPelanggan, txtJualJudulBuku, txtJualJumlah, txtJualTanggal;
    @FXML private TableView<Penjualan> tblPenjualan;
    @FXML private TableColumn<Penjualan, Number> colJualJumlah, colJualTotal;
    @FXML private TableColumn<Penjualan, String> colJualPelanggan, colJualBuku, colJualTanggal;

    private final PelangganService ps = new PelangganService();
    private final BukuService bs = new BukuService();
    private final PenjualanService js = new PenjualanService();

    private int selectedPelangganId = 0;
    private int selectedBukuId = 0;

    @FXML
    public void initialize() {
        setupTables();
        setupListeners();
        loadData();
    }

    private void setupTables() {
        // Pelanggan
        colNama.setCellValueFactory(c -> c.getValue().namaProperty());
        colEmail.setCellValueFactory(c -> c.getValue().emailProperty());
        colTelepon.setCellValueFactory(c -> c.getValue().teleponProperty());

        // Buku
        colJudul.setCellValueFactory(c -> c.getValue().judulProperty());
        colPenulis.setCellValueFactory(c -> c.getValue().penulisProperty());
        colHarga.setCellValueFactory(c -> c.getValue().hargaProperty());
        colStok.setCellValueFactory(c -> c.getValue().stokProperty());

        // Penjualan
        colJualPelanggan.setCellValueFactory(c -> c.getValue().namaPelangganProperty()); // Nama
        colJualBuku.setCellValueFactory(c -> c.getValue().judulBukuProperty());         // Judul
        colJualJumlah.setCellValueFactory(c -> c.getValue().jumlahProperty());
        colJualTotal.setCellValueFactory(c -> c.getValue().totalHargaProperty());
        colJualTanggal.setCellValueFactory(c -> c.getValue().tanggalProperty());
    }

    private void setupListeners() {
        // Listener Pelanggan
        tblPelanggan.getSelectionModel().selectedItemProperty().addListener((o, oldVal, newVal) -> {
            if (newVal != null) {
                selectedPelangganId = newVal.getPelangganId();
                txtNama.setText(newVal.getNama());
                txtEmail.setText(newVal.getEmail());
                txtTelepon.setText(newVal.getTelepon());
            }
        });

        // Listener Buku
        tblBuku.getSelectionModel().selectedItemProperty().addListener((o, oldVal, newVal) -> {
            if (newVal != null) {
                selectedBukuId = newVal.getBukuId();
                txtJudul.setText(newVal.getJudul());
                txtPenulis.setText(newVal.getPenulis());
                txtHarga.setText(String.valueOf(newVal.getHarga()));
                txtStok.setText(String.valueOf(newVal.getStok()));
            }
        });

        // Listener Penjualan 
        tblPenjualan.getSelectionModel().selectedItemProperty().addListener((o, oldVal, newVal) -> {
            if (newVal != null) {
                txtJualNamaPelanggan.setText(newVal.getNamaPelanggan());
                txtJualJudulBuku.setText(newVal.getJudulBuku());
                txtJualJumlah.setText(String.valueOf(newVal.getJumlah()));
                txtJualTanggal.setText(newVal.getTanggal());
            }
        });
    }

    private void loadData() {
        try {
            tblPelanggan.setItems(FXCollections.observableArrayList(ps.getAllPelanggan()));
            tblBuku.setItems(FXCollections.observableArrayList(bs.getAllBuku()));
            tblPenjualan.setItems(FXCollections.observableArrayList(js.getAllPenjualan()));
        } catch (Exception e) { showAlert(Alert.AlertType.ERROR, "Error Load", e.getMessage()); }
    }

    // HANDLERS PELANGGAN 
    @FXML void onAddPelanggan() {
        try { 
        	ps.addPelanggan(new Pelanggan(
        			txtNama.getText(), 
        			txtEmail.getText(), 
        			txtTelepon.getText())); 
        	onSuccess("Pelanggan Ditambah"); 
        } catch(Exception e){showAlert(Alert.AlertType.ERROR,"Error",e.getMessage());}
    }
    
    @FXML void onEditPelanggan() {
        try { 
        	ps.editPelanggan(new Pelanggan(
        			selectedPelangganId, 
        			txtNama.getText(), 
        			txtEmail.getText(), 
        			txtTelepon.getText())); 
        	onSuccess("Pelanggan Diedit"); 
        } catch(Exception e){showAlert(Alert.AlertType.ERROR,"Error",e.getMessage());}
    }
    
    @FXML void onDeletePelanggan() { 
    	try { 
    		ps.deletePelanggan(selectedPelangganId); 
    		onSuccess("Pelanggan Dihapus"); 
    	} catch(Exception e){showAlert(Alert.AlertType.ERROR,"Error",e.getMessage());} }

    // HANDLERS BUKU
    @FXML void onAddBuku() {
        try { 
        	bs.addBuku(
        			txtJudul.getText(), 
        			txtPenulis.getText(), 
        			txtHarga.getText(), 
        			txtStok.getText()); 
        	onSuccess("Buku Ditambah"); 
        } catch(Exception e){showAlert(Alert.AlertType.ERROR,"Error",e.getMessage());}
    }
    
    @FXML void onEditBuku() {
        try { 
        	bs.editBuku(
        			selectedBukuId, 
        			txtJudul.getText(), 
        			txtPenulis.getText(), 
        			txtHarga.getText(), 
        			txtStok.getText()); 
        	onSuccess("Buku Diedit"); 
        } catch(Exception e){showAlert(Alert.AlertType.ERROR,"Error",e.getMessage());}
    }
    
    @FXML void onDeleteBuku() { 
    	try { bs.deleteBuku(selectedBukuId); 
    	onSuccess("Buku Dihapus"); 
    	} catch(Exception e){showAlert(Alert.AlertType.ERROR,"Error",e.getMessage());} }

    // HANDLERS PENJUALAN
    @FXML 
    void onAddPenjualan() {
        try {
            js.addPenjualan(
                txtJualNamaPelanggan.getText(),
                txtJualJudulBuku.getText(),
                txtJualJumlah.getText(),
                txtJualTanggal.getText()
            );
            onSuccess("Data Penjualan Ditambah");
        } catch (Exception e) { showAlert(Alert.AlertType.ERROR, "Gagal", e.getMessage()); }
    }

    @FXML 
    void onEditPenjualan() {
        try {
            Penjualan sel = tblPenjualan.getSelectionModel().getSelectedItem();
            if(sel == null) throw new Exception("Gagal Edit : Data tidak ditemukan (ID Invalid)");
            
            js.editPenjualan(
                sel.getPenjualanId(),
                txtJualNamaPelanggan.getText(),
                txtJualJudulBuku.getText(),
                txtJualJumlah.getText(),
                txtJualTanggal.getText()
            );
            onSuccess("Data Penjualan Diedit");
        } catch (Exception e) { showAlert(Alert.AlertType.ERROR, "Gagal", e.getMessage()); }
    }

    @FXML 
    void onDeletePenjualan() {
        try {
            Penjualan sel = tblPenjualan.getSelectionModel().getSelectedItem();
            js.deletePenjualan(sel);
            onSuccess("Data Penjualan Dihapus");
        } catch (Exception e) { showAlert(Alert.AlertType.ERROR, "Gagal", e.getMessage()); }
    }

    private void onSuccess(String msg) {
        showAlert(Alert.AlertType.INFORMATION, "Sukses", msg);
        clearForms();
        loadData();
    }
    
    private void clearForms() {
        txtNama.clear(); txtEmail.clear(); txtTelepon.clear(); selectedPelangganId=0;
        txtJudul.clear(); txtPenulis.clear(); txtHarga.clear(); txtStok.clear(); selectedBukuId=0;
        txtJualNamaPelanggan.clear(); txtJualJudulBuku.clear(); txtJualJumlah.clear(); txtJualTanggal.clear();
    }

    private void showAlert(Alert.AlertType type, String title, String msg) {
        Alert a = new Alert(type); a.setTitle(title); a.setContentText(msg); a.show();
    }
}