package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable; 
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle; 

import Model.Mahasiswa;

public class Controller implements Initializable {

    @FXML
    private TableView<Mahasiswa> table;

    @FXML
    private TableColumn<Mahasiswa, String> nimColumn;

    @FXML
    private TableColumn<Mahasiswa, String> namaColumn;

    private ObservableList<Mahasiswa> model;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        model = FXCollections.observableArrayList();
        nimColumn.setCellValueFactory(new PropertyValueFactory<>("nim"));
        namaColumn.setCellValueFactory(new PropertyValueFactory<>("nama"));
        table.setItems(model);
        loadData();
    }

    private void loadData() {
        model.add(new Mahasiswa("123", "Ino"));
        model.add(new Mahasiswa("124", "Greci"));
        model.add(new Mahasiswa("125", "Cici"));
        model.add(new Mahasiswa("126", "Jamal"));
        model.add(new Mahasiswa("127", "Kidi"));
        model.add(new Mahasiswa("128", "Mboja"));
        model.add(new Mahasiswa("129", "Ma'wo"));
        model.add(new Mahasiswa("130", "Ma'e"));
        model.add(new Mahasiswa("131", "Riri"));
        model.add(new Mahasiswa("132", "Tatto"));
    }
}