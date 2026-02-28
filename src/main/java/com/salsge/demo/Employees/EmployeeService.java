package com.salsge.demo.Employees;

import java.sql.Date;
import java.util.Scanner;

import com.salsge.demo.Legajo.Legajo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
    public class EmployeeService {

        @Autowired
        EmployeeRepository employeeRepository;

        public List<Employee> getAllEmployees() {
            return employeeRepository.findAll();
        }

        public List<Employee> getEmployeeByName(String fullName) {
            return employeeRepository.findByFullNameContainingIgnoreCase(fullName);
        }

        public Optional<Employee> getEmployee(Long id) {
            return employeeRepository.findById(id);
        }

        public Employee createEmployee(String employeeFullName) {

            Employee employee = new Employee(employeeFullName);
            return employeeRepository.save(employee);
        }

        public void updateEmployee(Long id, String employeeFullName) {
            Employee employee = getEmployee(id)
                    .orElseThrow(() -> new RuntimeException("Employee not found"));

            employee.setFullName(employeeFullName);

            employeeRepository.save(employee);
        }

    }



