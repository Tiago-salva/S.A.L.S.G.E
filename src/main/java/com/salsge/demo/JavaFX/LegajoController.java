package com.salsge.demo.JavaFX;

import com.salsge.demo.Categorias.Categoria;
import com.salsge.demo.Categorias.CategoriaService;
import com.salsge.demo.Employees.Employee;
import com.salsge.demo.Employees.EmployeeService;
import com.salsge.demo.Legajo.Legajo;
import com.salsge.demo.Legajo.LegajoService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

@Component
public class LegajoController implements Initializable {

    Employee employee;
    @Autowired
    LegajoService legajoService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    CategoriaService categoriaService;

    @FXML private Text notificationText;

    @FXML private TextField legajoField;
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
    @FXML private DatePicker nacimientoField;

    @FXML private ChoiceBox<String> sexoField;
    @FXML private ChoiceBox<String> estadoCivilField;

    private ObservableList<String> sexoOptions = FXCollections.observableArrayList("Masculino", "Femenino", "No especificar");
    private ObservableList<String> estadoCivilOptions = FXCollections.observableArrayList("Casado/a", "Soltero/a", "Viudo/a", "No especificar");
    private ObservableList<Categoria> categoriaOptions;

    @FXML private TextField cbuField;
    @FXML private TextField ctaField;
    @FXML private TextField bancoField;
    @FXML private DatePicker ingresoField;
    @FXML private Text antiguedadEmpresaField;
    @FXML private TextField antiguedadReconocidaField;
    @FXML private TextField tipoEmpleadoField;
    @FXML private TextField sueldoField;
    @FXML private TextField convenioField;
    @FXML private TextField obraSocialField;

    @FXML private TextField puestoField;
    @FXML private ChoiceBox<Categoria> categoriaField;
    @FXML private TextField areaField;
    @FXML private TextField codActividadField;
    @FXML private TextField codCondicionField;
    @FXML private TextField codIncapacidadField;
    @FXML private TextField situacionRevistaField;
    @FXML private TextField codZonaField;
    @FXML private TextField modalidadTrabajoField;

    // Constructor
    public LegajoController() {
    }

    private static final DecimalFormat MONEY_FORMAT =
            new DecimalFormat("#0.00");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sexoField.setItems(sexoOptions);
        estadoCivilField.setItems(estadoCivilOptions);

