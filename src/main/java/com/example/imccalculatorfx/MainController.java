package com.example.imccalculatorfx;

import com.example.imccalculatorfx.entity.Pessoa;
import com.example.imccalculatorfx.util.IMC;
import com.example.imccalculatorfx.util.Singleton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainController {

    public TextField tfName;
    public Slider slPeso;
    public Label lbPeso;
    public Slider slAltura;
    public Label lbAltura;
    public Label lbIMC;
    public Label lbCond;

    private void valoresIniciais() {
        tfName.setText("");
        slAltura.setValue(160);
        slPeso.setValue(60);
        lbAltura.setText("1.6");
    }

    public void onSalvarHistorico(ActionEvent actionEvent) {
        if (!tfName.getText().isEmpty()) {
            Pessoa pessoa = new Pessoa(tfName.getText(),
                    (int) slPeso.getValue(),
                    slAltura.getValue() / 100, Double.parseDouble(lbIMC.getText().replace(",", ".")));
            Singleton.getRepositorio().add(pessoa);
            //salvar via serialização
            valoresIniciais();
            calcIMC();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Informe seu nome");
            alert.showAndWait();
            Platform.runLater(() -> {
                tfName.requestFocus();
            });

        }
    }

    public void onPesoMouseClicked(MouseEvent mouseEvent) {
        lbPeso.setText(String.format("%.0f", slPeso.getValue()));
        calcIMC();
    }

    public void onAlturaMouseClicked(MouseEvent mouseEvent) {
        lbAltura.setText(String.format("%.2f", slAltura.getValue() / 100));
        calcIMC();
    }

    public void onAlturaMouseDragged(MouseEvent mouseEvent) {
        lbAltura.setText(String.format("%.2f", slAltura.getValue() / 100));
        calcIMC();
    }

    public void onPesoMouseDragged(MouseEvent mouseEvent) {
        lbPeso.setText(String.format("%.0f", slPeso.getValue()));
        calcIMC();
    }

    private void calcIMC() {
        int peso = (int) slPeso.getValue();
        double altura = slAltura.getValue() / 100;
        lbIMC.setText(String.format("%.1f", IMC.get(peso, altura)));
        lbCond.setText(IMC.getCondicao(IMC.get(peso, altura)));
    }

    public void onNovoIMC(ActionEvent actionEvent) {
    }

    public void onMostrarHistorico(ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(IMCCalculator.class.getResource("table-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Histórico");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }
}
