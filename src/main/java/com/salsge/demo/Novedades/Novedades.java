package com.salsge.demo.Novedades;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class Novedades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Positive
    @Column(nullable = false)
    Integer legajoNumber;

    @NotBlank
    @Column(nullable = false)
    String colaborador;

    @NotBlank
    @Column(nullable = false)
    String concepto;

    @Positive
    @Column(nullable = false)
    Integer dias;

    @Positive
    @Column(nullable = false)
    Integer horas;

    @Positive
    @Column(nullable = false)
    Integer importe;

}
