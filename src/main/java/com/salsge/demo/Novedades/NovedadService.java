package com.salsge.demo.Novedades;

import com.salsge.demo.Conceptos.Concepto;
import com.salsge.demo.Legajo.Legajo;
import com.salsge.demo.Legajo.LegajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
public class NovedadService {

    @Autowired
    NovedadRepository novedadRepository;

    @Autowired
    LegajoService legajoService;

    public void createNovedad(Novedad novedad) {

        // Esta linea no tendria que servir para nada
        // Ya que al pegar en la TableView checkea si existe algun legajo con el numero pegado
        Legajo legajo = legajoService.getLegajoByNumber(novedad.getLegajo().getNumeroDeLegajo()).orElseThrow(() -> new RuntimeException("No existe ningun legajo con ese numero"));

        novedadRepository.save(novedad);

    }

}
