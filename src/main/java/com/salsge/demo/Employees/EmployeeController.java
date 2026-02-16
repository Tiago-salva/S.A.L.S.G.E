package com.salsge.demo.Employees;

import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmployeeController {

    static EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        EmployeeController.employeeService = employeeService;
    }

    public static void getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();

        if(employees.isEmpty()) {
            System.out.println("There aren't any employees");
        } else {
            System.out.println("\n----- EMPLEADOS -----");

            for(Employee employee : employees) {
                System.out.println(employee);
            }
        }

    }

    public static void getEmployee() {
        System.out.println(employeeService.getEmployee());
    }

    public static void createEmployee() {
        employeeService.createEmployee();
    }

    public static void updateEmployee() {
        employeeService.updateEmployee();
    }

    public static void deleteEmployee() {
        employeeService.deleteEmployee();
    }

}
