package com.salsge.demo.JavaFX;

import com.salsge.demo.Conceptos.Concepto;
import com.salsge.demo.Conceptos.ConceptoService;
import com.salsge.demo.Legajo.Legajo;
import com.salsge.demo.Legajo.LegajoService;
import com.salsge.demo.Novedades.Novedad;
import com.salsge.demo.Novedades.NovedadService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.Clipboard;
import javafx.scene.input.KeyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class NovedadesController implements Initializable {

    @Autowired
    LegajoService legajoService;

    @Autowired
    ConceptoService conceptoService;

    @Autowired
    NovedadService novedadService;

    @FXML private TableView<Novedad> tableNovedades;

    @FXML private TableColumn<Novedad, String> legajoCol;
    @FXML private TableColumn<Novedad, String> colaboradorCol;
    @FXML private TableColumn<Novedad, Concepto> conceptoCol;
    @FXML private TableColumn<Novedad, Integer> horasCol;
    @FXML private TableColumn<Novedad, Integer> diasCol;
    @FXML private TableColumn<Novedad, Integer> importeCol;

    ObservableList<Novedad> novedadesList = FXCollections.observableArrayList();

    private ObservableList<Concepto> conceptoOptions;

    public NovedadesController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        conceptoOptions =  FXCollections.observableArrayList(conceptoService.getAllConceptos());

        tableNovedades.setEditable(true);
        tableNovedades.setItems(novedadesList);

        tableNovedades.setOnKeyPressed(event -> {

            if (event.isControlDown() && event.getCode() == KeyCode.V) {
                handlePaste();
            }

        });

        legajoCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getLegajo().getNumeroDeLegajo())
        );

        colaboradorCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(
                        cellData.getValue().getLegajo().getEmployee().getFullName()
                )
        );

        conceptoCol.setCellValueFactory(new PropertyValueFactory<>("concepto"));
        horasCol.setCellValueFactory(new PropertyValueFactory<>("horas"));
        diasCol.setCellValueFactory(new PropertyValueFactory<>("dias"));
        importeCol.setCellValueFactory(new PropertyValueFactory<>("importe"));

//        legajoCol.setCellFactory(TextFieldTableCell.forTableColumn());
//        colaboradorCol.setCellFactory(TextFieldTableCell.forTableColumn());
//        conceptoCol.setCellFactory(ComboBoxTableCell.forTableColumn(conceptoOptions));
//        horasCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
//        diasCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
//        importeCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    }

    private void handlePaste() {

        Clipboard clipboard = Clipboard.getSystemClipboard();

        if (!clipboard.hasString()) return;

        String text = clipboard.getString();

        String[] rows = text.split("\\R");

        List<String> legajoNumbers = new ArrayList<>();

        for(String row : rows) {
            String[] columns = row.split("\\t");

            if(columns.length > 0) {
                legajoNumbers.add(columns[0].trim());
            }
        }

        List<Legajo> legajos = legajoService.getAllLegajosByNumber(legajoNumbers);

        Map<String, Legajo> legajoMap = legajos.stream()
                .collect(Collectors.toMap(Legajo::getNumeroDeLegajo, l -> l));

        for(String row : rows) {
            String[] columns = row.split("\\t");

            Novedad novedad = new Novedad();

            Legajo legajo = legajoMap.get(columns[0]);

            if(legajo == null) {
                throw new RuntimeException("Legajo no encontrado " + columns[0]);
            }

            novedad.setLegajo(legajo);

            if (columns.length > 1) novedad.setConcepto(columns[1]);
            if (columns.length > 2) novedad.setHoras(Integer.parseInt(columns[2]));
            if (columns.length > 3) novedad.setDias(Integer.parseInt(columns[3]));
            if (columns.length > 4) novedad.setImporte(Integer.parseInt(columns[4]));

            novedadesList.add(novedad);

        }
    }


}
