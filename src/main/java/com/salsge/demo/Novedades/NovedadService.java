package com.salsge.demo.Novedades;

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

    public void createNovedad(String legajoNumber, String colaborador,
                              String concepto, Integer horas,
                              Integer dias, Integer importe) {

        Legajo legajo = legajoService.getLegajoByNumber(legajoNumber).orElseThrow(() -> new RuntimeException("No existe ningun legajo con ese numero"));

        Novedad novedad = new Novedad();

        novedad.setLegajo(legajo);
        novedad.setColaborador(colaborador);
        novedad.setConcepto(concepto);
        novedad.setHoras(horas);
        novedad.setDias(dias);
        novedad.setImporte(importe);

        novedadRepository.save(novedad);

    }

}
