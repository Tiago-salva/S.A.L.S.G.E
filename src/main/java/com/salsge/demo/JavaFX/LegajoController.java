package com.salsge.demo.JavaFX;

import com.salsge.demo.Employees.Employee;
import com.salsge.demo.Legajo.Legajo;
import com.salsge.demo.Legajo.LegajoService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class LegajoController {

    Employee employee;
    @Autowired
    LegajoService legajoService;

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

    public void buildLegajoFromForm() {
        Legajo legajo = new Legajo();

        legajo.setEmployee(employee);
        legajo.setNumeroDeLegajo(Integer.valueOf(legajoField.getText()));
        legajo.setDireccion(apellidoField.getText());
        legajo.setNumeroDeDireccion(Integer.valueOf(nombreField.getText()));
        legajo.setPiso(Integer.valueOf(direccionField.getText()));
        legajo.setDepto(Integer.valueOf(numeroDireccionField.getText()));
        legajo.setCodigoPostal(pisoField.getText());
        legajo.setLocalidad(deptoField.getText());
        legajo.setDni(codigoPostalField.getText());
        legajo.setCuit(localidadField.getText());
        legajo.setTelefono(cuitField.getText());
        legajo.setTelefonoDeEmergencia(dniField.getText());
        legajo.setEmail(telefonoField.getText());
        legajo.setFechaDeNacimiento(LocalDate.parse(telefonoEmergenciaField.getText()));
        legajo.setFechaDeIngreso(LocalDate.parse(mailField.getText()));
        legajo.setSexo(nacimientoField.getText());
        legajo.setEstadoCivil(sexoField.getText());
        legajo.setCbu(estadoCivilField.getText());
        legajo.setCta(cbuField.getText());
        legajo.setBanco(ctaField.getText());
        legajo.setSueldo(BigDecimal.valueOf(Integer.parseInt(bancoField.getText())));
        legajo.setTipoEmpleado(ingresoField.getText());
        legajo.setConvenio(antiguedadField.getText());
        legajo.setObraSocial(tipoEmpleadoField.getText());

    };


    // Getters and setters
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
