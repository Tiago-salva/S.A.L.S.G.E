package com.salsge.demo.Conceptos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Validated
@Service
public class ConceptoService {

    @Autowired
    ConceptoRepository conceptoRepository;

    public List<Concepto> getAllConceptos() {
        return conceptoRepository.findAll();
    };

    public void createConcepto(Concepto concepto) {

        conceptoRepository.save(concepto);

    }

}
