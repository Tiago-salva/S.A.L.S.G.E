package com.salsge.demo.JavaFX;

import com.salsge.demo.Conceptos.Concepto;
import com.salsge.demo.Conceptos.ConceptoService;
import com.salsge.demo.Legajo.Legajo;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class ConceptoController implements Initializable {

    @Autowired
    ConceptoService conceptoService;

    // View conceptos
    @FXML private TableView<Concepto> conceptoView;
    @FXML private TableColumn<Concepto, String> conceptoCodigoCol;
    @FXML private TableColumn<Concepto, String> conceptoNameCol;
    @FXML private TableColumn<Concepto, String> conceptoTypeCol;
    @FXML private TableColumn<Concepto, String> conceptoFormulaCol;

    // Create conceptos
    @FXML private TextField conceptoNameField;
    @FXML private TextField conceptoCodigoField;
    @FXML private TextField conceptoTipoField;
    @FXML private TextField conceptoFormulaField;
    @FXML private Text notificationText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        conceptoCodigoCol.setCellValueFactory(new PropertyValueFactory<>("codigoConcepto"));
        conceptoNameCol.setCellValueFactory(new PropertyValueFactory<>("conceptoName"));
        conceptoTypeCol.setCellValueFactory(new PropertyValueFactory<>("tipoDeConcepto"));
        conceptoFormulaCol.setCellValueFactory(new PropertyValueFactory<>("formula"));

        conceptoView.setItems(FXCollections.observableArrayList(conceptoService.getAllConceptos()));

        conceptoView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                conceptoNameField.setText(newValue.getConceptoName());
                conceptoCodigoField.setText(newValue.getCodigoConcepto());
                conceptoTipoField.setText(newValue.getTipoDeConcepto());
                conceptoFormulaField.setText(newValue.getFormula());
                notificationText.setText("");
            }
        });

    }

    @FXML
    private void createConcepto() {

        Concepto concepto = new Concepto();

        String conceptoName = conceptoNameField.getText();
        String conceptoCodigo = conceptoCodigoField.getText();
        String conceptoTipo = conceptoTipoField.getText();
        String conceptoFormula = conceptoFormulaField.getText();

        if(conceptoName.isEmpty() || conceptoCodigo.isEmpty() || conceptoTipo.isEmpty() || conceptoFormula.isEmpty()) {
            notificationText.setText("No puede haber campos vacios");
            return;
        }

        concepto.setConceptoName(conceptoName);
        concepto.setCodigoConcepto(conceptoCodigo);
        concepto.setTipoDeConcepto(conceptoTipo);
        concepto.setFormula(conceptoFormula);

        try {
            conceptoService.createConcepto(concepto);
            notificationText.setText("Concepto creado correctamente");
            conceptoView.setItems(FXCollections.observableArrayList(conceptoService.getAllConceptos()));
        } catch(RuntimeException e) {
            notificationText.setText(e.getMessage());
        }

    }

    private Concepto getSelectedConcepto() {
        Concepto conceptoSelected = conceptoView.getSelectionModel().getSelectedItem();
        if(conceptoSelected == null) {
            notificationText.setText("There's not concepto selected");
            return null;
        }

        return conceptoSelected;

    }

    @FXML
    private void deleteConcepto() {
        Concepto conceptoSelected = getSelectedConcepto();
        String conceptoSelectedName = conceptoSelected.getConceptoName();

        conceptoService.deleteConcepto(conceptoSelectedName);
        conceptoView.setItems(FXCollections.observableArrayList(conceptoService.getAllConceptos()));

    }

    @FXML
    private void editConcepto() {
        Concepto conceptoSelected = getSelectedConcepto();

        String conceptoName = conceptoNameField.getText();
        String conceptoCodigo = conceptoCodigoField.getText();
        String conceptoTipo = conceptoTipoField.getText();
        String conceptoFormula = conceptoFormulaField.getText();

        if(conceptoName.isEmpty() || conceptoCodigo.isEmpty() || conceptoTipo.isEmpty() || conceptoFormula.isEmpty()) {
            notificationText.setText("No puede haber campos vacios");
        } else {
            conceptoService.editConcepto(conceptoSelected, conceptoName, conceptoCodigo, conceptoTipo, conceptoFormula);
            conceptoView.setItems(FXCollections.observableArrayList(conceptoService.getAllConceptos()));
        }
    }

}
