package com.salsge.demo.Novedades;

import com.salsge.demo.Legajo.Legajo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity(name = "novedades")
public class Novedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "legajo_id", nullable = false)
    private Legajo legajo;

    @NotBlank
    @Column(nullable = false)
    private String colaborador;

    @NotBlank
    @Column(nullable = false)
    private String concepto;

    @Positive
    @Column(nullable = false)
    private Integer dias;

    @Positive
    @Column(nullable = false)
    private Integer horas;

    @Positive
    @Column(nullable = false)
    private Integer importe;

    // Constructores
    public Novedad() {}

    public Novedad(Long id, Legajo legajo, String colaborador, String concepto, Integer dias, Integer horas, Integer importe) {
        this.id = id;
        this.legajo = legajo;
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

    public Legajo getLegajo() {
        return legajo;
    }

    public void setLegajo(Legajo legajo) {
        this.legajo = legajo;
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
