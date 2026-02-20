package com.salsge.demo.Legajo;

import com.salsge.demo.Employees.Employee;
import com.salsge.demo.Employees.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LegajoService {

    LegajoRepository legajoRepository;
    EmployeeRepository employeeRepository;

    public LegajoService(LegajoRepository legajoRepository, EmployeeRepository employeeRepository) {
        this.legajoRepository = legajoRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<Legajo> getAllLegajos() {
        return legajoRepository.findAll();
    }

    public Optional<Legajo> getLegajo() {
        Long legajoId = 1L;
        return legajoRepository.findById(legajoId);
    }

    public void createLegajo() {
        // Get data from console
        Employee employee = employeeRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        int numeroDeLegajo = 12345678;
        String fullName = "Pepe Largo";
        String name = "Pepe";
        String lastName = "Largo";
        String direccion = "San jose 1113";
        int codigoPostal = 1234;

        Legajo legajo = new Legajo(employee,
                numeroDeLegajo,
                fullName,
                name,
                lastName,
                direccion,
                codigoPostal);

        legajoRepository.save(legajo);

    }

    public void updateLegajo() {
        // Get data from console
        Legajo legajo = legajoRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        // Will be added in a future
        // Employee employee;

        int numeroDeLegajo = 12345678;
        String fullName = "Pepe Largo";
        String name = "Pepe";
        String lastName = "Largo";
        String direccion = "San jose 1113";
        int codigoPostal = 1234;

        // legajo.setEmployee();
        legajo.setNumeroDeLegajo(numeroDeLegajo);
        legajo.setFullName(fullName);
        legajo.setName(name);
        legajo.setLastName(lastName);
        legajo.setDireccion(direccion);
        legajo.setCodigoPostal(codigoPostal);

        legajoRepository.save(legajo);

    }
}
