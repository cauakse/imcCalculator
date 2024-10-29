package com.example.imccalculatorfx;

import com.example.imccalculatorfx.entity.Pessoa;
import com.example.imccalculatorfx.util.Singleton;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class TableController implements Initializable {
    public TableColumn <Pessoa,String>colNome;
    public TableView <Pessoa>tabela;
    public TableColumn <Pessoa,Integer>colPeso;
    public TableColumn <Pessoa,Double>colAltura;
    public TableColumn <Pessoa,Double>colIMC;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        colAltura.setCellValueFactory(new PropertyValueFactory<>("altura"));
        colIMC.setCellValueFactory(new PropertyValueFactory<>("imc"));
        tabela.setItems(FXCollections.observableArrayList(Singleton.getRepositorio().getList()));
    }
}
