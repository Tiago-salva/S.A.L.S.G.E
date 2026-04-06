package com.salsge.demo.JavaFX;

import com.salsge.demo.Conceptos.Concepto;
import com.salsge.demo.Conceptos.ConceptoService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    // Create conceptos
    @FXML private TextField conceptoNameField;
    @FXML private TextField conceptoCodigoField;
    @FXML private TextField conceptoTipoField;
    @FXML private Button conceptoButton;
    @FXML private Text notificationText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        conceptoCodigoCol.setCellValueFactory(new PropertyValueFactory<>("codigoConcepto"));
        conceptoNameCol.setCellValueFactory(new PropertyValueFactory<>("conceptoName"));
        conceptoTypeCol.setCellValueFactory(new PropertyValueFactory<>("tipoDeConcepto"));

        conceptoView.setItems(FXCollections.observableArrayList(conceptoService.getAllConceptos()));
    }

    @FXML
    private void createConcepto() {

        Concepto concepto = new Concepto();

        String conceptoName = conceptoNameField.getText();
        String conceptoCodigo = conceptoCodigoField.getText();
        String conceptoTipo = conceptoTipoField.getText();

        if(conceptoName.isEmpty() || conceptoCodigo.isEmpty() || conceptoTipo.isEmpty()) {
            notificationText.setText("No puede haber campos vacios");
            return;
        }

        concepto.setConceptoName(conceptoName);
        concepto.setCodigoConcepto(conceptoCodigo);
        concepto.setTipoDeConcepto(conceptoTipo);

        try {
            conceptoService.createConcepto(concepto);
            notificationText.setText("Concepto creado correctamente");
            conceptoView.setItems(FXCollections.observableArrayList(conceptoService.getAllConceptos()));
        } catch(RuntimeException e) {
            notificationText.setText(e.getMessage());
        }

    }

    @FXML
    private void deleteConcepto() {
        Concepto conceptoSelected = conceptoView.getSelectionModel().getSelectedItem();
        if(conceptoSelected == null) {
            notificationText.setText("There's not concepto selected");
        } else {
            String conceptoSelectedName = conceptoSelected.getConceptoName();

            conceptoService.deleteConcepto(conceptoSelectedName);
            conceptoView.setItems(FXCollections.observableArrayList(conceptoService.getAllConceptos()));
        }

    }

}
