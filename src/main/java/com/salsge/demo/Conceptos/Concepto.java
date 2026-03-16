package com.salsge.demo.Conceptos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity(name = "concepto")
public class Concepto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotBlank
    private String conceptoName;

    @Column(unique = true, nullable = false)
    @NotBlank
    private String codigoConcepto;

    @Column(unique = true, nullable = false)
    @NotBlank
    private String tipoDeConcepto;
    // Tipos de conceptos
    // Remunerativo
    // No remunerativo
    // Descuento


    public Concepto() {};

    public Concepto(Long id, String codigoConcepto, String conceptoName, String tipoDeConcepto) {
        this.id = id;
        this.codigoConcepto = codigoConcepto;
        this.conceptoName = conceptoName;
        this.tipoDeConcepto = tipoDeConcepto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoConcepto() {
        return codigoConcepto;
    }

    public void setCodigoConcepto(String codigoConcepto) {
        this.codigoConcepto = codigoConcepto;
    }

    public String getConceptoName() {
        return conceptoName;
    }

    public void setConceptoName(String conceptoName) {
        this.conceptoName = conceptoName;
    }

    public String getTipoDeConcepto() {
        return tipoDeConcepto;
    }

    public void setTipoDeConcepto(String tipoDeConcepto) {
        this.tipoDeConcepto = tipoDeConcepto;
    }

    @Override
    public String toString() {
        return this.conceptoName;
    }
}
