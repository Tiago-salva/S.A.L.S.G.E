package com.salsge.demo.Conceptos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConceptoRepository extends JpaRepository<Concepto, Long> {

    boolean existsByConceptoNameOrCodigoConcepto(String conceptoName, String codigoConcepto);

    void deleteByConceptoName(String conceptoName);

    List<Concepto> findByCodigoConceptoIn(List<String> codigos);

}
