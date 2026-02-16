package com.salsge.demo.Legajo;

import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class LegajoController {

    LegajoService legajoService;

    public LegajoController(LegajoService legajoService) {
        this.legajoService = legajoService;
    }

    public void getAllLegajos() {
        List<Legajo> legajos = legajoService.getAllLegajos();

        if(legajos.isEmpty()) {
            System.out.println("There aren't any employees");
        } else {
            System.out.println("\n----- EMPLEADOS -----");

            for(Legajo legajo : legajos) {
                System.out.println(legajo);
            }
        }
    }

    public Optional<Legajo> getLegajo() {
        return legajoService.getLegajo();
    }

    public void createLegajo() {
        legajoService.createLegajo();
    }

    public void updateLegajo() {
        legajoService.updateLegajo();
    }

    public void deleteLegajo() {
        legajoService.deleteLegajo();
    }
}
