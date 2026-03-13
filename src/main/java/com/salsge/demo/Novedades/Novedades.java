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

    // Constructores
    public Novedades() {}

    public Novedades(Long id, Integer legajoNumber, String colaborador, String concepto, Integer dias, Integer horas, Integer importe) {
        this.id = id;
        this.legajoNumber = legajoNumber;
        this.colaborador = colaborador;
        this.concepto = concepto;
        this.dias = dias;
        this.horas = horas;
        this.importe = importe;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @Positive Integer getLegajoNumber() {
        return legajoNumber;
    }

    public void setLegajoNumber(@Positive Integer legajoNumber) {
        this.legajoNumber = legajoNumber;
    }

    public @NotBlank String getColaborador() {
        return colaborador;
    }

    public void setColaborador(@NotBlank String colaborador) {
        this.colaborador = colaborador;
    }

    public @NotBlank String getConcepto() {
        return concepto;
    }

    public void setConcepto(@NotBlank String concepto) {
        this.concepto = concepto;
    }

    public @Positive Integer getDias() {
        return dias;
    }

    public void setDias(@Positive Integer dias) {
        this.dias = dias;
    }

    public @Positive Integer getHoras() {
        return horas;
    }

    public void setHoras(@Positive Integer horas) {
        this.horas = horas;
    }

    public @Positive Integer getImporte() {
        return importe;
    }

    public void setImporte(@Positive Integer importe) {
        this.importe = importe;
    }
}
