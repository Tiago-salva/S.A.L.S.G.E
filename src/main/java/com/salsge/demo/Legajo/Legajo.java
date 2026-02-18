package com.salsge.demo.Legajo;

import com.salsge.demo.Employees.Employee;
import jakarta.persistence.*;

@Entity(name = "legajo")
public class Legajo {

    @Id
    @SequenceGenerator(
            name = "legajo_sequence",
            sequenceName = "legajo_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "legajo_sequence"
    )
    private Long id;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private Integer numeroDeLegajo;
    private String fullName;
    private String name;
    private String lastName;
    private String direccion;
    private Integer codigoPostal;

    public Legajo() {};

    public Legajo(Long id, Employee employee, Integer numeroDeLegajo, String fullName, String name, String lastName, String direccion, Integer codigoPostal) {
        this.id = id;
        this.employee = employee;
        this.numeroDeLegajo = numeroDeLegajo;
        this.fullName = fullName;
        this.name = name;
        this.lastName = lastName;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
    }

    public Legajo(Employee employee, Integer numeroDeLegajo, String fullName, String name, String lastName, String direccion, Integer codigoPostal) {
        this.employee = employee;
        this.numeroDeLegajo = numeroDeLegajo;
        this.fullName = fullName;
        this.name = name;
        this.lastName = lastName;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Integer getNumeroDeLegajo() {
        return numeroDeLegajo;
    }

    public void setNumeroDeLegajo(Integer numeroDeLegajo) {
        this.numeroDeLegajo = numeroDeLegajo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
}
