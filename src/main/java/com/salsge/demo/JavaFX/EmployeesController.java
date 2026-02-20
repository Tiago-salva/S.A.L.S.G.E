package com.salsge.demo.JavaFX;

import com.salsge.demo.Employees.Employee;
import com.salsge.demo.Employees.EmployeeService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmployeesController {

    EmployeeService employeeService = new EmployeeService();

    @FXML private TableView<Employee> allEmployeesView;
    @FXML private TableColumn<Employee, Integer> colId;
    @FXML private TableColumn<Employee, String> colName;
    @FXML private TableColumn<Employee, String> colLastname;
    @FXML private TableColumn<Employee, Integer> colAge;
    @FXML private TableColumn<Employee, Integer> colSalary;

    @FXML
    public void renderAllEmployees(ActionEvent event) {

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        colLastname.setCellValueFactory(new PropertyValueFactory<>("age"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("estadoCivil"));

        allEmployeesView.setItems(FXCollections.observableArrayList(employeeService.getAllEmployees()));

    }

}
