package com.salsge.demo.JavaFX;

import com.salsge.demo.Conceptos.Concepto;
import com.salsge.demo.Conceptos.ConceptoService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConceptoController {

    @Autowired
    ConceptoService conceptoService;

    @FXML private TextField conceptoNameField;
    @FXML private TextField conceptoCodigoField;
    @FXML private TextField conceptoTipoField;
    @FXML private Button conceptoButton;

    @FXML
    private void createConcepto() {

        Concepto concepto = new Concepto();

        String conceptoName = conceptoNameField.getText();
        String conceptoCodigo = conceptoCodigoField.getText();
        String conceptoTipo = conceptoTipoField.getText();

        concepto.setConceptoName(conceptoName);
        concepto.setCodigoConcepto(conceptoCodigo);
        concepto.setTipoDeConcepto(conceptoTipo);

        conceptoService.createConcepto(concepto);

    }

}
