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

    public Optional<Legajo> getLegajo(Long id) {
        return legajoRepository.findById(id);
    }

    public void createLegajo(Long employeeId, Legajo legajoData) {
        // Realizar comprobaciones

        legajoRepository.save(legajoData);
    }

    // Agregar editLegajo en un futuro
}
