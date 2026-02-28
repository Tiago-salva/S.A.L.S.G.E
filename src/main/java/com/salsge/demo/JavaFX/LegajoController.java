package com.salsge.demo.JavaFX;

import com.salsge.demo.Employees.Employee;
import com.salsge.demo.Employees.EmployeeService;
import com.salsge.demo.Legajo.Legajo;
import com.salsge.demo.Legajo.LegajoService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class LegajoController {

    Employee employee;
    @Autowired
    LegajoService legajoService;
    @Autowired
    EmployeeService employeeService;

    @FXML
    private TextField legajoField;
    @FXML private TextField apellidoField;
    @FXML private TextField nombreField;
    @FXML private TextField direccionField;
    @FXML private TextField numeroDireccionField;
    @FXML private TextField pisoField;
    @FXML private TextField deptoField;
    @FXML private TextField codigoPostalField;
    @FXML private TextField localidadField;
    @FXML private TextField cuitField;
    @FXML private TextField dniField;
    @FXML private TextField telefonoField;
    @FXML private TextField telefonoEmergenciaField;
    @FXML private TextField mailField;
    @FXML private TextField nacimientoField;
    @FXML private TextField sexoField;
    @FXML private TextField estadoCivilField;
    @FXML private TextField cbuField;
    @FXML private TextField ctaField;
    @FXML private TextField bancoField;
    @FXML private TextField ingresoField;
    @FXML private TextField antiguedadField;
    @FXML private TextField tipoEmpleadoField;
    @FXML private TextField sueldoField;
    @FXML private TextField convenioField;
    @FXML private TextField obraSocialField;

    // Constructor
    public LegajoController() {
    }

    public Legajo buildLegajoFromForm() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Legajo legajo = new Legajo();

        legajo.setEmployee(employee);
        legajo.setNumeroDeLegajo(Integer.valueOf(legajoField.getText()));

        legajo.setLastNames(apellidoField.getText());
        legajo.setNames(nombreField.getText());

        legajo.setDireccion(direccionField.getText());
        legajo.setNumeroDeDireccion(Integer.valueOf(numeroDireccionField.getText()));
        legajo.setPiso(Integer.valueOf(pisoField.getText()));
        legajo.setDepto(Integer.valueOf(deptoField.getText()));
        legajo.setCodigoPostal(codigoPostalField.getText());
        legajo.setLocalidad(localidadField.getText());
        legajo.setDni(dniField.getText());
        legajo.setCuit(cuitField.getText());
        legajo.setTelefono(telefonoField.getText());
        legajo.setTelefonoDeEmergencia(telefonoEmergenciaField.getText());
        legajo.setEmail(mailField.getText());
        legajo.setFechaDeNacimiento(LocalDate.parse(nacimientoField.getText(), formatter));
        legajo.setFechaDeIngreso(LocalDate.parse(ingresoField.getText(), formatter));
        legajo.setSexo(sexoField.getText());
        legajo.setEstadoCivil(estadoCivilField.getText());
        legajo.setCbu(cbuField.getText());
        legajo.setCta(ctaField.getText());
        legajo.setBanco(bancoField.getText());
        legajo.setSueldo(BigDecimal.valueOf(Integer.parseInt(sueldoField.getText())));
        legajo.setTipoEmpleado(tipoEmpleadoField.getText());
        legajo.setConvenio(convenioField.getText());
        legajo.setObraSocial(obraSocialField.getText());

        return legajo;

    };

    public void createLegajo() {
        Legajo legajo = buildLegajoFromForm();

        // Legajo created for first time
        if(employee == null) {
            //Crear el empleado
            String employeeFullName = legajo.getNames() + " " + legajo.getLastNames();
            setEmployee(employeeService.createEmployee(employeeFullName));
        }

        employee.assignLegajo(legajo);

        legajoService.createLegajo(employee.getId(), legajo);
    }

    // Getters and setters
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
