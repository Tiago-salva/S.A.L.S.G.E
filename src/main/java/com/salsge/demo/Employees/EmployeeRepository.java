package com.salsge.demo.Employees;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByFullNameContainingIgnoreCase(String fullName);

    List<Employee> findDistinctByLegajoNumeroDeLegajoContaining(String numeroDeLegajo);

    Optional<Employee> findByLegajoNumeroDeLegajoIgnoreCase(String numeroDeLegajo);

}
