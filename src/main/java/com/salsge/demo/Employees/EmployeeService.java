package com.salsge.demo.Employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

    @Validated
    @Service
    public class EmployeeService {

        @Autowired
        EmployeeRepository employeeRepository;

        public List<Employee> getAllEmployees() {
            return employeeRepository.findAll();
        }

        public List<Employee> getAllEmployeesByName(String fullName) {
            return employeeRepository.findByFullNameContainingIgnoreCase(fullName);
        }

        public List<Employee> getAllEmployeesByLegajo(String legajoNumber) {
            return employeeRepository.findDistinctByLegajoNumeroDeLegajoContaining(legajoNumber);
        }

        public Optional<Employee> getEmployee(Long id) {
            return employeeRepository.findById(id);
        }

        public Employee createEmployee(String employeeFullName) {

            Employee employee = new Employee(employeeFullName);
            return employeeRepository.save(employee);
        }

        public void editEmployee(Long id, String employeeFullName) {
            Employee employee = getEmployee(id)
                    .orElseThrow(() -> new RuntimeException("Employee not found"));

            employee.setFullName(employeeFullName);

            employeeRepository.save(employee);
        }

    }



