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
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.Clipboard;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javafx.util.converter.IntegerStringConverter;
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
    @FXML private Text notificationText;

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

        legajoCol.setCellFactory(TextFieldTableCell.forTableColumn());
        colaboradorCol.setCellFactory(TextFieldTableCell.forTableColumn());
        conceptoCol.setCellFactory(ComboBoxTableCell.forTableColumn(conceptoOptions));
        horasCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        diasCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        importeCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    }

    public void clearNovedades() {
        novedadesList.clear();
    }

    private void handlePaste() {

        Map<String, Concepto> conceptoMap = conceptoService.getAllConceptos()
                .stream()
                .collect(Collectors.toMap(
                        c -> c.getConceptoName().toLowerCase(),
                        c -> c
                ));

        Clipboard clipboard = Clipboard.getSystemClipboard();

        if (!clipboard.hasString()) return;

        String text = clipboard.getString();

        String[] rows = text.split("\\R");

        List<String> legajoNumbers = new ArrayList<>();

        for(String row : rows) {
            String[] columns = row.trim().split("\t");

            if(columns.length > 0) {
                legajoNumbers.add(columns[0].trim());
            }
        }

        List<Legajo> legajos = legajoService.getAllLegajosByNumber(legajoNumbers);

        if(legajos == null || legajos.isEmpty()) {
            notificationText.setText("No existen legajos con esos numeros");
            return;
        }

        Map<String, Legajo> legajoMap = legajos.stream()
                .collect(Collectors.toMap(Legajo::getNumeroDeLegajo, l -> l));

        for(String row : rows) {
            String[] columns = row.trim().split("\t");

            Novedad novedad = new Novedad();

            Legajo legajo = legajoMap.get(columns[0]);

            if(legajo == null) {
                notificationText.setText("El legajo con el numero '" + columns[0] + "' no fue encontrado");
                return;
            }

            novedad.setLegajo(legajo);

            novedad.setColaborador(legajo.getEmployee().getFullName());

            Concepto concepto = conceptoMap.get(columns[1].toLowerCase());

            if(concepto == null) {
                notificationText.setText("El concepto con el nombre '" + columns[1] + "' no fue encontrado");
                return;
            } else {
                novedad.setConcepto(concepto);
            }

            if (columns.length > 2) novedad.setHoras(Integer.parseInt(columns[2]));
            if (columns.length > 3) novedad.setDias(Integer.parseInt(columns[3]));
            if (columns.length > 4) novedad.setImporte(Integer.parseInt(columns[4]));

            novedadesList.add(novedad);

        }
    }

    // CRUD
    public void createNovedad() {
        for (Novedad novedadLoop : novedadesList) {

            Novedad novedad = new Novedad();

            novedad.setLegajo(novedadLoop.getLegajo());
            novedad.setColaborador(novedadLoop.getColaborador());
            novedad.setConcepto(novedadLoop.getConcepto());
            novedad.setHoras(novedadLoop.getHoras());
            novedad.setDias(novedadLoop.getDias());
            novedad.setImporte(novedadLoop.getImporte());

            novedadService.createNovedad(novedad);
        }

        clearNovedades();

    }

}
