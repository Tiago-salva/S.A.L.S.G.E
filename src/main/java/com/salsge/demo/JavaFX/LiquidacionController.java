package com.salsge.demo.JavaFX;

import com.salsge.demo.Conceptos.Concepto;
import com.salsge.demo.Conceptos.ConceptoService;
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

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@Component
public class LiquidacionController implements Initializable {

    @Autowired
    private LegajoService legajoService;
    @Autowired
    private ConceptoService conceptoService;

    @FXML private AnchorPane anchorPane;
    @FXML private StackPane stackPane;
    @FXML private GridPane gridPane;
    @FXML private TextField numeroDeLegajoField;

    public LiquidacionController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        numeroDeLegajoField.textProperty().addListener((observable, oldValue, newValue) -> {

            Legajo legajo = legajoService.getLegajoCompleteByNumber(newValue).orElseThrow(() -> new RuntimeException("No existe ese legajo"));

            gridPane.add(new Label(legajo.getNumeroDeLegajo()), 0, 0);
            gridPane.add(new Label(legajo.getEmployee().getFullName()), 1, 0);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = legajo.getFechaDeIngreso().format(formatter);
            gridPane.add(new Label(formattedDate),4, 0);

            generateAportesLiquidacion(legajo.getSueldo());

        });

    }

    public void generateAportesLiquidacion(BigDecimal sueldo) {

        List<Concepto> conceptoAportes = conceptoService.getAllConceptosAportes();
        int index = 5;

        DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance(new Locale("es", "AR"));
        format.applyPattern("#,##0.00");

        for (Concepto c : conceptoAportes) {
            gridPane.add(new Label(c.getCodigoConcepto()), 0, index);
            gridPane.add(new Label(c.getConceptoName()), 1, index);

            BigDecimal resultadoFormula = c.calcular(c, sueldo);
            String sueldoFormateado = format.format(resultadoFormula);


            gridPane.add(new Label(sueldoFormateado), 6, index);
            index++;
        }


    }
}
