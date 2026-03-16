package com.salsge.demo.Novedades;

import com.salsge.demo.Conceptos.Concepto;
import com.salsge.demo.Legajo.Legajo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

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
    // Se puede borrar en un futuro
    // Ya lo obtengo a partir de legajo
    private String colaborador;

    @ManyToOne
    @JoinColumn(name = "concepto_id", nullable = false)
    private Concepto concepto;

    @PositiveOrZero
    @Column(nullable = false)
    private Integer dias;

    @PositiveOrZero
    @Column(nullable = false)
    private Integer horas;

    @PositiveOrZero
    @Column(nullable = false)
    private Integer importe;

    // Constructores
    public Novedad() {}

    public Novedad(Long id, Legajo legajo, String colaborador, Concepto concepto, Integer dias, Integer horas, Integer importe) {
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

    public Concepto getConcepto() {
        return concepto;
    }

    public void setConcepto(Concepto concepto) {
        this.concepto = concepto;
    }

    public @PositiveOrZero Integer getDias() {
        return dias;
    }

    public void setDias(@PositiveOrZero Integer dias) {
        this.dias = dias;
    }

    public @PositiveOrZero Integer getHoras() {
        return horas;
    }

    public void setHoras(@PositiveOrZero Integer horas) {
        this.horas = horas;
    }

    public @PositiveOrZero Integer getImporte() {
        return importe;
    }

    public void setImporte(@PositiveOrZero Integer importe) {
        this.importe = importe;
    }
}
