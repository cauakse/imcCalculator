package com.example.imccalculatorfx;

import com.example.imccalculatorfx.util.Singleton;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import javax.swing.*;
import java.io.IOException;

public class IMCCalculator extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(IMCCalculator.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("IMCCalculator v 1.0.1!");
        stage.setScene(scene);
        stage.show();


        if(!Singleton.read()){
            JOptionPane.showMessageDialog(null,"Erro na leitura do arquivo");
        }

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                Singleton.save();
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}