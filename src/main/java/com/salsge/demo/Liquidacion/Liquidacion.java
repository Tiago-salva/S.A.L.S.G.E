package com.salsge.demo.Liquidacion;

import com.salsge.demo.Legajo.Legajo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
public class Liquidacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "legajo_id", nullable = false)
    private Legajo legajo;

    @NotBlank
    @Column(nullable = false)
    private String employeeFullName;

    @Positive
    @Column(nullable = false)
    private Integer employeeSalary;

    // Constructors
    public Liquidacion() {
    }

    public Liquidacion(Long id, Legajo legajo, String employeeFullName, Integer employeeSalary) {
        this.id = id;
        this.legajo = legajo;
        this.employeeFullName = employeeFullName;
        this.employeeSalary = employeeSalary;
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

    public @NotBlank String getEmployeeFullName() {
        return employeeFullName;
    }

    public void setEmployeeFullName(@NotBlank String employeeFullName) {
        this.employeeFullName = employeeFullName;
    }

    public @Positive Integer getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(@Positive Integer employeeSalary) {
        this.employeeSalary = employeeSalary;
    }
}
