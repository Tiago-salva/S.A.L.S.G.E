package com.salsge.demo.JavaFX;

import com.salsge.demo.Employees.Employee;
import com.salsge.demo.Employees.EmployeeService;
import com.salsge.demo.Novedades.Novedades;
import com.salsge.demo.Novedades.NovedadesService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class NovedadesController implements Initializable {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    NovedadesService novedadesService;

    @FXML private TextField novLegajoField;
    @FXML private TextField novColaboradorField;
    @FXML private ChoiceBox<String> novConceptoField;
    @FXML private TextField novHField;
    @FXML private TextField novDField;
    @FXML private TextField novImporteField;

    // Traer conceptos de la base de datos
    private ObservableList<String> conceptoOptions = FXCollections.observableArrayList("No especificar");

    public NovedadesController() {
    }

    public void renderEmployeeByLegajo() {

        String legajoNumber = novLegajoField.getText();

        Employee employee = employeeService.getEmployeeByLegajo(legajoNumber).orElseThrow(() -> new RuntimeException("No existe empleado con ese legajo"));

        novColaboradorField.setText(employee.getFullName());
    }

    public void clearNovedades() {
        novLegajoField.setText("");
        novColaboradorField.setText("");
        novConceptoField.setValue("");
        novHField.setText("");
        novDField.setText("");
        novImporteField.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        novConceptoField.setItems(conceptoOptions);
        novLegajoField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    renderEmployeeByLegajo();
                }
            }
        });
    }

    // CRUD
    public void createNovedades() {

        Novedades novedades = new Novedades();

        String legajoNumber = novLegajoField.getText();
        Integer colaborador = Integer.valueOf(novColaboradorField.getText());
        String concepto = novConceptoField.getValue();
        Integer horas = Integer.valueOf(novHField.getText());
        Integer dias = Integer.valueOf(novDField.getText());
        Integer importe = Integer.valueOf(novImporteField.getText());

        novedades.setLegajoNumber(Integer.valueOf(legajoNumber));
        novedades.setColaborador(String.valueOf(colaborador));
        novedades.setConcepto(concepto);
        novedades.setHoras(horas);
        novedades.setDias(dias);
        novedades.setImporte(importe);

        novedadesService.createNovedades(novedades);

    }


}
