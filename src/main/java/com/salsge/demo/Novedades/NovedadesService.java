package com.salsge.demo.Novedades;

import com.salsge.demo.Legajo.Legajo;
import com.salsge.demo.Legajo.LegajoRepository;
import com.salsge.demo.Legajo.LegajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@Service
public class NovedadesService {

    @Autowired
    NovedadesRepository novedadesRepository;

    @Autowired
    LegajoService legajoService;

    public void createNovedades(String legajoNumber, String colaborador,
                                String concepto, Integer horas,
                                Integer dias, Integer importe) {

        Legajo legajo = legajoService.getLegajoByNumber(legajoNumber).orElseThrow(() -> new RuntimeException("No existe ningun legajo con ese numero"));

        Novedades novedades = new Novedades();

        novedades.setLegajo(legajo);
        novedades.setColaborador(colaborador);
        novedades.setConcepto(concepto);
        novedades.setHoras(horas);
        novedades.setDias(dias);
        novedades.setImporte(importe);

        novedadesRepository.save(novedades);

    }

}
