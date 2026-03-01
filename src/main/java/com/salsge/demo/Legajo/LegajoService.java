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

    public void editLegajo(Long legajoId, Legajo legajoData) {
        Legajo legajo = getLegajo(legajoId).orElseThrow(() -> new RuntimeException("Legajo not found"));

        legajo.setNumeroDeLegajo(legajoData.getNumeroDeLegajo());
        legajo.setLastNames(legajoData.getLastNames());
        legajo.setNames(legajoData.getNames());
        legajo.setDireccion(legajoData.getDireccion());
        legajo.setNumeroDeDireccion(legajoData.getNumeroDeDireccion());
        legajo.setPiso(legajoData.getPiso());
        legajo.setDepto(legajoData.getDepto());
        legajo.setCodigoPostal(legajoData.getCodigoPostal());
        legajo.setLocalidad(legajoData.getLocalidad());
        legajo.setDni(legajoData.getDni());
        legajo.setCuit(legajoData.getCuit());
        legajo.setTelefono(legajoData.getTelefono());
        legajo.setTelefonoDeEmergencia(legajoData.getTelefonoDeEmergencia());
        legajo.setEmail(legajoData.getEmail());
        legajo.setFechaDeNacimiento(legajoData.getFechaDeNacimiento());
        legajo.setFechaDeIngreso(legajoData.getFechaDeIngreso());
        legajo.setSexo(legajoData.getSexo());
        legajo.setEstadoCivil(legajoData.getEstadoCivil());
        legajo.setCbu(legajoData.getCbu());
        legajo.setCta(legajoData.getCta());
        legajo.setBanco(legajoData.getBanco());
        legajo.setSueldo(legajoData.getSueldo());
        legajo.setTipoEmpleado(legajoData.getTipoEmpleado());
        legajo.setConvenio(legajoData.getConvenio());
        legajo.setObraSocial(legajoData.getObraSocial());

        legajoRepository.save(legajo);

    }
}
