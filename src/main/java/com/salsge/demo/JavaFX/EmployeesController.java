package com.salsge.demo.JavaFX;

import com.salsge.demo.Employees.Employee;
import com.salsge.demo.Employees.EmployeeService;
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

@Component
public class EmployeesController {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    EmployeeService employeeService;

    @FXML private TableView<Employee> allEmployeesView;
    @FXML private TableColumn<Employee, String> colFullName;
    @FXML private TextField employeeName;
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

    @FXML
    public void renderAllEmployees(String employeeFullName) {
        colFullName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        allEmployeesView.setItems(FXCollections.observableArrayList(employeeService.getEmployeeByName(employeeFullName)));
    }

    @FXML
    public void initialize() {
        employeeName.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
            renderAllEmployees(newValue);
        });

        allEmployeesView.getSelectionModel().selectedItemProperty()
                .addListener((obs, oldEmp, newEmp) -> {
                    if (newEmp != null) {
                        loadLegajoView(newEmp);
                    }
                });

    }

}
