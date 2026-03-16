package com.salsge.demo.Novedades;

import com.salsge.demo.Conceptos.Concepto;
import com.salsge.demo.Legajo.Legajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NovedadRepository extends JpaRepository<Novedad, Long> {

    Optional<Novedad> findByLegajoAndConcepto(Legajo legajo, Concepto concepto);

}
