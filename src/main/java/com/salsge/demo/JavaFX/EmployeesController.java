package com.salsge.demo.JavaFX;

import com.salsge.demo.Employees.Employee;
import com.salsge.demo.Employees.EmployeeService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeesController {

    @Autowired
    EmployeeService employeeService;

    @FXML private TableView<Employee> allEmployeesView;
    @FXML private TableColumn<Employee, String> colFullName;
    @FXML private TextField employeeName;

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
    }

}
