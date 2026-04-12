package com.salsge.demo.Conceptos;

import com.salsge.demo.Legajo.Legajo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.math.BigDecimal;

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

    @Column(nullable = false)
    @NotBlank
    private String tipoDeConcepto;
    // Tipos de conceptos
    // Remunerativo
    // No remunerativo
    // Descuento

    @Column
    private String formula;

    public BigDecimal calcular(Concepto concepto, BigDecimal sueldo) {
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();

        context.setVariable("sueldo", sueldo);

        Double result = parser.parseExpression(concepto.getFormula())
                .getValue(context, Double.class);

        return BigDecimal.valueOf(result);
    }

    public Concepto() {};

    public Concepto(Long id, String conceptoName, String codigoConcepto, String tipoDeConcepto, String formula) {
        this.id = id;
        this.conceptoName = conceptoName;
        this.codigoConcepto = codigoConcepto;
        this.tipoDeConcepto = tipoDeConcepto;
        this.formula = formula;
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

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    @Override
    public String toString() {
        return this.conceptoName;
    }
}
