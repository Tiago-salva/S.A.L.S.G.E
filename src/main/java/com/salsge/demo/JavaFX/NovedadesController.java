package com.salsge.demo.JavaFX;

import com.salsge.demo.Employees.Employee;
import com.salsge.demo.Employees.EmployeeService;
import com.salsge.demo.Legajo.LegajoService;
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
    LegajoService legajoService;

    @Autowired
    NovedadesService novedadesService;

    @FXML private TextField novLegajoField;
    @FXML private TextField novColaboradorField;
    @FXML private ChoiceBox<String> novConceptoField;
    @FXML private TextField novHField;
    @FXML private TextField novDField;
    @FXML private TextField novImporteField;

    // Traer conceptos de la base de datos
    private ObservableList<String> conceptoOptions = FXCollections.observableArrayList("Ley 19.032 I.N.S.S.J.P. (SAC)", "OBRA SOCIAL", "Ley 22.269 O.S. (SAC)");

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
        String colaborador = novColaboradorField.getText();
        String concepto = novConceptoField.getValue();
        Integer horas = Integer.valueOf(novHField.getText());
        Integer dias = Integer.valueOf(novDField.getText());
        Integer importe = Integer.valueOf(novImporteField.getText());

        novedadesService.createNovedades(legajoNumber, colaborador, concepto, horas, dias, importe);

        clearNovedades();

    }


}
