package com.salsge.demo.Employees;

import java.sql.Date;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
    public class EmployeeService {

        @Autowired
        EmployeeRepository employeeRepository;

        Scanner sn = new Scanner(System.in);

        public List<Employee> getAllEmployees() {
            return employeeRepository.findAll();
        }

        public List<Employee> getEmployeeByName(String fullName) {
            return employeeRepository.findByFullNameContainingIgnoreCase(fullName);
        }

        public Optional<Employee> getEmployee() {
            System.out.print("Ingrese el id del empleado: ");
            Long employeeId = (long) sn.nextInt();
            return employeeRepository.findById(employeeId);
        }

        public void createEmployee() {
            System.out.print("Ingrese el nombre completo del empleado: ");
            String employeeFullName = sn.next();

            System.out.print("Ingrese la edad del empleado: ");
            int employeeAge = sn.nextInt();

            System.out.print("Ingrese la fecha de nacimiento del empleado: ");
            Date dateOfBirth = Date.valueOf(sn.next());

            System.out.print("Ingrese el estado civil del empleado: ");
            String estadoCivil = sn.next();

            System.out.print("Ingrese el sexo del empleado: ");
            String sexo = sn.next();

            //Employee employee = new Employee(employeeFullName, employeeAge, dateOfBirth, estadoCivil, sexo);
            //employeeRepository.save(employee);
        }

        public void updateEmployee() {
            Employee employee = getEmployee()
                    .orElseThrow(() -> new RuntimeException("Employee not found"));

            System.out.print("Ingrese el nombre completo del empleado: ");
            String employeeFullName = sn.next();

            System.out.print("Ingrese la edad del empleado: ");
            int employeeAge = sn.nextInt();

            System.out.print("Ingrese la fecha de nacimiento del empleado: ");
            Date dateOfBirth = Date.valueOf(sn.next());

            System.out.print("Ingrese el estado civil del empleado: ");
            String estadoCivil = sn.next();

            System.out.print("Ingrese el sexo del empleado: ");
            String sexo = sn.next();

            //employee.setFullName(employeeFullName);
            //employee.setAge(employeeAge);
            //employee.setFechaNacimiento(dateOfBirth);
            //employee.setEstadoCivil(estadoCivil);
            //employee.setSexo(sexo);

            employeeRepository.save(employee);
        }

    }



