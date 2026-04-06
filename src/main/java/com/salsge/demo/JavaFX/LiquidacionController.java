package com.salsge.demo.JavaFX;

import com.salsge.demo.Legajo.Legajo;
import com.salsge.demo.Legajo.LegajoRepository;
import com.salsge.demo.Legajo.LegajoService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

@Component
public class LiquidacionController implements Initializable {

    @Autowired
    private LegajoService legajoService;
    @Autowired
    private LegajoRepository legajoRepository;

    @FXML private AnchorPane anchorPane;
    @FXML private TextField numeroDeLegajoField;

    public LiquidacionController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        System.out.println(numeroDeLegajoField);

//        // Fila 0
//        gridPane.add(new Label("110000"), 0, 0);
//        gridPane.add(new Label("Sueldo Básico"), 1, 0);
//        gridPane.add(new Label("$ 564.155,63"), 4, 0);
//
//        // Fila 1
//        gridPane.add(new Label("111000"), 0, 1);
//        gridPane.add(new Label("Ausencia Injustificada"), 1, 1);
//        gridPane.add(new Label("10"), 2, 1);
//        gridPane.add(new Label("-$ 188.051,88"),4, 1);

        numeroDeLegajoField.textProperty().addListener((observable, oldValue, newValue) -> {

            StackPane stack = new StackPane();
            anchorPane.getChildren().add(stack);

            AnchorPane.setTopAnchor(stack, 0.0);
            AnchorPane.setBottomAnchor(stack, 0.0);
            AnchorPane.setLeftAnchor(stack, 0.0);
            AnchorPane.setRightAnchor(stack, 0.0);

            GridPane gridPane = new GridPane();
            stack.getChildren().add(gridPane);

            gridPane.setHgap(15);
            gridPane.setVgap(10);
            gridPane.setPadding(new Insets(20));

            ColumnConstraints col1 = new ColumnConstraints();
            col1.setHalignment(HPos.LEFT);

            ColumnConstraints col2 = new ColumnConstraints();
            col2.setHalignment(HPos.LEFT);

            ColumnConstraints col3 = new ColumnConstraints();
            col3.setHalignment(HPos.RIGHT);

            gridPane.getColumnConstraints().addAll(col1, col2, col3);

        });


    }



}
