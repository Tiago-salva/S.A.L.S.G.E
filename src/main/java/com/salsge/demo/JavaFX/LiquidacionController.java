package com.salsge.demo.JavaFX;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class LiquidacionController implements Initializable {

    @FXML private GridPane gridPane;

    public LiquidacionController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Fila 0
        gridPane.add(new Label("110000"), 0, 0);
        gridPane.add(new Label("Sueldo Básico"), 1, 0);
        gridPane.add(new Label("$ 564.155,63"), 4, 0);

        // Fila 1
        gridPane.add(new Label("111000"), 0, 1);
        gridPane.add(new Label("Ausencia Injustificada"), 1, 1);
        gridPane.add(new Label("10"), 2, 1);
        gridPane.add(new Label("-$ 188.051,88"),4, 1);
    }



}
