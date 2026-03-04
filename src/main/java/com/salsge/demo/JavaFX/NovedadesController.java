package com.salsge.demo.JavaFX;

import com.salsge.demo.Employees.Employee;
import com.salsge.demo.Employees.EmployeeService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NovedadesController {

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
}
