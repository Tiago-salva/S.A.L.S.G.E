package com.salsge.demo.Novedades;

import com.salsge.demo.Legajo.Legajo;
import com.salsge.demo.Legajo.LegajoRepository;
import com.salsge.demo.Legajo.LegajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
public class NovedadesService {

    @Autowired
    NovedadesRepository novedadesRepository;

    @Autowired
    LegajoService legajoService;

    public void createNovedades(Novedades novedades) {
        novedadesRepository.save(novedades);

        Legajo legajo = legajoService.getLegajoByNumber(novedades.getLegajoNumber()).orElseThrow(() -> new RuntimeException("No existe ningun legajo con ese numero"));

        legajo.setNovedades(novedades);

    }

}
