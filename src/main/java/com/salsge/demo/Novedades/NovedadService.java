package com.salsge.demo.Novedades;

import com.salsge.demo.Conceptos.Concepto;
import com.salsge.demo.Conceptos.ConceptoService;
import com.salsge.demo.Legajo.Legajo;
import com.salsge.demo.Legajo.LegajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Validated
@Service
public class NovedadService {

    @Autowired
    NovedadRepository novedadRepository;

    @Autowired
    LegajoService legajoService;

    @Autowired
    ConceptoService conceptoService;

    public void createNovedad(Novedad novedad) {

        // Legajo legajo = legajoService.getLegajoByNumber(novedad.getLegajo().getNumeroDeLegajo()).orElseThrow(() -> new RuntimeException("No existe ningun legajo con ese numero"));

        // Checkear si el legajo ya tiene una novedad con ese mismo concepto
        Legajo legajo = novedad.getLegajo();
        Concepto concepto = novedad.getConcepto();

        // Obtener novedad con ese mismo legajo y concepto
        Optional<Novedad> existeNovedad = novedadRepository.findByLegajoAndConcepto(legajo, concepto);

        // Si existe, sobreescribir
        if(existeNovedad.isPresent()) {
            Novedad n = existeNovedad.get();
            n.setConcepto(novedad.getConcepto());
            n.setHoras(novedad.getHoras());
            n.setDias(novedad.getDias());
            n.setImporte(novedad.getImporte());
            novedadRepository.save(n);
        }
        // Sino, crearlo
        else {
            novedadRepository.save(novedad);
        }

    }

}