        categoriaOptions = FXCollections.observableArrayList(categoriaService.getAllCategorias());
        categoriaField.setItems(categoriaOptions);
    }

    public Legajo buildLegajoFromForm() throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Legajo legajo = new Legajo();

        legajo.setNumeroDeLegajo(legajoField.getText());

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
        legajo.setFechaDeNacimiento(nacimientoField.getValue());
        legajo.setFechaDeIngreso(ingresoField.getValue());
        legajo.setAntiguedadReconocida(Integer.valueOf(antiguedadReconocidaField.getText()));
        legajo.setSexo(sexoField.getValue());
        legajo.setEstadoCivil(estadoCivilField.getValue());
        legajo.setCbu(cbuField.getText());
        legajo.setCta(ctaField.getText());
        legajo.setBanco(bancoField.getText());
        legajo.setSueldo(new BigDecimal(sueldoField.getText()));
        legajo.setTipoEmpleado(tipoEmpleadoField.getText());
        legajo.setConvenio(convenioField.getText());
        legajo.setObraSocial(obraSocialField.getText());

        legajo.setPuesto(puestoField.getText());
        legajo.setCategoria(categoriaField.getValue());
        legajo.setArea(areaField.getText());
        legajo.setCodigoActividad(Integer.valueOf(codActividadField.getText()));
        legajo.setCodigoCondicion(Integer.valueOf(codCondicionField.getText()));
        legajo.setCodigoIncapacidad(Integer.valueOf(codIncapacidadField.getText()));
        legajo.setSituacionRevista(situacionRevistaField.getText());
        legajo.setCodigoZona(Integer.valueOf(codZonaField.getText()));
        legajo.setModalidadTrabajo(modalidadTrabajoField.getText());

        return legajo;

    };

    public void createLegajo() throws ParseException {
        try {
            Legajo legajo = buildLegajoFromForm();

            legajoService.createLegajo(legajo);

        } catch(DuplicateKeyException e) {
            notificationText.setText(e.getMessage());
        }
    }

    public void editLegajo() throws ParseException {
         // If there's a employee selected, then the legajo exists
            if(employee != null) {

                // Get id of the legajo to edit
                Legajo legajo = employee.getLegajo();
                Long legajoId = legajo.getId();

                // Get the new legajo data
                Legajo legajoData = buildLegajoFromForm();

                legajoService.editLegajo(legajoId, legajoData);

                // Refresh the employee data
                Long employeeId = employee.getId();
                String employeeFullName = legajoData.getNames() + " " + legajoData.getLastNames();

                employeeService.editEmployee(employeeId, employeeFullName);

            } else {
                notificationText.setText("There's no legajo selected to edit, first select one");
            }
    }

    public void clearLegajo() {
        setEmployee(null);

        notificationText.setText("");

        legajoField.setText("");
        apellidoField.setText("");
        nombreField.setText("");
        direccionField.setText("");
        numeroDireccionField.setText("");
        pisoField.setText("");
        deptoField.setText("");
        codigoPostalField.setText("");
        localidadField.setText("");
        cuitField.setText("");
        dniField.setText("");
        telefonoField.setText("");
        telefonoEmergenciaField.setText("");
        mailField.setText("");
        nacimientoField.setValue(null);
        sexoField.setValue("");
        estadoCivilField.setValue("");
        cbuField.setText("");
        ctaField.setText("");
        bancoField.setText("");
        ingresoField.setValue(null);
        antiguedadEmpresaField.setText("");
        antiguedadReconocidaField.setText("");
        tipoEmpleadoField.setText("");
        sueldoField.setText("");
        convenioField.setText("");
        obraSocialField.setText("");

        puestoField.setText("");
        categoriaField.getSelectionModel().clearSelection();
        areaField.setText("");
        codActividadField.setText("");
        codCondicionField.setText("");
        codIncapacidadField.setText("");
        situacionRevistaField.setText("");
        codZonaField.setText("");
        modalidadTrabajoField.setText("");

    }

    public void loadData() {
        if (employee == null || employee.getLegajo() == null) return;

        Legajo legajo = employee.getLegajo();

        legajoField.setText(String.valueOf(legajo.getNumeroDeLegajo()));
        apellidoField.setText(legajo.getLastNames());
        nombreField.setText(legajo.getNames());
        direccionField.setText(legajo.getDireccion());
        numeroDireccionField.setText(String.valueOf(legajo.getNumeroDeDireccion()));
        pisoField.setText(String.valueOf(legajo.getPiso()));
        deptoField.setText(String.valueOf(legajo.getDepto()));
        codigoPostalField.setText(legajo.getCodigoPostal());
        localidadField.setText(legajo.getLocalidad());
        cuitField.setText(legajo.getCuit());
        dniField.setText(legajo.getDni());
        telefonoField.setText(legajo.getTelefono());
        telefonoEmergenciaField.setText(legajo.getTelefonoDeEmergencia());
        mailField.setText(legajo.getEmail());
        nacimientoField.setValue(legajo.getFechaDeNacimiento());
        sexoField.setValue(legajo.getSexo());
        estadoCivilField.setValue(legajo.getEstadoCivil());
        cbuField.setText(legajo.getCbu());
        ctaField.setText(legajo.getCta());
        bancoField.setText(legajo.getBanco());
        ingresoField.setValue(legajo.getFechaDeIngreso());
        antiguedadEmpresaField.setText(String.valueOf((Period.between(legajo.getFechaDeIngreso(), LocalDate.now()).getYears())));
        antiguedadReconocidaField.setText(String.valueOf(legajo.getAntiguedadReconocida()));
        tipoEmpleadoField.setText(legajo.getTipoEmpleado());
        sueldoField.setText(String.valueOf(legajo.getSueldo()));
        convenioField.setText(legajo.getConvenio());
        obraSocialField.setText(legajo.getObraSocial());

        puestoField.setText(legajo.getPuesto());
        categoriaField.setValue(legajo.getCategoria());
        areaField.setText(legajo.getArea());
        codActividadField.setText(String.valueOf(legajo.getCodigoActividad()));
        codCondicionField.setText(String.valueOf(legajo.getCodigoCondicion()));
        codIncapacidadField.setText(String.valueOf(legajo.getCodigoIncapacidad()));
        situacionRevistaField.setText(legajo.getSituacionRevista());
        codZonaField.setText(String.valueOf(legajo.getCodigoZona()));
        modalidadTrabajoField.setText(legajo.getModalidadTrabajo());
    }

    // Getters and setters
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
        loadData();
    }
}
