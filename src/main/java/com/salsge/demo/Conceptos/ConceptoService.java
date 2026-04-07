package com.salsge.demo.Conceptos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@Service
public class ConceptoService {

    @Autowired
    ConceptoRepository conceptoRepository;

    public List<Concepto> getAllConceptos() {
        return conceptoRepository.findAll();
    };

    public List<Concepto> getAllConceptosAportes() {
        List<String> codigos = List.of("810000", "810001", "810002", "821001", "821002");
        return conceptoRepository.findByCodigoConceptoIn(codigos);
    }

    public boolean existsConcepto(String conceptoName, String codigoConcepto) {
        return conceptoRepository.existsByConceptoNameOrCodigoConcepto(conceptoName, codigoConcepto);
    }

    public void createConcepto(Concepto concepto) {

        boolean conceptoExists = existsConcepto(concepto.getConceptoName(), concepto.getCodigoConcepto());

        if(conceptoExists) {
            throw new RuntimeException("Ya existe un concepto con ese nombre o codigo");
        }

        conceptoRepository.save(concepto);

    }

    @Transactional
    public void deleteConcepto(String conceptoName) {
        conceptoRepository.deleteByConceptoName(conceptoName);
    }

    public void editConcepto(Concepto conceptoSelected, String conceptoName, String conceptoCodigo, String conceptoTipo, String conceptoFormula) {

        conceptoSelected.setConceptoName(conceptoName);
        conceptoSelected.setCodigoConcepto(conceptoCodigo);
        conceptoSelected.setTipoDeConcepto(conceptoTipo);
        conceptoSelected.setFormula(conceptoFormula);

        conceptoRepository.save(conceptoSelected);

    }
}
