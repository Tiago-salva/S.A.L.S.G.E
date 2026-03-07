package com.salsge.demo.JavaFX;

import com.salsge.demo.Employees.Employee;
import com.salsge.demo.Employees.EmployeeService;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    @FXML private TextField novLegajoField;
    @FXML private TextField novColaboradorField;
    @FXML private TextField novCodigoField;
    @FXML private TextField novConceptoField;
    @FXML private TextField novHField;
    @FXML private TextField novDField;
    @FXML private TextField novImporteField;

    public NovedadesController() {
    }

    public void renderEmployeeByLegajo() {

        String legajoNumber = novLegajoField.getText();

        Employee employee = employeeService.getEmployeeByLegajo(legajoNumber).orElseThrow(() -> new RuntimeException("No existe empleado con ese legajo"));

        novColaboradorField.setText(employee.getFullName());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        novLegajoField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    renderEmployeeByLegajo();
                }
            }
        });
    }
}
