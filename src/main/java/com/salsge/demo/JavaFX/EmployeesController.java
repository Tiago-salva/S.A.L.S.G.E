package com.salsge.demo.JavaFX;

import com.salsge.demo.Employees.Employee;
import com.salsge.demo.Employees.EmployeeService;
import com.salsge.demo.Legajo.LegajoService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class EmployeesController {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    LegajoService legajoService;

    @FXML private TableView<Employee> allEmployeesView;
    @FXML private TableColumn<Employee, String> colFullName;
    @FXML private TextField employeeName;
    @FXML private TextField legajoNumber;
    @FXML private StackPane legajoContainer;

    private void loadLegajoView(Employee employee) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Legajo.fxml"));
            loader.setControllerFactory(applicationContext::getBean);

            Parent view = loader.load();

            LegajoController controller = loader.getController();
            controller.setEmployee(employee);

            legajoContainer.getChildren().setAll(view);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Overloaded function without Employee parameter
    private void loadLegajoView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Legajo.fxml"));
            loader.setControllerFactory(applicationContext::getBean);

            Parent view = loader.load();

            LegajoController controller = loader.getController();

            legajoContainer.getChildren().setAll(view);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Render all employees using their full name
    @FXML
    public void renderAllEmployeesByName(String employeeFullName) {
        colFullName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        allEmployeesView.setItems(FXCollections.observableArrayList(employeeService.getAllEmployeesByName(employeeFullName)));
    }

    // Render all employees using their legajo number
    @FXML
    public void renderAllEmployeesByLegajo(String legajoNumber) {
        colFullName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        allEmployeesView.setItems(FXCollections.observableArrayList(employeeService.getAllEmployeesByLegajo(legajoNumber)));
    }

    // Function that starts when the view loaded
    @FXML
    public void initialize() {
        loadLegajoView();

        // Event listener for the fullName textfield
        // Search employees containing the same letters as the textField
        employeeName.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
            renderAllEmployeesByName(newValue);
        });

        // Event listener for the legajo nunmber textfield
        // Find employees containing the same legajo numbers as the textField
        legajoNumber.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
            renderAllEmployeesByLegajo(newValue);
        });

        // Event listener for the columns of the tableview
        allEmployeesView.getSelectionModel().selectedItemProperty()
                .addListener((obs, oldEmp, newEmp) -> {
                    if (newEmp != null) {
                        loadLegajoView(newEmp);
                    }
                });

    }

}
