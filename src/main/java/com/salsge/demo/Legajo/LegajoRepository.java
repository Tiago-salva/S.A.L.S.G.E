package com.salsge.demo.Legajo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LegajoRepository extends JpaRepository<Legajo, Long> {

    Optional<Legajo> findByNumeroDeLegajoContainingIgnoreCase(String legajoNumber);

}
