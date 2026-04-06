package com.salsge.demo.Legajo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LegajoRepository extends JpaRepository<Legajo, Long> {

    Optional<Legajo> findByNumeroDeLegajoContainingIgnoreCase(String legajoNumber);

    List<Legajo> findByNumeroDeLegajoIn(List<String> legajoNumbers);

    @Query("""
        SELECT le FROM legajo le
        JOIN FETCH le.employee
        LEFT JOIN FETCH le.novedades n
        LEFT JOIN FETCH n.concepto
        WHERE le.numeroDeLegajo = :numeroDeLegajo
    """)
    Optional<Legajo> findCompleteById(String numeroDeLegajo);

}
